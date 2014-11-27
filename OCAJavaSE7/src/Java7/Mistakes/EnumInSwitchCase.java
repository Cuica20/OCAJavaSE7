package Java7.Mistakes;

public class EnumInSwitchCase {

	public enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SUNDAY;
	}
	
	public static void main(String[] args) {
		
		Day[] daysOfWeek = Day.values();
		
		for (Day today : daysOfWeek) {
			switch (today) {
			
				case MONDAY:
					System.err.println("Today is Monday learn example How to use Java Enum in Switch");
					break;
				case TUESDAY:
					System.err.println("Tuesday, apply Enum");
					break;
				case WEDNESDAY: 
					System.err.println("Wwednesday, I confirm Java");
					break;
				case THURSDAY: 
					System.err.println("Thursday, Java Enum values()");
					break;
				case FRIDAY: 
					System.err.println("Friday");
					break;
				case SUNDAY:
					System.err.println("Sunday");
					break;
			}
		}
		
	}

}
