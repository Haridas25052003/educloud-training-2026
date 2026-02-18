package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class LineChartMain {

    public static void main(String[] args) throws Exception {

        List<MonthData> list = new ArrayList<>();

        list.add(new MonthData("Jan", 5000.0));
        list.add(new MonthData("Feb", 7000.0));
        list.add(new MonthData("Mar", 6000.0));
        list.add(new MonthData("Apr", 9000.0));

        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(list);

        InputStream stream =
                LineChartMain.class.getClassLoader()
                        .getResourceAsStream("Table5.jrxml");

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
                "MonthlyLineChart.pdf"
        );

        System.out.println("PDF Generated Successfully!");
    }
}
