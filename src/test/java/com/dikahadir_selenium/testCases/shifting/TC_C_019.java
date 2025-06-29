package com.dikahadir_selenium.testCases.shifting;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_019 extends BaseClass{
	@Test(description = "TC_C_019")
	void AddTimeInAfterTimeOut() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().to("https://magang.dikahadir.com/management/shifting");
		sp.clickAdd();
		String randomName = "1"+randomAlpha(6);
		sp.setName(randomName);
		sp.clickUnit();
		sp.clickThirdUnitOption();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		sp.clickShowTimeIn();
		wait.until(ExpectedConditions.presenceOfElementLocated(sp.getLocatorTimeDialog()));
		sp.chooseTime("11");
		sp.chooseTime("30");
		
		Thread.sleep(300);

		sp.clickShowTimeOut();
		wait.until(ExpectedConditions.presenceOfElementLocated(sp.getLocatorTimeDialog()));
		sp.chooseTime("10");
		sp.chooseTime("30");
		Thread.sleep(300);
		
		sp.setCodeUnit(randomNumeric(6));
		
		sp.clickBreakStart();
		wait.until(ExpectedConditions.presenceOfElementLocated(sp.getLocatorTimeDialog()));
		sp.chooseTime("9");
		sp.chooseTime("00");
		
		Thread.sleep(300);

		sp.clickBreakEnd();
		wait.until(ExpectedConditions.presenceOfElementLocated(sp.getLocatorTimeDialog()));
		sp.chooseTime("9");
		sp.chooseTime("15");
		
		Thread.sleep(300);

		sp.clickConfirmAdd();
		Thread.sleep(500);
		sp.setSearch(randomName);
		sp.clickSearch();
		
		Thread.sleep(500);
		Assert.assertNotEquals(sp.datasFirstColumn().getFirst().getText(), randomName);
	}

}
