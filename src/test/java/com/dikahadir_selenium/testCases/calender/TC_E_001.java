package com.dikahadir_selenium.testCases.calender;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.CalenderPage;
import com.dikahadir_selenium.testBase.BaseClass;
import com.dikahadir_selenium.testCases.common.GoToCalender;

public class TC_E_001 extends BaseClass{
	@Test(description = "TC_E_001")
	void addCalenderSuccess() throws InterruptedException {
		GoToCalender.navigate(driver);
		
		CalenderPage cp = new CalenderPage(driver);
		cp.clickAdd();
		Thread.sleep(100);
		String randomCal = randomAlpha(6);
		cp.setCalenderUnit(randomCal);
		cp.clickAddConfirm();
		Thread.sleep(1000);
		
		cp.setSearch(randomCal);
		cp.clickSearch();
		
		Thread.sleep(1000);
		Assert.assertTrue(cp.getListDataFirstColumn().size() > 0);
	}

}
