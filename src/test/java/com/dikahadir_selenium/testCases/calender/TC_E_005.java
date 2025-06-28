package com.dikahadir_selenium.testCases.calender;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_005 extends BaseClass{
	@Test(description = "TC_E_005")
	void editCalenderSuccess() throws InterruptedException {
		driver.navigate().to("https://magang.dikahadir.com/management/calendar");

		CalenderPage cp = new CalenderPage(driver);
		cp.getListActionBtn().getFirst().click();
		cp.clickEditFirst();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(cp.getDialogLocator()));
		String data = cp.getCalenderUnitElement().getDomProperty("value");
		cp.clearCalenderUnit(data.length());
		
		String newData = randomAlpha(6);
		cp.setCalenderUnit(newData);
		cp.clickConfirmEdit();
		driver.navigate().refresh();
		Thread.sleep(500);
		
		cp.setSearch(newData);
		cp.clickSearch();

		Thread.sleep(500);
		Assert.assertTrue(cp.getListDataFirstColumn().size() > 0);
	}

}
