package com.calendar;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DeviceCapabilities {
	
	File file1 = new File("src/test/java");
	File file2 = new File(file1, "Calendar_v4.4-4_apkpure.com.apk");
	
	static DeviceCapabilities single_instance;
	AndroidDriver<AndroidElement> driver;
	public static DeviceCapabilities getInstance() throws MalformedURLException 
    { 
        if (single_instance == null) {
            single_instance = new DeviceCapabilities();
            single_instance.capabilities();
        }
    
        return single_instance; 
    } 
	
	public AndroidDriver<AndroidElement> driverMethod() {
		return driver;
	}
	
	//@BeforeTest
	public AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	//	capabilities.setCapability(MobileCapabilityType.APP, file2.getAbsolutePath());
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.concentriclivers.calendar");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calendar.AllInOneActivity");
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}
	
	public void captureScreenshot() throws IOException {	
		File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:/Eclipse_Workspace/ScreenShots/Screenshot.jpg"));
	}
	
	@AfterTest
	public void testCaseTearDown() {
		driver.quit();
	}
	
}
