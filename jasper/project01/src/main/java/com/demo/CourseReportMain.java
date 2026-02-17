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

public class CourseReportMain {

    public static void main(String[] args) {

        try {

            List<Course> courses = new ArrayList<>();
            courses.add(new Course(1, "Java", "Rahul", 15000));
            courses.add(new Course(2, "Spring Boot", "Anita", 20000));
            courses.add(new Course(3, "Angular", "Vikas", 18000));

            JRBeanCollectionDataSource dataSource =
                    new JRBeanCollectionDataSource(courses);

            InputStream reportStream =
                    Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream("course_report.jrxml");

            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportStream);

            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(
                            jasperReport,
                            new HashMap<>(),
                            dataSource
                    );

            JasperExportManager.exportReportToPdfFile(
                    jasperPrint,
                    "course_report.pdf"
            );

            System.out.println("Course PDF generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
