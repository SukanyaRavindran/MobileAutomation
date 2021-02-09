package objectRepository;

public class EventCreationObjectRepository {
	
	// Options
	public static String moreOptions = "android.widget.ImageButton";
	public static String newEvent = "//*[@text='New event']";
	
	// Fetching current day
	public static String currentDate = "com.concentriclivers.calendar:id/start_date";
	
	// Create an event
	public static String eventName = "//*[@text='Event name']";
	public static String location = "//*[@text='Location']";
	public static String oneTimeEvent = "//*[@text='One-time event']";
	
	// Repeat meeting
	public static String repeatSwitch = "com.concentriclivers.calendar:id/repeat_switch";
	
	// Days of the week
	public static String monday = "//*[@text='MON']";
	public static String tuesday = "//*[@text='TUE']";
	public static String wednesday = "//*[@text='WED']";
	public static String thursday = "//*[@text='THU']";
	public static String friday = "//*[@text='FRI']";
	
	// Set time
	public static String startTime = "com.concentriclivers.calendar:id/start_time";
	public static String endtime = "com.concentriclivers.calendar:id/end_time";
	public static String ampmLabel = "com.concentriclivers.calendar:id/ampm_label";
	
	// Inviting people
	public static String guests = "com.concentriclivers.calendar:id/attendees";
	public static String description = "//*[@text='Description']";
}
