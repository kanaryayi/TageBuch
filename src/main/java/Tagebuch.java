
import static java.lang.System.out;
import java.util.ArrayList;
public class Tagebuch {

	private InputScan input;

	public Tagebuch(InputScan input) {  
		this.input = input;
	}
	/*This program first takes data from a text file and adds this data to a array list object   
	 * after that waits for user inputs , if user gives append, it appends new dates to text 
	 * file at the same time it saves this dates to array list.If user gives sum, 
	 * it takes times from each schedule date elements of array list and calculates the total time.
	 * Then, prints to console. unless user gives "q" as a input , it will keep going to run. 
	 * */
	 
	public static void main(String[] args) {
		GetInputfromUser getInput = new GetInputfromUser();
		Tagebuch program = new Tagebuch(getInput);
		
		program.startCode();
	}

	public void startCode() {                          
		ArrayList<Schedule> schedules = new ArrayList<>();  // This array list holds schedule from tagebuch.txt
		OldSchedules oldDates = new OldSchedules(schedules);// This object takes old dates from text and saves in schedules array list
		while (codeMenu(schedules)) {						// This loop plays the game until user decides to quit
		}
	}

	private boolean codeMenu(ArrayList<Schedule> schedules) { //this method takes input from user for what user wants to do
		boolean isExit = true;
		out.println("Enter : 'append', 'sum', to exit 'q',to delete old dates 'delete'");
		switch (input.getInput()) {
		case "append":
			AppendSchedule append = new AppendSchedule(input,schedules);
			break;
		case "sum":
			getSum(schedules);
			break;
		case "q":
			isExit = false;
			out.println("GoodBye !!");
			break;
		
		case "delete":
			OldSchedules.deleteFile();
			out.println("Deleted old dates");
			schedules.clear();
			break;
		}
		return isExit;   // returns a boolean about quit or keep going

	}
	public static void getSum(ArrayList<Schedule> schedules){
		long totalTimeInMin = 0;       // This method calculates total times within dates
		for(Schedule i : schedules){	// Takes this times from each schedule plan
			totalTimeInMin+= i.totalTime; // Shows total time 
		}
		System.out.println("Total time : "+(int)totalTimeInMin/60+" hours, "+totalTimeInMin%60+" mins");
	}
}
