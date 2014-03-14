import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



//FILES LOADED FROM 
//C:\Users\Crae\Dropbox\GROSS2012\sites\GROSSJAVA\WyomingParse

public class mainparse {
	public static void main(String args[]) {
		String year = "2009";
		String[] mon = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12" };
		
		try {
			PrintWriter out = new PrintWriter(
					new FileWriter(
							"C:\\Users\\Crae\\Dropbox\\GROSS2012\\sites\\GROSSJAVA\\WyomingParse\\year_all.txt"));
			for (int k = 0; k < mon.length; k++) {
				String fn = year + mon[k];
				FileInputStream fstream = new FileInputStream(fn + ".txt");
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(
						new InputStreamReader(in));
				String strLine;
				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {
					String testing = strLine;
					boolean cL = containsLetter(testing);
					if (cL == true | strLine.contains("---")
							| strLine.isEmpty()) {
					} else {
						// System.out.println(strLine);
						out.println(strLine);
					}
				}
				in.close();
			}
			out.close();
			// Close the input stream
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
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
