package acmBord.bean;

import java.util.List;

public class AcmerInfo {

    private String realRank;

    private String rank;

    private String name;

    private String nickName;

    private String solved;

    private String time;

    private String schoolName;

    private List<ProbleResult> probleResult;

    private String total;

    private Integer flag;//����Ƿ���רҵ��Ϸ�רҵ�飺1Ϊרҵ�飬0Ϊ��רҵ��

    private Integer teamNum;

    public Integer getFlag() {
        return flag;
    }


    public Integer getTeamNum() {
        return teamNum;
    }


    public void setTeamNum(Integer teamNum) {
        this.teamNum = teamNum;
    }


    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRealRank() {
        return realRank;
    }

    public void setRealRank(String realRank) {
        this.realRank = realRank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getSolved() {
        return solved;
    }

    public void setSolved(String solved) {
        this.solved = solved;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public List<ProbleResult> getProbleResult() {
        return probleResult;
    }

    public void setProbleResult(List<ProbleResult> probleResult) {
        this.probleResult = probleResult;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    public AcmerInfo(String realRank, String rank, String name,
                     String nickName, String solved, String time, String schoolName,
                     List<ProbleResult> probleResult, String total, Integer flag,
                     Integer teamNum) {
        super();
        this.realRank = realRank;
        this.rank = rank;
        this.name = name;
        this.nickName = nickName;
        this.solved = solved;
        this.time = time;
        this.schoolName = schoolName;
        this.probleResult = probleResult;
        this.total = total;
        this.flag = flag;
        this.teamNum = teamNum;
    }


    public AcmerInfo(String realRank, String rank, String name,
                     String nickName, String solved, String time, String schoolName,
                     List<ProbleResult> probleResult, String total, Integer flag) {
        super();
        this.realRank = realRank;
        this.rank = rank;
        this.name = name;
        this.nickName = nickName;
        this.solved = solved;
        this.time = time;
        this.schoolName = schoolName;
        this.probleResult = probleResult;
        this.total = total;
        this.flag = flag;
    }

    public AcmerInfo(String realRank, String rank, String name,
                     String nickName, String solved, String time, String schoolName,
                     List<ProbleResult> probleResult, String total) {
        super();
        this.realRank = realRank;
        this.rank = rank;
        this.name = name;
        this.nickName = nickName;
        this.solved = solved;
        this.time = time;
        this.schoolName = schoolName;
        this.probleResult = probleResult;
        this.total = total;
    }

    public AcmerInfo() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "acmerInfo [realRank=" + realRank + ", rank=" + rank + ", name="
                + name + ", nickName=" + nickName + ", Solved=" + solved
                + ", time=" + time + ", probleResult=" + probleResult
                + ", total=" + total + "]";
    }


}
