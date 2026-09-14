package org.Humana.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateExtentReports {

	public static ExtentReports generateExtentReport() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				"../AE_Humana/test-output/AE_Humana_Report.html");

		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		return extentReports;
	}

}