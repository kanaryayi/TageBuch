
import static java.lang.System.out;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OldSchedules implements InputScan{
	
	String[] words;
	int index = 0;
	
	public OldSchedules(ArrayList<Schedule> schedules) {
		ReadFile reader;
		reader = new ReadFile(System.getProperty("user.home")+"/Tagebuch.txt");
		List<String> lines;
		lines =reader.lines;
		deleteFile();
		String wordString;
		for(int i=0;i<reader.size;i++){
			
			wordString = lines.get(i);
			words = wordString.split("\t");
			
			AppendSchedule append = new AppendSchedule(this, schedules);
			index = 0;
		}
		out.println("    ** OLD SCHEDULE INFORMATION ADDED AUTOMATICALLY ** !!!");
	}
	@Override
	public String getInput() {
		
		return words[index++];
	}
	public static void deleteFile(){
		File file = new File(System.getProperty("user.home")+"/Tagebuch.txt");
		if(file.exists()){
			file.delete();
		}
	}

}
