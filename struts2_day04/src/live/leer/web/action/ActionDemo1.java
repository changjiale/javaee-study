package live.leer.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionDemo1 extends ActionSupport{
	 @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("ActionDemo1启动了----");
		return super.execute();
	}

}
