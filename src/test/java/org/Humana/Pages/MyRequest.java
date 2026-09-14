package org.Humana.Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.Humana.Utilities.RandomNumberGenerator;
import org.Humana.Utilities.ScreenShotCaptured;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyRequest {

	Properties properties;
	WebDriver driver;

	public MyRequest(Properties properties, WebDriver driver) {
		this.properties = properties;
		this.driver = driver;
	}

	public void myRequest(WebDriver driver, Properties properties) throws InterruptedException, IOException {
		try {
			WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("Menue"))));
			driver.findElement(By.xpath(properties.getProperty("Menue"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(properties.getProperty("MenuSearch"))).sendKeys("request");
			Thread.sleep(1000);
			driver.findElement(By.xpath(properties.getProperty("MyRequest"))).click();
			Thread.sleep(100);
			driver.findElement(By.xpath(properties.getProperty("Menue"))).click();
			String PageTitle = driver.getTitle().toString();
			if (PageTitle.contains(properties.getProperty("PageTitle"))) {
				System.out.println("You are land up on My Requests Page");
			} else
				System.out.println("You are land up on a Different Page");
		} catch (Exception exception) {
			ScreenShotCaptured.takeScreenShot("../AE_Toyota/src/test/java/org/Toyota/ScreenShots/"
					+ RandomNumberGenerator.randomNumber() + ".png", driver);
			System.out.println("There is an Exception in Code :" + exception);
		}
	}

}