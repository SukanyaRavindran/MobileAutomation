@createARecurringMeeting
Feature: Create a recurring meeting using Native Android Calendar App

  Scenario: Create a new recurring(3 days a week) meeting, and makesure it does not repeat on
  	Given I have launched the Calendar App
		When It is not a <non working day>
		And Meeting is not repeated on successive days
		Then I want to book a meeting with the title "Recurring-Team Catch Up"
		And Set Meeting duration as <#hrs/Minutes> in the evening
		And I invite 1 of people
		And I save the meeting
		Then I Check if the meeting is created as expected
 
