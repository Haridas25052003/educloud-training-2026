package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class StudentChartMain {

    public static void main(String[] args) throws Exception {

        // Step 1: Create Data
        List<Student1> list = new ArrayList<>();

        list.add(new Student1("Haridas", "Java", 5000.0));
        list.add(new Student1("Haridas", "Spring", 6000.0));

        list.add(new Student1("Lokesh", "Java", 4500.0));
        list.add(new Student1("Lokesh", "Spring", 5500.0));

        list.add(new Student1("Ravi", "Java", 4000.0));
        list.add(new Student1("Ravi", "Spring", 5000.0));

       
        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(list);

        
        InputStream stream =
                StudentChartMain.class.getClassLoader()
                        .getResourceAsStream("Table3.jrxml");

        if (stream == null) {
            throw new RuntimeException("JRXML file not found!");
        }

        // Step 4: Compile
        JasperReport report =
                JasperCompileManager.compileReport(stream);

        // Step 5: Fill
        JasperPrint print =
                JasperFillManager.fillReport(
                        report,
                        new HashMap<>(),
                        dataSource
                );

        // Step 6: Export PDF (Auto download in project folder)
        JasperExportManager.exportReportToPdfFile(
                print,
                "StudentCourseChart.pdf"
        );

        System.out.println("PDF Generated Successfully!");
    }
}
