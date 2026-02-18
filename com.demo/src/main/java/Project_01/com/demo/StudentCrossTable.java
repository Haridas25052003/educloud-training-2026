package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class StudentCrossTable {

    public static void main(String[] args) throws Exception {

        List<Student1> list = new ArrayList<>();

        list.add(new Student1("Haridas", "Java", 5000.0));
        list.add(new Student1("Haridas", "Python", 4000.0));
        list.add(new Student1("Lokesh", "Java", 6000.0));
        list.add(new Student1("Ravi", "Spring", 4500.0));

        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(list);

        InputStream stream =
                StudentCrossTable.class.getClassLoader()
                        .getResourceAsStream("Table6.jrxml");

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
                "ProfessionalCrosstabReport.pdf"
        );

        System.out.println("Professional Crosstab PDF Generated Successfully!");
    }
}
