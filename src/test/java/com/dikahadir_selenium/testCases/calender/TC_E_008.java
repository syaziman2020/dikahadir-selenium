package com.dikahadir_selenium.testCases.calender;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderDetailPage;
import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_008 extends BaseClass{
	
	@Test(description = "TC_E_008")
	void detailCalender() throws InterruptedException {
		driver.navigate().to("https://magang.dikahadir.com/management/calendar");

		CalenderPage cp = new CalenderPage(driver);
		String firstName =cp.getListDataFirstColumn().getFirst().getText();
		cp.getListActionBtn().getFirst().click();
		
		cp.clickViewFirst();
		
		CalenderDetailPage cdp = new CalenderDetailPage(driver);
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement headerTitle = wait.until(ExpectedConditions.presenceOfElementLocated(cdp.getHeaderTitleLocator()));
		String actual = headerTitle.getText();
		
		Assert.assertEquals(actual, firstName);
	}

}
