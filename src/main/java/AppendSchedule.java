
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class AppendSchedule {
	
	public AppendSchedule(InputScan input,ArrayList<Schedule> schedules) {
		String detailText= null,keyWords= null,title= null;    // 	These string variables holds information 
		Date startTime = null,endTime= null;			       // from user inputs 
		for(int i = 0 ; i<5 ; i++){
															   //5 different type of inputs 
			switch (i) {			
			case 0:
				out.println("starttime 'dd.MM.yyyy, HH:mm':");
				startTime = writeToFileDates( input.getInput());
				break;
			case 1:
				out.println("endtime 'dd.MM.yyyy, HH:mm':");
				endTime = writeToFileDates(input.getInput());
				break;
			case 2:
				out.println("title : ");
				title = writeToFileTexts( input.getInput());
				break;
			case 3:
				out.println("detailtext :");
				detailText = writeToFileTexts( input.getInput());
				break;
			case 4:
				out.println("keywords :");
				keyWords = writeToFileTexts(input.getInput());
			default:										// add new schedule date to array list 
				Schedule schedule = new Schedule(startTime, endTime, title, detailText, keyWords);
				schedules.add(schedule);
				outputPrintln();
				break;
			}
		}
	}
	private Date parseStringtoDate(String stringDate){
		SimpleDateFormat formatter = new  SimpleDateFormat("dd.MM.yyyy, HH:mm");
		Date date = null;						//The string that from user input to Date format
		try {										
			 date = (Date) formatter.parse(stringDate);
			
		} catch (Exception e) {
			out.println("Error converting date");
			e.printStackTrace();
		}
		
		return date;
	}
	public void outputPrint(String output,boolean newLine) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(System.getProperty("user.home")+"/Tagebuch.txt", true)));
			if(newLine){			
				out.println();				//write to file 
			}								//boolean "true" cause new line
			out.print(output);				
			out.flush();
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public Date writeToFileDates(String input){
		Date date;							
		date = parseStringtoDate(input);
		outputPrint(input+"\t",false);
		return date;
	}
	public String writeToFileTexts(String input){
		String text;
		outputPrint(input+"\t",false);
		text = input;
		return text;
	}
	public void outputPrintln() {
		outputPrint("",true);
	}

}
