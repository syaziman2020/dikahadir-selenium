package com.dikahadir_selenium.testCases.calender;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderDetailPage;
import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_009 extends BaseClass{
	@Test(description = "TC_E_009")
	void addDateDetail() throws InterruptedException {
		driver.navigate().to("https://magang.dikahadir.com/management/calendar");

		CalenderPage cp = new CalenderPage(driver);
		cp.getListActionBtn().getFirst().click();
		
		cp.clickViewFirst();
		
		CalenderDetailPage cdp = new CalenderDetailPage(driver);
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		cdp.addCalenderDetail();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(cdp.getDialogLocator()));
		cdp.clickDate();
		cdp.chooseNextMonth();
		cdp.chooseDate();
		Thread.sleep(300);
		
		cdp.clickTypeCuti();
		Thread.sleep(300);
		cdp.clickFirstTypeCuti();
		cdp.setDescription(randomAlpha(10));
		
		cdp.confirmAdd();
		Thread.sleep(600);
		
		Assert.assertEquals(cdp.getPageDisplay(), "1-1 of 1");
	}

}
