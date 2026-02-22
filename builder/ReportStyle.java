package builder;

public class ReportStyle {
    public String backgroundColor;
    public String fontColor;
    public int fontSize;

    public ReportStyle(String bg, String fontColor, int size) {
        this.backgroundColor = bg;
        this.fontColor = fontColor;
        this.fontSize = size;
    }
}
