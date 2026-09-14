package org.Humana.Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.Humana.Utilities.RandomNumberGenerator;
import org.Humana.Utilities.ScreenShotCaptured;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	Properties properties;
	WebDriver driver;

	public Login(Properties properties, WebDriver driver) {
		this.properties = properties;
		this.driver = driver;
	}

	public void userLogIn(String userName, String password) throws IOException {
		try {
			WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(properties.getProperty("UserName"))));
			driver.findElement(By.xpath(properties.getProperty("UserName"))).sendKeys(userName);
			Thread.sleep(1000);
			driver.findElement(By.xpath(properties.getProperty("Password"))).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.xpath(properties.getProperty("LogIn"))).click();
		} catch (Exception exception) {
			ScreenShotCaptured.takeScreenShot(
					"../AE_Toyota/src/test/java/org/Toyota/ScreenShots/" + RandomNumberGenerator.randomNumber() + ".png",
					driver);
			System.out.println("There is an Exception in Code :" + exception);
		}
	}

}