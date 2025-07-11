package com.dikahadir_selenium.testCases.calender;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_E_003 extends BaseClass {
	@Test(description = "TC_E_003")
	void addCalenderEmpty() throws InterruptedException {
		driver.navigate().to("https://magang.dikahadir.com/management/calendar");

		CalenderPage cp = new CalenderPage(driver);
		String firstName =cp.getListDataFirstColumn().getFirst().getText();
		cp.setSearch(firstName);
		cp.clickSearch();

		Thread.sleep(500);
		Assert.assertTrue(cp.getListDataFirstColumn().size() > 0);
	}

}
