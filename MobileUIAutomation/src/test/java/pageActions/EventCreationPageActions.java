package pageActions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

import org.openqa.selenium.Keys;

import com.calendar.DeviceCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import objectRepository.CommonObjectRepository;
import objectRepository.EventCreationObjectRepository;

public class EventCreationPageActions {
	
	String[] splitted;
	String dayOfTheWeek = null;
	String meetingTitle = null;
	String meetingLocation = "Sydney";
	String meetingDescription = "Recurring meeting description";
	
	DeviceCapabilities device;
	
	
	public EventCreationPageActions() {
		try {
			device = device.getInstance();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getMeetingTitle() {
		return meetingTitle;
	}
	
	public String getMeetingLocation() {
		return meetingLocation;
	}
	
	public String getMeetingDescription() {
		return meetingDescription;
	}
	
	public void clickMoreOptions() throws Exception {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementByClassName(EventCreationObjectRepository.moreOptions).click();
		System.out.println("Successfully clicked more options");
		device.captureScreenshot();
	}
	
	public void clickNewEvent() throws Exception {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementByXPath(EventCreationObjectRepository.newEvent).click();
		System.out.println("Successfully clicked New Event");
		device.captureScreenshot();
	}
	
	public void checkForDayOfTheWeek() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		String startDate = driver.findElementById(EventCreationObjectRepository.currentDate).getText();
		splitted = startDate.split(",");
		System.out.println("Splitted string: " +splitted[0]);
		if(!((splitted[0].equalsIgnoreCase("Sat")) && (splitted[0]).equalsIgnoreCase("Sun"))) {
			dayOfTheWeek = "Working day";
			System.out.println("Today is a working day");
		} else {
			dayOfTheWeek = "Non working day";
			System.out.println("Today is a non working day");
		}
	}
	
	public void clickOnetimeEvent() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementByXPath(EventCreationObjectRepository.oneTimeEvent).click();
		System.out.println("Clicked one time event");
		device.captureScreenshot();
	}
	
	public void toggleRepeatSwitch() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementById(EventCreationObjectRepository.repeatSwitch).click();
		System.out.println("Turned on repeat switch");
		device.captureScreenshot();
	}
	
	public void scheduleMeeting() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		if(dayOfTheWeek.equals("Working day")) {
			switch(splitted[0]) {
			case "Mon":
				driver.findElementByXPath(EventCreationObjectRepository.wednesday).click();
				driver.findElementByXPath(EventCreationObjectRepository.friday).click();
				break;
				
			case "Tue":
				driver.findElementByXPath(EventCreationObjectRepository.thursday).click();
				break;
				
			case "Wed":
				driver.findElementByXPath(EventCreationObjectRepository.monday).click();
				driver.findElementByXPath(EventCreationObjectRepository.friday).click();
				break;
				
			case "Thu":
				driver.findElementByXPath(EventCreationObjectRepository.tuesday).click();
				break;
				
			case "Fri":
				driver.findElementByXPath(EventCreationObjectRepository.wednesday).click();
				driver.findElementByXPath(EventCreationObjectRepository.monday).click();
				break;
			}
		} else {
			System.out.println("Non working day. Creating meeting invites for working days");
			driver.findElementByXPath(EventCreationObjectRepository.monday).click();
			driver.findElementByXPath(EventCreationObjectRepository.wednesday).click();
			driver.findElementByXPath(EventCreationObjectRepository.friday).click();
		}	
		device.captureScreenshot();
	}
	
	public void clickDone() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementByXPath(CommonObjectRepository.done).click();
		System.out.println("Clicked Done");
		device.captureScreenshot();
	}
	
	public void enteringMeetingDetails(String title) throws InterruptedException, IOException {
		meetingTitle = title;
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementByXPath(EventCreationObjectRepository.eventName).sendKeys(meetingTitle);
		System.out.println("Typed event name");
		Thread.sleep(2000);
		driver.findElementByXPath(EventCreationObjectRepository.location).sendKeys(meetingLocation);
		System.out.println("Typed location");
		device.captureScreenshot();
	}
	
	public void settingMeetingDuration() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementById(EventCreationObjectRepository.startTime).click();
		System.out.println("Clicked Start time");
		
		String label = driver.findElementById(EventCreationObjectRepository.ampmLabel).getText();
		if(label.equalsIgnoreCase("AM")) {
			driver.findElementById(EventCreationObjectRepository.ampmLabel).click();
			System.out.println("Clicked PM to set meeting in the evening");
		}
		device.captureScreenshot();
	}
	
	public void invitingAttendees(int numberOfAttendees) throws Throwable {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		
		String attendee = null;
		for(int i=0; i<numberOfAttendees; i++) {
			attendee = "Attendee"+i;
			driver.findElementById(EventCreationObjectRepository.guests).sendKeys(attendee, ", ");
			System.out.println("Typed guest " +i+1 + attendee);
		}
		driver.findElementByXPath(EventCreationObjectRepository.description).sendKeys(meetingDescription);
		System.out.println("Typed meeting description");
		device.captureScreenshot();
	}
	
	public void clickDoneCaps() throws IOException {
		AndroidDriver<AndroidElement> driver = device.driverMethod();
		driver.findElementByXPath(CommonObjectRepository.doneCaps).click();
		System.out.println("Clicked DONE");
		device.captureScreenshot();
	}
}
