import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4a {

	public static void main(String[] args) throws IOException {	
		//get the result and print it off from our handy function
		int result = someFinePwds("C:\\Users\\m1042536\\Downloads\\inputPwds.txt");
		
		System.out.println("Result: "+result);
	}
	
	public static int someFinePwds(String file) throws IOException {
		
		//read in the file
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));

		//what will be returned
		int result = 0;
		int lineCount = 0;
				
		//loop through each line of the text file
		for (String line = br.readLine(); line != null; line = br.readLine()) {		
			//count total number of lines
			lineCount++;
			//used for checking whether or not the password is valid
			boolean pwdValid = true;
			//write the words in the line to an array for comparison
			String[] words = line.split("\\s+");
			for (int i = 0; i < words.length; i++) {
			    words[i] = words[i].replaceAll("[^\\w]", "");
			}
			
			int i = 0;
			for (String temp : words) {
				for (int z = 0; z < words.length; z++) {
					if (temp.equals(words[z]) && i != z) {
						pwdValid = false;
						
						//for a bit of fun, this is how you can count the number of repeated words, neat.
						//result++;
						//break;
					}
				}
				i++;
				
				if (!pwdValid) {
					result++; //this would need to be commented out though if you want to count the repeated words^^
					break;
				}
				
			}
		}
		
		return lineCount-result;
	}
}