package builder;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class PdfReportBuilder implements IReportBuilder {

    private Report report = new Report();
    private String filePath = "report.pdf";

    @Override
    public void setHeader(String header) {
        report.setHeader(header);
    }

    @Override
    public void setFooter(String footer) {
        report.setFooter(footer);
    }

    @Override
    public void addSection(String name, String content) {
        report.addSection(name, content);
    }

    @Override
    public void setStyle(ReportStyle style) {
        report.setStyle(style);
    }

    @Override
    public Report getReport() {
        exportPDF();
        return report;
    }

    private void exportPDF() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font font = FontFactory.getFont(FontFactory.HELVETICA, report.style.fontSize, BaseColor.BLACK);

            document.add(new Paragraph(report.header != null ? report.header : "", font));
            document.add(new Paragraph("\n"));

            report.sections.forEach((name, content) -> {
                try {
                    document.add(new Paragraph(name, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
                    document.add(new Paragraph(content, font));
                    document.add(new Paragraph("\n"));
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            });

            document.add(new Paragraph(report.footer != null ? report.footer : "", font));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
