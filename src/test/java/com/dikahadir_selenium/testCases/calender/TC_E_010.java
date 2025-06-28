package com.dikahadir_selenium.testCases.calender;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderDetailPage;
import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_010 extends BaseClass{

	@Test(description = "TC_E_010")
	void addDateDetailEmptyDate() throws InterruptedException {
		
		driver.navigate().to("https://magang.dikahadir.com/management/calendar");

		CalenderPage cp = new CalenderPage(driver);
		cp.getListActionBtn().getFirst().click();
		
		cp.clickViewFirst();
		
		CalenderDetailPage cdp = new CalenderDetailPage(driver);
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		cdp.addCalenderDetail();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(cdp.getDialogLocator()));
		Thread.sleep(300);
		cdp.clickTypeCuti();
		Thread.sleep(300);
		cdp.clickFirstTypeCuti();
		Thread.sleep(100);
		cdp.setDescription(randomAlpha(10));

		cdp.confirmAdd();
		
		Assert.assertTrue(cdp.getMessageEmptyElements().size() > 0);
	}
}
