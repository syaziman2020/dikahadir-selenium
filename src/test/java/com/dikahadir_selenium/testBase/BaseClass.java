package com.dikahadir_selenium.testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BaseClass {
	public WebDriver driver;
	public Properties property;
	
	@BeforeTest
	@Parameters({"os", "browser"})
	public void setup(String os, String browser, ITestContext context) throws IOException {

		FileReader file = new FileReader("./src//test//resources//config.properties");
		property = new Properties();
		property.load(file);

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection_enabled", false);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--guest");

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}
		context.setAttribute("driver", driver);

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(property.getProperty("appURL"));

		driver.manage().window().maximize();
	}
	
	public String randomNumeric() {
		return RandomStringUtils.insecure().nextAlphanumeric(5);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
	public String captureScreen(WebDriver String,String screenshotName) throws IOException {
		if (driver == null) {
			throw new IOException("WebDriver instance is null. Tidak dapat mengambil screenshot.");
		}
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName + "_" + dateName
				+ ".png";
		File finalDestination = new File(destination);

		finalDestination.getParentFile().mkdirs();

		FileHandler.copy(source, finalDestination);
		return destination;
	}

}
