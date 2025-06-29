package com.dikahadir_selenium.testCases.calender;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_007 extends BaseClass{
	@Test(description = "TC_E_007")
	void deleteSuccess() throws InterruptedException {
		driver.navigate().to("https://magang.dikahadir.com/management/calendar");

		CalenderPage cp = new CalenderPage(driver);
		String firstData=cp.getListDataFirstColumn().getFirst().getText();
		
		cp.getListActionBtn().getFirst().click();
		
		cp.deleteFirstData();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(cp.getDialogLocator()));
		Thread.sleep(100);
		cp.clickConfirmDelete();
		driver.navigate().refresh();
		
		Thread.sleep(800);
		
		cp.setSearch(firstData);
		cp.clickSearch();

		Thread.sleep(800);
		Assert.assertEquals(cp.getPageDisplay(), "0-0 of 0");
	}

}
