package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports getReport() {

        ExtentSparkReporter spark =
            new ExtentSparkReporter("target/ExtentReport.html");

        spark.config().setReportName("Flipkart Automation");
        spark.config().setDocumentTitle("Execution Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        return extent;
    }
}
