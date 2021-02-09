package stepDefinitions;

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import com.calendar.DeviceCapabilities;

import objectRepository.CommonObjectRepository;
import objectRepository.HomeObjectRepository;
import pageActions.HomePageActions;

public class HomeSteps {
	
	HomePageActions homeObj = new HomePageActions();
	
	@Given("^I have launched the Calendar App$")
	public void i_have_launched_the_Calendar_App() throws Throwable {
  	    Thread.sleep(2000);
  	    System.out.println("Driver");
  	   // homeObj.checkAccessContinue();
  	   // Thread.sleep(3000);
  	   // homeObj.checkAccessOk();
  	    homeObj.openCalendarCheck();
 	}
	
}
