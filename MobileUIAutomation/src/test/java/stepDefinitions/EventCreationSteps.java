package stepDefinitions;

import com.calendar.DeviceCapabilities;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.CommonObjectRepository;
import objectRepository.EventCreationObjectRepository;
import pageActions.EventCreationPageActions;

public class EventCreationSteps {

	EventCreationPageActions eventObj = new EventCreationPageActions();
	
	@When("^It is not a <non working day>$")
	public void it_is_not_a_non_working_day() throws Throwable {
		Thread.sleep(3000);
		Thread.sleep(3000);
		
		eventObj.clickMoreOptions();
		eventObj.clickNewEvent();
		eventObj.checkForDayOfTheWeek();
	}
	
	@And("^Meeting is not repeated on successive days$")
	public void meeting_is_not_repeated_on_successive_days() throws Throwable {
		Thread.sleep(3000);
		Thread.sleep(3000);
		Thread.sleep(3000);
		
		eventObj.clickOnetimeEvent();
		eventObj.toggleRepeatSwitch();
		eventObj.scheduleMeeting();
		eventObj.clickDone();
	}
	
	@Then("^I want to book a meeting with the title \"([^\"]*)\"$")
	public void i_want_to_book_a_meeting_with_the_title(String title) throws Throwable {
		eventObj.enteringMeetingDetails(title);
	}
	
	@And("^Set Meeting duration as <#hrs/Minutes> in the evening$")
	public void set_Meeting_duration_as_hrs_Minutes_in_the_evening() throws Throwable {
		eventObj.settingMeetingDuration();
		eventObj.clickDone();
	}
	
	@And("^I invite (\\d+) of people$")
	public void i_invite_Number_of_people(int numberOfAttendees) throws Throwable {
		eventObj.invitingAttendees(numberOfAttendees);
	}
	
	@And("^I save the meeting$")
	public void i_save_the_meeting() throws Throwable {
		eventObj.clickDoneCaps();
	}
}
