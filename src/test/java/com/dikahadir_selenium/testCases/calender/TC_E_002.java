package com.dikahadir_selenium.testCases.calender;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_002 extends BaseClass{
	@Test(description = "TC_E_002")
	void addCalenderEmpty() throws InterruptedException {
		driver.navigate().to("https://magang.dikahadir.com/management/calendar");
		
		CalenderPage cp = new CalenderPage(driver);
		cp.clickAdd();
		
		cp.clickAddConfirm();
		
		Thread.sleep(500);
		Assert.assertTrue(cp.messageUnitEmptyElement().isDisplayed());
	}
}
