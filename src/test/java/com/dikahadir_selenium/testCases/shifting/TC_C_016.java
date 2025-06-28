package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;
import com.dikahadir_selenium.utilities.StringExtractorUtil;

public class TC_C_016 extends BaseClass{

	@Test(description = "TC_C_016")
	void checkNextAndPreviousDisplay() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().to("https://magang.dikahadir.com/management/shifting");
		Thread.sleep(1000);
		
		sp.clickNext();
		Thread.sleep(700);
		Assert.assertEquals(StringExtractorUtil.getPartBeforeOf(sp.getPageDisplay()), "11-20");
		
		sp.clickPrevious();
		Thread.sleep(700);
		Assert.assertEquals(StringExtractorUtil.getPartBeforeOf(sp.getPageDisplay()), "1-10");
	}
}
