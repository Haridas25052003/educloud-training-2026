package com.example;

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

public class JasperMain {

    public static void main(String[] args) {

        try {

            // Step 1: Prepare Data
            List<User> users = new ArrayList<>();
            users.add(new User("Haridas", 23));
            users.add(new User("Amit", 25));
            users.add(new User("Sneha", 22));

            JRBeanCollectionDataSource dataSource =
                    new JRBeanCollectionDataSource(users);

            // Step 2: Load JRXML file
            InputStream reportStream =
                    JasperMain.class.getResourceAsStream("/report.jrxml");

            // Step 3: Compile Report
            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportStream);

            // Step 4: Fill Report
            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(
                            jasperReport,
                            new HashMap<>(),   // parameters
                            dataSource
                    );

            // Step 5: Export to PDF
            JasperExportManager.exportReportToPdfFile(
                    jasperPrint,
                    "users_report.pdf"
            );

            System.out.println("PDF generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
