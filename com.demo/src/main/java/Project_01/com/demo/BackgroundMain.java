package Project_01.com.demo;

import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.util.HashMap;

public class BackgroundMain {

    public static void main(String[] args) throws Exception {

        InputStream stream =
                BackgroundMain.class.getClassLoader()
                        .getResourceAsStream("Table7.jrxml");

        if (stream == null) {
            throw new RuntimeException("JRXML not found!");
        }

        JasperReport report =
                JasperCompileManager.compileReport(stream);

        JasperPrint print =
                JasperFillManager.fillReport(
                        report,
                        new HashMap<>(),
                        new JREmptyDataSource()
                );

        JasperExportManager.exportReportToPdfFile(
                print,
                "BackgroundReport.pdf"
        );

        System.out.println("PDF Generated Successfully!");
    }
}
