package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class PieChartMain {

    public static void main(String[] args) throws Exception {

        // Step 1: Create Data
        List<Student1> list = new ArrayList<>();

        list.add(new Student1("Haridas", "Java", 5000.0));
        list.add(new Student1("Lokesh", "Spring", 6000.0));
        list.add(new Student1("Ravi", "React", 4500.0));

        // Step 2: Create Data Source
        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(list);

        // Step 3: Load JRXML from resources
        InputStream stream =
                PieChartMain.class.getClassLoader()
                        .getResourceAsStream("Table4.jrxml");

        if (stream == null) {
            throw new RuntimeException("JRXML file not found!");
        }

        // Step 4: Compile
        JasperReport report =
                JasperCompileManager.compileReport(stream);

        // Step 5: Fill Report
        JasperPrint print =
                JasperFillManager.fillReport(
                        report,
                        new HashMap<>(),
                        dataSource
                );

        // Step 6: Export to PDF
        JasperExportManager.exportReportToPdfFile(
                print,
                "CoursePieChart.pdf"
        );

        System.out.println("PDF Generated Successfully!");
    }
}
