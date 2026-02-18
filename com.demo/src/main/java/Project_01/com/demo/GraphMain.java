package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class GraphMain {

    public static void main(String[] args) throws Exception {

        
        List<Mark> list = new ArrayList<>();
        list.add(new Mark("Math", 80));
        list.add(new Mark("Science", 70));
        list.add(new Mark("English", 90));

       
        JRBeanCollectionDataSource ds =
                new JRBeanCollectionDataSource(list);

        
        InputStream stream =
                GraphMain.class.getClassLoader()
                        .getResourceAsStream("GraphReport.jrxml");

        if (stream == null) {
            throw new RuntimeException("JRXML file not found!");
        }

        
        JasperReport report =
                JasperCompileManager.compileReport(stream);

       
        JasperPrint print =
                JasperFillManager.fillReport(report,
                        new HashMap<>(),
                        ds);

       
        JasperExportManager.exportReportToPdfFile(
                print,
                "MarkReport.pdf"
        );

        System.out.println("PDF generated successfully!");
    }
}
