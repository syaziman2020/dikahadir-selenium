package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;
import com.dikahadir_selenium.utilities.StringExtractorUtil;

public class TC_C_015 extends BaseClass {

	@Test(description = "TC_C_015")
	void defaultPageDisplay() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().to("https://magang.dikahadir.com/management/shifting");
		Thread.sleep(1000);
		
		Assert.assertEquals(StringExtractorUtil.getPartBeforeOf(sp.getPageDisplay()), "1-10");
	}
}
