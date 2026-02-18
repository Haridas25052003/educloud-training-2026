package Project_01.com.demo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class RunReport {


    public static class Marks {
        private String subject;
        private Integer marks;

        public Marks(String subject, Integer marks) {
            this.subject = subject;
            this.marks = marks;
        }

        public String getSubject() { return subject; }
        public Integer getMarks() { return marks; }
    }

    public static void main(String[] args) throws Exception {

       
    	InputStream subStream =
    	        RunReport.class.getResourceAsStream("/sub.jrxml");

    	InputStream mainStream =
    	        RunReport.class.getResourceAsStream("/main.jrxml");

    	JasperReport subReport = JasperCompileManager.compileReport(subStream);
    	JasperReport mainReport = JasperCompileManager.compileReport(mainStream);

    	List<Marks> marksList = Arrays.asList(
    	        new Marks("Math", 85),
    	        new Marks("Science", 90),
    	        new Marks("English", 78),
    	        new Marks("Computer", 95)
    	);

    	JRBeanCollectionDataSource subData =
    	        new JRBeanCollectionDataSource(marksList);

    	Map<String,Object> params = new HashMap<>();
    	params.put("studentName", "Rahul Sharma");
    	params.put("rollNo", "101");
    	params.put("SUBREPORT_OBJ", subReport);
    	params.put("SUBREPORT_DATA_SOURCE", subData);

    	JasperPrint print = JasperFillManager.fillReport(
    	        mainReport,
    	        params,
    	        new JREmptyDataSource()
    	);

    	JasperExportManager.exportReportToPdfFile(print, "student_report.pdf");

        System.out.println("Report Generated!");
    }
}
