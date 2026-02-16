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

public class EmployeeReportMain {

    public static void main(String[] args) {

        try {

            // Step 1: Create employee list
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(1, "Haridas", "IT", 50000));
            employees.add(new Employee(2, "Amit", "HR", 45000));
            employees.add(new Employee(3, "Sneha", "Finance", 60000));

            // Step 2: Wrap in DataSource
            JRBeanCollectionDataSource dataSource =
                    new JRBeanCollectionDataSource(employees);

            // Step 3: Load JRXML
            InputStream reportStream =
                    Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream("employee_report.jrxml");

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
                    "employee_report.pdf"
            );

            System.out.println("Employee PDF generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
