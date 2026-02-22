package builder;

import java.util.*;

public class Report {

    private String header;
    private String footer;
    private Map<String, String> sections = new LinkedHashMap<>();
    private ReportStyle style;

    public void setHeader(String header) { this.header = header; }
    public void setFooter(String footer) { this.footer = footer; }
    public void addSection(String name, String content) {
        sections.put(name, content);
    }
    public void setStyle(ReportStyle style) { this.style = style; }

    public void export() {
        System.out.println("=== REPORT ===");
        System.out.println("Style: BG=" + style.backgroundColor + 
                           ", Font=" + style.fontColor + 
                           ", Size=" + style.fontSize);
        System.out.println(header);
        sections.forEach((k,v) -> {
            System.out.println("[" + k + "]");
            System.out.println(v);
        });
        System.out.println(footer);
    }
}
