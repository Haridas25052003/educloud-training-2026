package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class TableReport {

    public static void main(String[] args) throws Exception {

        
        List<Student> list = new ArrayList<>();

        list.add(new Student(1,"Haridas","Mumbai",5000.0,"Pass"));
        list.add(new Student(2,"Lokesh","Pune",6000.0,"Pass"));
        list.add(new Student(3,"Ravi","Delhi",4500.0,"Fail"));

        
        JRBeanCollectionDataSource dataSource =
                new JRBeanCollectionDataSource(list);

        
        InputStream reportStream =
                TableReport.class.getClassLoader()
                        .getResourceAsStream("Table1.jrxml");

        if(reportStream == null){
            throw new RuntimeException("JRXML file not found!");
        }

        
        JasperReport report =
                JasperCompileManager.compileReport(reportStream);

        
        JasperPrint print =
                JasperFillManager.fillReport(
                        report,
                        new HashMap<>(),
                        dataSource
                );

       
        JasperExportManager.exportReportToPdfFile(
                print,
                "StudentTableReport.pdf"
        );

        System.out.println("PDF generated successfully!");
    }
}
