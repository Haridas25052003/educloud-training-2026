package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class StudentSubReportMain {

    public static class Student {
        private String name;
        private String city;

        public Student(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() { return name; }
        public String getCity() { return city; }
    }

    public static void main(String[] args) throws Exception {

        List<Student> list = new ArrayList<>();
        list.add(new Student("Haridas", "Mumbai"));
        list.add(new Student("Lokesh", "Pune"));

        JRBeanCollectionDataSource ds =
                new JRBeanCollectionDataSource(list);

        // Compile subreport first
        InputStream subStream =
                StudentSubReportMain.class.getClassLoader()
                        .getResourceAsStream("Table8.jrxml");

        JasperReport subReport =
                JasperCompileManager.compileReport(subStream);

     

        // Compile main report
        InputStream mainStream =
                StudentSubReportMain.class.getClassLoader()
                        .getResourceAsStream("Table9.jrxml");

        JasperReport mainReport =
                JasperCompileManager.compileReport(mainStream);

        JasperPrint print =
                JasperFillManager.fillReport(
                        mainReport,
                        new HashMap<>(),
                        ds
                );

        JasperExportManager.exportReportToPdfFile(
                print,
                "StudentSubReport.pdf"
        );

        System.out.println("PDF Generated Successfully!");
    }
}
