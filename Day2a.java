import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2a {

	public static void main(String[] args) throws IOException {		
//		TESTS -- omg!
		System.out.println("~~~~~~ Tests ~~~~~~");
		int result = coolRowAdditionDude(".\\testinput.txt");
		System.out.println("Result: " + result);
		result = coolRowAdditionDude(".\\testinput2.txt");
		System.out.println("Result: " + result);

//		Real data stuff.
		System.out.println("~~~~ Real Data ~~~~");
		result = coolRowAdditionDude(".\\input.txt");	
		System.out.println("Result: " + result);
	}
	
	public static int coolRowAdditionDude(String file) throws IOException {
		
		//make sure only numbers are counted, could have just used .trim() or .replace(), I will use this is later stuff!
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

		//read through line by line by line by line by line ...
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			//boolean used to get the first number for comparison (to fins largest and smallest numbers)
			boolean numcheck = true;
			
			for(int i = 0; i < line.length(); i++) {		
				if(Arrays.asList(sArray).contains(Character.toString(line.charAt(i)))) {
					temp += Character.toString(line.charAt(i));
					
					//adds the characters to temp, soon as it does out of range it just crashes... this is terrible
					try {
						while(Arrays.asList(sArray).contains(Character.toString(line.charAt(i+1)))) {
							temp += Character.toString(line.charAt(i+1));						
							i++;
						}
					} catch (Exception e) {}
					
					//if temp has the first number stored in it
					if(temp!="" && numcheck) {
						smallest = Integer.parseInt(temp);
						largest = Integer.parseInt(temp);
						numcheck = false;
					}
					
					//check what is the smallest and largest on each iteration 
					if(Integer.parseInt(temp) < smallest) {
						smallest = Integer.parseInt(temp);
					}
					if(Integer.parseInt(temp) > largest) {
						largest = Integer.parseInt(temp);
					}
					
					//wipe temp for the next loop
					temp = "";
				}								
			}
			
			//result equal to difference between added together
			result += (largest - smallest);	
		}
		
		//bingo.
		return result;
	}
}