
public class Day3a {

	public static void main(String[] args) {
		
		int puzzleNo = 312051;
		
		int loopNo = LoopNo(puzzleNo);
		int[] coords = Location(loopNo, puzzleNo);
		int steps = Manhattan(coords, puzzleNo, loopNo);
		
		System.out.println("Return: "+steps);
	}
	
	public static int LoopNo(int puzzleNo) {
		boolean check = true;	
		int z = 1;
		int temp = z;
		
		while(check) {
			temp = z*z;
			
			if(temp > puzzleNo) {
				check = false;				
				break;
			}
			
			z += 2;
		}
		
		return z;
	}

	public static int[] Location(int x, int puzzleNo) {
		
		int side = 0;
		
		int positionX = 0;
		int positionY = 0;
		
		int br = x*x;
		int bl = (x*x) - x + 1;
		int tl = (x*x) - (2*x) + 2;
		int tr = (x*x) - (3*x) + 3;
		
		if (br > puzzleNo && puzzleNo > bl) {
			side = 1;
		} else if (bl > puzzleNo && puzzleNo > tl) {
			side = 2;
		} else if (tl > puzzleNo && puzzleNo > tr) {
			side = 3;
		} else {
			side = 4;
		}
		
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
		
		int[] arr = new int[2];	
		arr[0] = positionX;
		arr[1] = positionY;
		
		return arr;
	}

	public static int Manhattan(int[] coords, int puzzleNo, int loopNo) {
		
		int half = Math.round(loopNo/2);
				
		int stepX = Math.abs(coords[0]-half-1);
		int stepY = Math.abs(coords[1]-half-1);
		int steps = stepX+stepY;
		
		return steps;
	}
}