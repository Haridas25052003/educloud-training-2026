package com.demo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class StudentReportMain {

    public static void main(String[] args) {

        try {

            // Step 1: Create dynamic student list
            List<Student> students = new ArrayList<>();
            students.add(new Student("Haridas", 85));
            students.add(new Student("Amit", 90));
            students.add(new Student("Sneha", 88));

            // Step 2: Wrap list into DataSource
            JRBeanCollectionDataSource dataSource =
                    new JRBeanCollectionDataSource(students);

            // Step 3: Load JRXML
            InputStream reportStream =
                    StudentReportMain.class.getResourceAsStream("/student_report.jrxml");

            // Step 4: Compile
            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportStream);

            // Step 5: Fill
            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(
                            jasperReport,
                            new HashMap<>(),
                            dataSource
                    );

            // Step 6: Export PDF
            JasperExportManager.exportReportToPdfFile(
                    jasperPrint,
                    "student_report.pdf"
            );

            System.out.println("Student PDF generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
