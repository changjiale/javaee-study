package acmBord.bean;

public class AcmerInfoByFile {

    private String uerName;
    private String grade;

    public String getUerName() {
        return uerName;
    }

    public void setUerName(String uerName) {
        this.uerName = uerName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public AcmerInfoByFile() {
        // TODO Auto-generated constructor stub
    }

    public AcmerInfoByFile(String uerName, String grade) {
        super();
        this.uerName = uerName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "AcmerInfoByFile [uerName=" + uerName + ", grade=" + grade + "]";
    }

}
