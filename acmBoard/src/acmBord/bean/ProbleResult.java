package acmBord.bean;


public class ProbleResult {

    private String text;
    private String color;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ProbleResult(String text, String color) {
        super();
        this.text = text;
        this.color = color;
    }

    public ProbleResult() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "peobleResult [text=" + text + ", color=" + color + "]";
    }

}
