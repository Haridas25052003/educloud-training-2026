package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class Table2Main {

    public static void main(String[] args) throws Exception {

    
        List<Student> list = new ArrayList<>();

        list.add(new Student(1, "Haridas", "Mumbai", 5000.0, "Pass"));
        list.add(new Student(2, "Lokesh", "Pune", 6000.0, "Pass"));
        list.add(new Student(3, "Ravi", "Delhi", 4500.0, "Fail"));

       
        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(list);

       
        InputStream stream =
                Table2Main.class.getClassLoader()
                        .getResourceAsStream("Table2.jrxml");

        if (stream == null) {
            throw new RuntimeException("Table2.jrxml file not found!");
        }

       
        JasperReport report =
                JasperCompileManager.compileReport(stream);

       
        JasperPrint print =
                JasperFillManager.fillReport(
                        report,
                        new HashMap<>(),
                        dataSource
                );

        
        JasperExportManager.exportReportToPdfFile(
                print,
                "StudentGraphReport.pdf"
        );

        System.out.println("PDF Generated Successfully!");
    }
}
