package com.dikahadir_selenium.testCases.shifting;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;
import com.dikahadir_selenium.utilities.SimpleSortValidationUtil;

public class TC_C_002 extends BaseClass{
	
	
	@Test(description = "TC_C_002")
	void resetSearchShift() throws InterruptedException {

		ShiftingPage sp = new ShiftingPage(driver);
		
		sp.clickReset();
		
		Thread.sleep(1000);
		
		List<WebElement> firstCols = sp.datasFirstColumn();
		
		SimpleSortValidationUtil.validateNumericThenAlphaOrder(firstCols);
	}

}
