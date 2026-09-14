package org.Humana.Modules;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
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

public class CardHolderOnboarding {

	Properties properties;
	WebDriver driver;

	public CardHolderOnboarding(Properties properties, WebDriver driver) {
		this.properties = properties;
		this.driver = driver;
	}

	public void cardHolderOnBoarding(WebDriver driver, Properties properties) throws InterruptedException, IOException {
		try {
			Actions action = new Actions(driver);
			WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("Menue"))));
			driver.findElement(By.xpath(properties.getProperty("Create"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("RequestSearch"))).sendKeys("cardholder onboarding");
			Thread.sleep(1000);
			driver.findElement(By.xpath(properties.getProperty("CardholderOnboardinhg"))).click();
			Thread.sleep(3000);
			WebElement wait2 = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("FirstName"))));
			driver.findElement(By.xpath(properties.getProperty("FirstName"))).sendKeys("FirstName" + RandomNumberGenerator.randomNumber().toString());
			Thread.sleep(3000);
			driver.findElement(By.xpath(properties.getProperty("LastName"))).sendKeys("LastName" + RandomNumberGenerator.randomNumber().toString());
			Thread.sleep(3000);
			WebElement workLocation = driver.findElement(By.xpath(properties.getProperty("WorkLocation")));
			action.click(workLocation).sendKeys("ADAS");
			Thread.sleep(3000);
			WebElement source = driver.findElement(
					By.xpath("//*[@class='font14 appendBottom5 blackText' and text()='Abu Dhabi, United Arab Emirates']"));
			action.sendKeys(source, Keys.ENTER).perform();
			//driver.findElement(By.xpath(properties.getProperty("WorkLocation"))).sendKeys("ADAS");
			//driver.findElement(By.xpath(properties.getProperty("WorkLocation"))).sendKeys(Keys.ENTER);
			if (driver.getTitle().toString().contains(properties.getProperty("PageTitle"))) {
				System.out.println("You are land up on My Requests Page");
			} else
				System.out.println("You are land up on a Different Page");
		} catch (Exception exception) {
			System.out.println("There is an Exception in Code :" + exception);
			ScreenShotCaptured.takeScreenShot("../AE_Toyota/src/test/java/org/Toyota/ScreenShots/"
					+ RandomNumberGenerator.randomNumber() + ".png", driver);
			System.out.println("There is an Exception in Code :" + exception);
		}
	}

}