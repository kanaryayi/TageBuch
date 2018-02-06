
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.System.out;

public class ReadFile {
	public List<String> lines;
	public int size;

	public ReadFile(String path){
		try {
			size = Files.readAllLines(Paths.get(path)).size();
			lines = Files.readAllLines(Paths.get(path));
		
		} catch (IOException e) {
			out.println("not found tagebuch.txt");
			size = 0;
			lines = null;
			e.printStackTrace();
		}
	}
}

