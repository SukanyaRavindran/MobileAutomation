package stepDefinitions;

import java.net.MalformedURLException;

import com.calendar.DeviceCapabilities;

import cucumber.api.java.en.Then;
import pageActions.HomePageActions;
import pageActions.MeetingVerificationPageActions;

public class MeetingVerificationSteps{
	
	MeetingVerificationPageActions meetingVerifyObj = new MeetingVerificationPageActions();
	
	@Then("^I Check if the meeting is created as expected$")
	public void i_Check_if_the_meeting_is_created_as_expected() throws Throwable {
		meetingVerifyObj.clickScheduledMeeting();
		meetingVerifyObj.verifyDetails();
	}
}
