package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Extentreport {
	
	private static ExtentReports extent;
	public static ExtentReports getReportInstance() {
		 
        if (extent == null) {
 
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("./Reports/ExtentReport.html");
 
            extent = new ExtentReports();
            extent.attachReporter(spark);
 
            extent.setSystemInfo("Tester", "Team F");
            extent.setSystemInfo("Environment", "Stage");
            
        }
		return extent;
	}
}
