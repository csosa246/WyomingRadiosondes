import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class sondeparse {
	static PrintWriter ind; 

	public static void main(String args[]) {
		String station = "RAP";
		String year = "2009";
		String[] mon = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12"};

		for (int k = 0; k < mon.length; k++) {
			String fn = year + mon[k];
			try {
				FileInputStream fstream = new FileInputStream(fn + ".txt");
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				String strLine;
				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {					
					if (strLine.contains("72662 RAP Rapid City")){
						String timestamp = strLine; 
						String[] timestamp_arr = timestamp.split(" ");
						int ts_len = timestamp_arr.length;
						int time_index = ts_len-4;
						int day_index = ts_len-3;
						
						String time = timestamp_arr[time_index];
						String day = timestamp_arr[day_index];
						
						ind = new PrintWriter(
								new FileWriter(
										"C:\\Users\\Crae\\Dropbox\\GROSS2012\\sites\\GROSSJAVA\\WyomingParse\\out\\"+station+fn+day+time+".txt"));
					}else if (strLine.contains("Station information and sounding indices")){
						ind.close();
					}
					
					boolean cL = containsLetter(strLine);
					if (cL == true | strLine.contains("---")
							| strLine.isEmpty()) {
					} else {
						//System.out.println(strLine);
						ind.println(strLine);
					}
				}
				in.close();
				// Close the input stream
			} catch (Exception e) {// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}

	}

	public static boolean containsLetter(String s) {
		if (s == null)
			return false;
		boolean letterFound = false;
		for (int i = 0; !letterFound && i < s.length(); i++)
			letterFound = letterFound || Character.isLetter(s.charAt(i));
		return letterFound;
	}
}
