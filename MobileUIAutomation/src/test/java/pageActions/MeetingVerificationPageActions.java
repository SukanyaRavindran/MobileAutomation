package pageActions;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;

import com.calendar.DeviceCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import objectRepository.MeetingVerificationObjectRepository;

public class MeetingVerificationPageActions {
	
	DeviceCapabilities device;
		
	public MeetingVerificationPageActions() {
		try {
			device = device.getInstance();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickScheduledMeeting() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementById(MeetingVerificationObjectRepository.meeting).click();
		device.captureScreenshot();
	}
	
	public void verifyDetails() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		EventCreationPageActions eventActions = new EventCreationPageActions();
		
		String verifyMeetingTitle = driver.findElementById(MeetingVerificationObjectRepository.titleVerify).getText();
		String verifyMeetingLocation = driver.findElementById(MeetingVerificationObjectRepository.locationverify).getText();
		String verifyMeetingDescription = driver.findElementById(MeetingVerificationObjectRepository.descVerify).getText();
		
		Assert.assertTrue(eventActions.getMeetingTitle().equalsIgnoreCase(verifyMeetingTitle), "Meeting title mismatches");
		Assert.assertTrue(eventActions.getMeetingLocation().equalsIgnoreCase(verifyMeetingLocation), "Meeting location mismatches");
		Assert.assertTrue(eventActions.getMeetingDescription().equalsIgnoreCase(verifyMeetingDescription), "Meeting description mismatches");
		device.captureScreenshot();
	}
}
