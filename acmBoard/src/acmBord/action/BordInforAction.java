package acmBord.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opensymphony.xwork2.ActionSupport;

import acmBord.bean.AcmerInfo;
import acmBord.bean.ProbleResult;
import acmBord.listenner.DataInitListenner;

public class BordInforAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	/**
	 * 
	 */
	static{
		
	}
	private static final long serialVersionUID = 1L;
	
	//题目的th 信息
	private List<String> subjects = new ArrayList<String>();

	//来自OJ的参数队员信息
	private List<AcmerInfo> acmerInfos = new ArrayList<AcmerInfo>();
	
	//来自文件的参数队员信息
	private Map<String, AcmerInfo> acmerInforsMap = new HashMap<>();
	
	public List<AcmerInfo> getAcmerInfos() {
		return acmerInfos;
	}

	public void setAcmerInfos(List<AcmerInfo> acmerInfos) {
		this.acmerInfos = acmerInfos;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	
	private Integer allSub = 0;//每个参数队员总的提交数
	private Integer rightSub = 0;//每个参数队员总的正确的提交数
	@Override
	public String execute() throws Exception {
		boolean cookieFlag = false;
		boolean minCokie = false;
		boolean maxCoikie = false;
		boolean viewHDCookie = false;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie :cookies ){
			if(cookie.getName().equals("bordFlag")){
				cookie.setMaxAge(1000*60*60);
				cookieFlag = true;
				break;
			}
			if(cookie.getName().equals("minStr")){
                minCokie = true;
                cookie.setMaxAge(1000*60*60);
            }
            if(cookie.getName().equals("maxStr")){
                maxCoikie = true;
                cookie.setMaxAge(1000*60*60);
            }
            if(cookie.getName().endsWith("viewHDCookie")){
            	viewHDCookie = true;
            	cookie.setMaxAge(1000*60*60);
            }
		}
		if(cookieFlag == false){
			Cookie fbCookie = new Cookie("bordFlag", "1");
			fbCookie.setMaxAge(1000*60*60);
			response.addCookie(fbCookie);
		}
		
		if(minCokie == false){
			//String str = "";
			Cookie fbCookie = new Cookie("minStr", "");
			fbCookie.setMaxAge(1000*60*60);
			response.addCookie(fbCookie);
		}
		
		if(maxCoikie == false){
			//String str = "";
			Cookie fbCookie = new Cookie("maxStr", "");
			fbCookie.setMaxAge(1000*60*60);
			response.addCookie(fbCookie);
		}
		if(viewHDCookie == false){
			Cookie fbCookie = new Cookie("viewHDCookie", "1");
			fbCookie.setMaxAge(1000*60*60);
			response.addCookie(fbCookie);
		}
		acmerInforsMap = DataInitListenner.map;
		getAllData();
		return super.execute();
	}
	
	//获取所有信息
	public void getAllData() throws Exception{
		//String url = "http://acm.pdsu.edu.cn/contestrank.php?cid=1011";
		
		Properties properties = new Properties();
		InputStream inStream = getClass().getClassLoader().getResourceAsStream("bordUrl.properties");
		properties.load(inStream);
		//System.out.println(properties.get("url"));
		
        String url = properties.get("url").toString();;
        
		try {
			Document doc = Jsoup.connect(url).get();
			//System.out.println(doc.body().toString());
			
			Elements tableEmts = doc.getElementsByAttributeValue("id", "rank");
			
			for(Element tableEmt : tableEmts){
				
				//获取题目个数
				Elements theadEmts = tableEmt.getElementsByTag("thead");
				
				Element theadEmt = theadEmts.first();
				
				Elements trEmts = theadEmt.getElementsByClass("toprow");
				
				Element trEmt = trEmts.first();
				
				Elements thEmts = trEmt.getElementsByTag("td");
				int proNum = thEmts.size()-1;
				SujectsFill(proNum);
				
				//获取每个参赛队员的信息
				Element tbodyEmt = tableEmt.getElementsByTag("tbody").first();
				Elements tbodyThEmts = tbodyEmt.getElementsByTag("tr");
				//System.out.println(tbodyThEmts.first().getElementsByTag("td").first().text());
				//Object[] ss = tbodyThEmts.toArray();
				int realRank = 1;
				String strRank = "-1";
				Map<String, String> userNameList = new HashMap<>();
				for(Element tbodyThEmt : tbodyThEmts){
					Object[] tbodyThTddEmts = tbodyThEmt.getElementsByTag("td").toArray();
					if(tbodyThTddEmts != null && tbodyThTddEmts.length > 0){
						String rank = ((Element)tbodyThTddEmts[0]).text();
						String name = ((Element)tbodyThTddEmts[1]).text();
						String nickName = ((Element)tbodyThTddEmts[2]).text();
						String solved = ((Element)tbodyThTddEmts[3]).text();
						String time = ((Element)tbodyThTddEmts[4]).text();
						String schoolName = "计算机学院(软件学院)";
						int flag = 1;
						int teamNum = -1;
						nickName = "江湖路人";
						//计算分钟数
						String times[] = time.split(":");
						String timeMin = String.valueOf(Integer.parseInt(times[0])*60+Integer.parseInt(times[1]));
						
						List<ProbleResult> probleResult = getProbleResultData(tbodyThTddEmts);
						
						//在文件中查找url 榜单每个队伍对应的对象，并将这个对于的其余信息补全
						if(acmerInforsMap.containsKey(name)){
							schoolName = acmerInforsMap.get(name).getSchoolName();
							flag = acmerInforsMap.get(name).getFlag();
							teamNum = acmerInforsMap.get(name).getTeamNum();
							nickName = acmerInforsMap.get(name).getNickName();
						}
						String total = String.valueOf(allSub)+"/"+String.valueOf(rightSub);
						AcmerInfo acmerInfo = new AcmerInfo("1", rank, name, nickName, solved, timeMin, schoolName, probleResult, total,flag,teamNum);
						//System.out.println(acmerInfo);
						acmerInfos.add(acmerInfo);
						
						
						//记录所有做题的参赛队员的姓名
						userNameList.put(acmerInfo.getName(), acmerInfo.getName());
						allSub = 0;rightSub = 0;
						strRank = rank;
					}
					
				}
				
				realRank = Integer.valueOf(strRank);
				if(realRank == -1)
				{
					realRank = 1;
				}
				//System.out.println(realRank);
				
				//把 acmerInfo.txt 没有做题的参数队员显示
				for(Map.Entry<String, AcmerInfo> acin : acmerInforsMap.entrySet()){
					AcmerInfo acmerInfoByMap = acin.getValue();
					if(!userNameList.containsKey(acmerInfoByMap.getName())){
						acmerInfoByMap.setProbleResult(getEmptyProbleResults(proNum));
						acmerInfoByMap.setRank(String.valueOf(realRank));
						
						acmerInfos.add(acmerInfoByMap);
						realRank++;
						//System.out.println(realRank);
					}
				}
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取题目信息
	 * @param tbodyThTddEmts
	 * @return
	 */
	private List<ProbleResult> getProbleResultData(Object[] tbodyThTddEmts){
		List<ProbleResult> results = new ArrayList<>();
		for(int i = 5 ; i < tbodyThTddEmts.length ; i++){
			String proName = ((Element)tbodyThTddEmts[i]).text();
			String proColor = ((Element)tbodyThTddEmts[i]).attr("style");
			ProbleResult pr = new ProbleResult(proName, proColor);
			
			
			//计算得到Solved的信息
			if(!proName.equals("") && proName!= null && proName.length() > 0){
				
				if(!proName.startsWith("(")){
					rightSub++;
					allSub++;
					
					   
				}
				int s = proName.indexOf("(");
				int e = proName.indexOf(")");
				if(s!= -1 && e != -1){
					//System.out.println("-->"+proName.substring(s+2, e));
					int erroy = Integer.parseInt(proName.substring(s+2, e));
					allSub+=erroy;
				}
				
			}
			
			results.add(pr);
		}		
		return results;
	}
		
	/**
	 * 获取题目的数量以及信息
	 */
	private void SujectsFill(int proNum){
		
	    for(int i = 0 ; i < proNum ; i++){
	    	char num = (char) ('A'+i);
	    	String proNumStr = String.valueOf(num);
	    	subjects.add(proNumStr);
	    }
		
		subjects.add("Total<br/>att/solved<br/>997/261");
	}
	
	private List<ProbleResult> getEmptyProbleResults(int proNum){
		List<ProbleResult> list = new ArrayList<>();
		for(int i = 0 ; i < proNum ; i++){
			list.add(new ProbleResult("","background-color:#eeeeee"));
		}
		return list;
	}

	private HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response =arg0;
	}

	private HttpServletRequest request; 
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
}
