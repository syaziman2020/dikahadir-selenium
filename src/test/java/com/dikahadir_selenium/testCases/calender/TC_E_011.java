package com.dikahadir_selenium.testCases.calender;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderDetailPage;
import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_011 extends BaseClass{
	@Test(description = "TC_E_011")
	void addDateDetailEmptyType() throws InterruptedException {
		
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
		Thread.sleep(100);
		cdp.chooseNextMonth();
		Thread.sleep(100);
		cdp.chooseDate();
		Thread.sleep(300);
		
		cdp.setDescription(randomAlpha(10));

		cdp.confirmAdd();
		Thread.sleep(200);
		
		Assert.assertTrue(cdp.getMessageEmptyElements().size() > 0);
	}
}
