package kg.Lessons.Lessona.model;

public class Hello {
    private String isStatus;
    private String text;

    public Hello(String isStatus, String text) {
        this.isStatus = isStatus;
        this.text = text;
    }

    public String getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(String isStatus) {
        this.isStatus = isStatus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
