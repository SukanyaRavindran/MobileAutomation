package pageActions;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;

import com.calendar.DeviceCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import objectRepository.CommonObjectRepository;
import objectRepository.HomeObjectRepository;

public class HomePageActions {
	
	DeviceCapabilities device;
	
	public HomePageActions() {
		try {
			device = device.getInstance();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkAccessContinue() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		if(driver.findElementByXPath(CommonObjectRepository.continueAccess).isDisplayed()) {
  	    	driver.findElementByXPath(CommonObjectRepository.continueAccess).click();
  	    	System.out.println("Clicked Continue button");
  	    } else {
  	    	System.out.println("Access set already");
  	    }
		device.captureScreenshot();
	}
	
	public void checkAccessOk() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		if(driver.findElementByXPath(CommonObjectRepository.ok).isDisplayed()) {
	    	driver.findElementByXPath(CommonObjectRepository.ok).click();
	    	System.out.println("Clicked ok button");
	    } else {
	    	System.out.println("Access set already");
	    }
		device.captureScreenshot();
	}
	
	public void openCalendarCheck() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		if(driver.findElementById(HomeObjectRepository.openCalendar).isDisplayed()) {
  	    	System.out.println("Successfully opened Calendar app");
  	    }else {
  	    	System.out.println("Opening Calendar app fails");
  	    }  
		device.captureScreenshot();
	}
}
