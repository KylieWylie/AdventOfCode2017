import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day4b {

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
			boolean pwdValid = false;
			//write the words in the line to an array for comparison
			String[] words = line.split("\\s+");
			for (int i = 0; i < words.length; i++) {
			    words[i] = words[i].replaceAll("[^\\w]", "");
			}
			
			int i = 0;
			for (String temp : words) {
				for (int z = 0; z < words.length; z++) {
					if (temp.length() == words[z].length() && i != z) {
						pwdValid = isAnagram(temp, words[z]);
						System.out.println("~~~~~~~~~~~~~~~~~~");
						System.out.println("pwdValid: "+pwdValid);
						if (pwdValid) {
							System.out.println("temp: "+temp+"\twords: "+words[z]);
							result++;
							break;
						}	
					}
				}
				i++;
				
				//this took me way too long to put this break here.
				if (pwdValid) {					
					break;
				}
				
			}
		}
		
		//same as part 4a, it was easier to get the number of invalid rather than valid,
		//... so just subtract from the total number of pwd's
		System.out.println("lineCount: "+lineCount);
		return lineCount-result;
	}
	
	//thanks stackoverflow, Arrays.sort() just orders the letters by their corresponding value in the alphabet, 
	//... so do that to any two words and you can easily see if they are anagrams. neat.
	public static boolean isAnagram(String firstWord, String secondWord) {
	     char[] word1 = firstWord.toCharArray();
	     char[] word2 = secondWord.toCharArray();
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}
}