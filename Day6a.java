import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day6a {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("~~~~~~~~ Test ~~~~~~~~");
		int[] banks = {0,2,7,0};
		int result = NoSteps(banks);		
		System.out.println("Result: "+result);
		
		System.out.println("\n~~~~~ Real Data ~~~~~");
		banks = toArray("C:\\Users\\m1042536\\Downloads\\input6a.txt");
		result = NoSteps(banks);
		System.out.println("Result: "+result);
	}
	
	public static int NoSteps (int[] banks) {
		int result = 0;
		int largestNo = 0;
		int largestLocation = 0;
		
		String[] prevResults = new String[1000000];
		Arrays.fill(prevResults, "");
		boolean notFound = true;
	
		do {	
			largestNo = 0;
			largestLocation = 0;
			
			//get location of / & largest number
			for (int i = 0; i < banks.length; i++) {
				if (banks[i] > largestNo) {
					largestNo = banks[i];
					largestLocation = i;
				}
			}
			
			String store = "";
			
			//store current sequence
			for (int i = 0; i < banks.length; i++) {
				store += banks[i] + " ";
			}
			
			prevResults[result] = store;
			
			//set largest location to 0 to loop through it
			banks[largestLocation] = 0;
			
			//distribute value of largest number
			int c = largestLocation;
			
			do {
				c++;
				if (c == banks.length)
					c = 0;
				
				banks[c] += 1;
				
				largestNo--;
			} while (largestNo > 0);
			
			//for viewing the steps being taken
//			for (int i : banks)
//				System.out.print(i);
//			System.out.println("------");
			
			//write current array to string for comparison
			String compare = "";
			for (int i = 0; i < banks.length; i++) {
				compare += Integer.toString(banks[i]) + " ";
			}
						
			//check if the new sequence has appeared before
			if (Arrays.asList(prevResults).contains(compare))
				notFound = false;
				
			//iterate what cycle we are on
			result++;
		} while (notFound);
		
		return result;
	}
	
	@SuppressWarnings("resource")
	public static int[] toArray(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		int linecount = 0;
		try {
			while(scanner.hasNextInt()) {
				linecount++;
				scanner.nextInt();
			}
		} catch (Exception e) {};
				
		int [] tall = new int [linecount];
		int i = 0;
		
		scanner = new Scanner(new File(path));
		try {
			while(scanner.hasNextInt()) {
				tall[i++] = scanner.nextInt();
			}
		} catch (Exception e) {};
		
		return tall;
	}
}
