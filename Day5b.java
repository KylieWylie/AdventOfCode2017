import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5b {

	public static void main(String[] args) throws FileNotFoundException {
		int[] maze = {0, 3, 0, 1, -3};
		int result = NoSteps(maze);
		
		System.out.println("\n\n\n~~~~~~~~ Test ~~~~~~~~");
		System.out.println("Result: "+result);
		
		
		System.out.println("\n~~~~~ Real Data ~~~~~");
		maze = toArray("C:\\Users\\m1042536\\Downloads\\input5a.txt");
		result = NoSteps(maze);
		System.out.println("Result: "+result);
		
	}
	
	public static int NoSteps(int[] maze) {
		//used for counting the steps
		int result = 0;
		
		//the position it is currently on
		int mazeposition = 0;
		//value of the current step
		int mazestepvalue = maze[0];
		
		//infinite loop that only exits when out of bounds (out of the maze)
		do {		
			try {
				result++;
				
				if (mazestepvalue >= 3) {
					maze[mazeposition] -= 1;
				} else {
					maze[mazeposition] += 1;
				}
				
				mazeposition += mazestepvalue;	
				mazestepvalue = maze[mazeposition];			
								
			} catch (Exception e) {	break; }		
		} while (result > -1);
		
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
