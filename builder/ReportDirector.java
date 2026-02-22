package builder;

public class ReportDirector {

    public void constructReport(IReportBuilder builder, ReportStyle style) {
        builder.setHeader("Main Report Header");
        builder.addSection("Introduction", "This is the introduction section of the report.");
        builder.addSection("Content", "Main content goes here...");
        builder.addSection("Conclusion", "Conclusion of the report.");
        builder.setFooter("End of Report");
        builder.setStyle(style);
    }
}
