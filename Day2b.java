import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
public class Day2b {
	public static void main(String[] args) throws IOException {
		
//		TESTS!
		System.out.println("~~~~~~ Tests ~~~~~~");
		int result = coolRowAdditionDude("C:\\Users\\m1042536\\Downloads\\testinput3.txt");
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
		
		int result = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(file));

		// for some reason this cannot be int[] arr or int[] arr = null...
		int[] arr = new int[1000];
		Arrays.fill(arr, 0);
		int z = 0;
		boolean check = true;
		
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
					
					// store all the numbers in the line into an array
					if(temp!="") {
						arr[z] = Integer.parseInt(temp);
						z++;
					}
					
					// Wipe temp for the next loop
					temp = "";
				}								
			}
			
			for (int x = 0; x < 1000; x++) {
				if (arr[x] == 0) {
					break;
				}
				for (int y = 0; y < 1000; y++) {
					if (arr[y] == 0) {
						break;
					}
					
					if (arr[x]%arr[y] == 0 && arr[x] != arr[y]) {
						System.out.println("arr[x]: " + arr[x] + " arr[y] " +  arr[y]);
						
						result += arr[x] / arr[y];
					}
					
				}
			}
			
			z=0;
			Arrays.fill(arr, 0);	
		}
		
		return result;
	}

}