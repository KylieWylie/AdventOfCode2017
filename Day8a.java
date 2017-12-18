import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day8a {

	public static void main(String[] args) throws IOException {
		//incredibly cheeky code, just converts the file to java code, then copy paste and run it.
		String file = "C:\\Users\\m1042536\\Downloads\\input8aTest.txt";
		
		//print the variables------------------
		String[] vars = getVariables(file);	
		for (String s : vars)
			System.out.println("int "+s+" = 0;");
		//print the if statements--------------
		String[] code = getCode(file);
		for (String s : code)
			System.out.println(s);
		//print the final values---------------
		String[] finalVals = getFinalVals(file, vars);		
		for (String s : finalVals)
			System.out.println(s);
	}
	
	private static String[] getFinalVals(String file, String[] vars) {
		//uses a ArrayList so ALL vars are loaded
		ArrayList<String> var = new ArrayList<String>();
				
		for (int i = 0; i < vars.length; i++) {
			var.add("System.out.println(\""+vars[i]+": \"+"+vars[i]+");");
		}
		
		return var.toArray(new String[0]);
	}
	
	private static String[] getCode(String file) throws IOException {
		//uses a ArrayList so ALL vars are loaded
		ArrayList<String> var = new ArrayList<String>();		
		//read in the file
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
			
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			String[] lineArr = line.split(" ");
			
			if (lineArr[1].equals("inc")) {
				var.add("if ("+lineArr[4]+"_"+lineArr[5]+lineArr[6]+") {\n\t"+lineArr[0]+"_"+" += "+lineArr[2]+";\n}");
			} else {
				var.add("if ("+lineArr[4]+"_"+lineArr[5]+lineArr[6]+") {\n\t"+lineArr[0]+"_"+" -= "+lineArr[2]+";\n}");
			}
		}		
		return var.toArray(new String[0]);
	}

	private static String[] getVariables(String file) throws IOException {
		//uses a HashSet so only unique vars are loaded
		Set<String> vars = new HashSet<String>();		
		//read in the file
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			for (int i = 0; i < line.length(); i++) {				
				if (Character.toString(line.charAt(i)).equals(" ")) {
					vars.add(line.substring(0, i)+"_");
					break;
				}
			}			
		}				
		return vars.toArray(new String[0]);
	}
}