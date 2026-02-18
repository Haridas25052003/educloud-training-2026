package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseChartMain {

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
                            .getResourceAsStream("course_chart_report.jrxml");

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
                    "course_chart_report.pdf"
            );

            System.out.println("Chart PDF generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
