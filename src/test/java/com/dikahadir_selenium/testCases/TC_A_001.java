package com.dikahadir_selenium.testCases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.testBase.BaseClass;

public class TC_A_001 extends BaseClass{
	
	@Test(description = "TC_A_001")
	void login() {
		Assert.assertEquals(driver.getTitle(), "HADIx");;
	}

}
