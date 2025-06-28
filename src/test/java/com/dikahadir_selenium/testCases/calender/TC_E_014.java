package com.dikahadir_selenium.testCases.calender;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderDetailPage;
import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_014 extends BaseClass{
	
	@Test(description = "TC_E_014")
	void cancelAddDate() throws InterruptedException {
		driver.navigate().to("https://magang.dikahadir.com/management/calendar");

		CalenderPage cp = new CalenderPage(driver);
		
		cp.clickAdd();
		String randomCal = randomAlpha(6);
		cp.setCalenderUnit(randomCal);
		cp.clickAddConfirm();
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		cp.getListActionBtn().getFirst().click();
		
		cp.clickViewFirst();
		
		CalenderDetailPage cdp = new CalenderDetailPage(driver);
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		cdp.addCalenderDetail();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(cdp.getDialogLocator()));
		cdp.setDateInput("09102025");
		
		Thread.sleep(300);
		
		cdp.clickTypeCuti();
		Thread.sleep(300);
		cdp.clickFirstTypeCuti();
		cdp.setDescription(randomAlpha(10));
		
		cdp.clickCancel();
		
		Assert.assertEquals(cdp.getPageDisplay(), "0-0 of 0");
	}

}
