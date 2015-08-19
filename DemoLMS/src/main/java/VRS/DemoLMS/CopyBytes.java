package VRS.DemoLMS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

	/**
	 * @param args
	 */
	
	public enum Season {WINTER, SPRING, SUMMER, FALL};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*FileInputStream in = null;
		FileOutputStream out = null;
		
		in = new FileInputStream("d:\\personal\\temp1.txt");
		out = new FileOutputStream("d:\\personal\\temp2.txt");
		
		int c;
		
		while ((c=in.read()) != -1 )
			{
			out.write(c);
			
			
		}
*/		
		
		for (Season s : Season.values()) {
			System.out.println(s);
		}
		
		
	}

}
