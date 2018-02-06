
import static java.lang.System.out;
public class GetInputfromUser implements InputScan{	
	
	@Override
	public String getInput() {
		String scannerInput = "";		
		try {
					
			scannerInput = scanner.nextLine();						
		} catch (Exception e) {
			out.println("error input");
		}
		return scannerInput;	
	}
				
}
