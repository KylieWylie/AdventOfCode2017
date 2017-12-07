import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2a {

	public static void main(String[] args) throws IOException {
		
		// Result set equal to what is returned from whatever txt file you want, step 1...
		
//		TESTS!
		System.out.println("~~~~~~ Tests ~~~~~~");
		int result = coolRowAdditionDude("C:\\Users\\m1042536\\Downloads\\testinput.txt");
		System.out.println("Result: " + result);
		result = coolRowAdditionDude("C:\\Users\\m1042536\\Downloads\\testinput2.txt");
		System.out.println("Result: " + result);

//		Real data stuff.
		System.out.println("~~~~ Real Data ~~~~");
		result = coolRowAdditionDude("C:\\Users\\m1042536\\Downloads\\input.txt");	
		System.out.println("Result: " + result);
	}
	
	public static int coolRowAdditionDude(String file) throws IOException {
		
		String[] sArray = new String[10];		
		sArray[0] = "0";
		sArray[1] = "1";
		sArray[2] = "2";
		sArray[3] = "3";
		sArray[4] = "4";
		sArray[5] = "5";
		sArray[6] = "6";
		sArray[7] = "7";
		sArray[8] = "8";
		sArray[9] = "9";
		
		String temp = "";
		
		int smallest = 0;
		int largest = 0;
		
		int result = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(file));

		for (String line = br.readLine(); line != null; line = br.readLine()) {
			// boolean used to get the first number for comparison (to fins largest and smallest numbers)
			boolean numcheck = true;
			
			for(int i = 0; i < line.length(); i++) {		
				if(Arrays.asList(sArray).contains(Character.toString(line.charAt(i)))) {
					temp += Character.toString(line.charAt(i));
					
					try {
						while(Arrays.asList(sArray).contains(Character.toString(line.charAt(i+1)))) {
							temp += Character.toString(line.charAt(i+1));						
							i++;
						}
					} catch (Exception e) {}
					
					// if temp has the first number stored in it
					if(temp!="" && numcheck) {
						smallest = Integer.parseInt(temp);
						largest = Integer.parseInt(temp);
						numcheck = false;
					}
					
					// Check what is the smallest and largest on each iteration 
					if(Integer.parseInt(temp) < smallest) {
						smallest = Integer.parseInt(temp);
					}
					if(Integer.parseInt(temp) > largest) {
						largest = Integer.parseInt(temp);
					}
					
					// Wipe temp for the next loop
					temp = "";
				}								
			}
			
			// Result equal to difference between added together
			result += (largest - smallest);	
		}
		
		return result;
	}

}