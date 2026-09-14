package org.Humana.TestCaseScripts;

import java.io.IOException;

import org.Humana.Base.BaseClass;
import org.Humana.Modules.CardHolderOnboarding;
import org.Humana.Pages.Login;
import org.Humana.Pages.Logout;
import org.Humana.Pages.MyRequest;
import org.Humana.Utilities.ExcelDataRead;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class CardHolder extends BaseClass {

	@Test(enabled = true, priority = 1)
	public void badgeAdminLogin() throws InterruptedException, IOException, BiffException {
		Login login = new Login(properties, driver);
		login.userLogIn(ExcelDataRead.readACell(1, 0), ExcelDataRead.readACell(1, 1));
		CardHolderOnboarding cardHolderOnboarding = new CardHolderOnboarding(properties, driver); 
		MyRequest myRequest = new MyRequest(properties, driver);
		myRequest.myRequest(driver, properties);
		cardHolderOnboarding.cardHolderOnBoarding(driver, properties);

	}

	@AfterClass
	public void afterClass() {
		System.out.println("TC1 Executed Successfully");
	}

}
