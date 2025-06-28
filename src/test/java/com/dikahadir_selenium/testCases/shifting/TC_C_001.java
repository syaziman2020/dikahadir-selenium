package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;
import com.dikahadir_selenium.testCases.common.GoToShiftingTest;

public class TC_C_001 extends BaseClass{
	
	@Test(description = "TC_C_001")
	void searchShift() {	
		GoToShiftingTest.navigate(driver);
		ShiftingPage sp = new ShiftingPage(driver);
		sp.setSearch("bca");
		sp.clickSearch();
		
		Assert.assertTrue(sp.shiftNameSize() > 0);
	}

}
