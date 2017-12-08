
public class Day3a {

	public static void main(String[] args) {
		//put whatever number here
		int puzzleNo = 312051;
		
		int loopNo = LoopNo(puzzleNo);
		int[] coords = Location(loopNo, puzzleNo);
		int steps = Manhattan(coords, puzzleNo, loopNo);
		
		System.out.println("Return: "+steps);
	}
	
	//on what loop is this number?
	public static int LoopNo(int puzzleNo) {
		boolean check = true;	
		int z = 1;
		int temp = z;
		
		while(check) {
			temp = z*z;
			
			//when we have reached the corner of a square that is bigger than our numberino we are looking for.
			if(temp > puzzleNo) {
				check = false;				
				break;
			}
			
			z += 2;
		}
		
		return z;
	}

	//finds the side and the location of the number, then returns the coords
	public static int[] Location(int x, int puzzleNo) {
		
		int side = 0;
		
		int positionX = 0;
		int positionY = 0;
		
		int br = x*x;
		int bl = (x*x) - x + 1;
		int tl = (x*x) - (2*x) + 2;
		int tr = (x*x) - (3*x) + 3;
		
		//get the side of the square the number is on
		if (br > puzzleNo && puzzleNo > bl) {
			side = 1;
		} else if (bl > puzzleNo && puzzleNo > tl) {
			side = 2;
		} else if (tl > puzzleNo && puzzleNo > tr) {
			side = 3;
		} else {
			side = 4;
		}
		
		//work out where that actually is
		if (side == 1) {
			positionX = (puzzleNo - bl) + 1;
			positionY = x;
		} else if (side == 2) {
			positionX = 1;
			positionY = (puzzleNo - tl) + 1;
		} else if (side == 3) {
			positionX = (tl - puzzleNo) + 1;
			positionY = 1;
		} else {
			positionX = x;
			positionY = (tr - puzzleNo) + 1;
		}
		
		//return the coords
		int[] arr = new int[2];	
		arr[0] = positionX;
		arr[1] = positionY;
		
		return arr;
	}

	//get the number of steps fam
	public static int Manhattan(int[] coords, int puzzleNo, int loopNo) {
		//we need to know where to move fam
		int half = Math.round(loopNo/2);
				
		//distance from centre for X & Y = the total steps
		int stepX = Math.abs(coords[0]-half-1);
		int stepY = Math.abs(coords[1]-half-1);
		int steps = stepX+stepY;
		
		return steps;
	}
}