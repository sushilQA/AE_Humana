package org.Humana.Base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.Humana.Utilities.LoadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties properties;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sushil.k\\eclipse-workspace\\AE_Humana\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		this.driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://humana-uat.alerthsc.com/?IsAlertUser=true");
		Thread.sleep(6000);
		this.properties = LoadPropertiesFile.handlePropertyFile("../AE_Humana/ObjectRepositery.properties");
		Thread.sleep(6000);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}