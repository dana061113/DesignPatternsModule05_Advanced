package builder;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class PdfReportBuilder implements IReportBuilder {

    private Report report = new Report();
    private String filePath = "report.pdf";

    public void setHeader(String header) {
        report.setHeader(header);
    }

    public void setFooter(String footer) {
        report.setFooter(footer);
    }

    public void addSection(String name, String content) {
        report.addSection(name, content);
    }

    public void setStyle(ReportStyle style) {
        report.setStyle(style);
    }

    public Report getReport() {
        exportPDF();
        return report;
    }

    // PDF экспорт
    private void exportPDF() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // стильдерді қолдану
            Font font = FontFactory.getFont(FontFactory.HELVETICA, report.style.fontSize, BaseColor.BLACK);
            Paragraph headerPara = new Paragraph(report.style != null ? report.header : "", font);
            document.add(headerPara);
            document.add(new Paragraph("\n"));

            report.sections.forEach((name, content) -> {
                try {
                    Paragraph sectionTitle = new Paragraph(name, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
                    document.add(sectionTitle);
                    Paragraph sectionContent = new Paragraph(content, font);
                    document.add(sectionContent);
                    document.add(new Paragraph("\n"));
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            });

            Paragraph footerPara = new Paragraph(report.footer, font);
            document.add(footerPara);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
