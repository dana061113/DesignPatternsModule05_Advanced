package builder;

public class ReportDirector {

    public void constructReport(IReportBuilder builder, ReportStyle style) {
        builder.setHeader("Main Report Header");
        builder.addSection("Introduction", "Introduction section content...");
        builder.addSection("Content", "Main content goes here...");
        builder.addSection("Conclusion", "Conclusion section content...");
        builder.setFooter("End of Report");
        builder.setStyle(style);
    }
}
