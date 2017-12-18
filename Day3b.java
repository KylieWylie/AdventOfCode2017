import java.util.Arrays;

public class Day3b {
	
    public static void main(String[] args) {
        int[][] grid = GenerateGrid(13,13); //make 13x13 grid of 0s, trail and error involved here...
        grid[6][6] = 1; //set first value to 1
        int ypos = 6; int xpos = 7; //grid starts from the centre + 1 on the x axis
        
        while (grid[12][12] == 0) {
            grid[ypos][xpos] = ComputeEntry(grid, ypos,xpos); //compute the new entry
            
            if (grid[ypos][xpos] >= 312051) {
            	System.out.println("Broke Limit: " + grid[ypos][xpos]);
            	break;
            }
            
            if (WhichDirection(grid, ypos, xpos) == "GoUp") {
                ypos += 1; System.out.println("GoingUp");
            } else if (WhichDirection(grid, ypos, xpos) == "GoLeft") {
                xpos -= 1; System.out.println("GoingLeft");
            } else if (WhichDirection(grid, ypos, xpos) == "GoDown") {
                ypos -= 1; System.out.println("GoingDown");
            } else if (WhichDirection(grid, ypos, xpos) == "GoRight") {
                xpos += 1; System.out.println("GoingRight");
            } else {System.out.println("Something broke!"); 
            	break;
            }
        }
        System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
    }
	
    public static int[][] GenerateGrid(int x, int y) { //create grid of zeros with x rows and y Columns
        int[][] grid = new int[x][y];
        for (int i=0; i < x; i++) {
            for (int j=0; j < y; j++) {
                grid[i][j] = 0;
            }
        }
        return grid;
    }
    public static int ComputeEntry(int[][] grid, int ypos, int xpos) {
        int entry = 0;
        //try to add the surrounding numbers together - if they are out of bounds, stop
        try{ entry += grid[ypos + 1][xpos + 1]; } catch(IndexOutOfBoundsException e) {}
        try{ entry += grid[ypos][xpos + 1]; } catch(IndexOutOfBoundsException e) {}
        try{ entry += grid[ypos - 1][xpos + 1]; } catch(IndexOutOfBoundsException e) {}
        try{ entry += grid[ypos + 1][xpos]; } catch(IndexOutOfBoundsException e) {}
        try{ entry += grid[ypos - 1][xpos]; } catch(IndexOutOfBoundsException e) {}
        try{ entry += grid[ypos + 1][xpos - 1]; } catch(IndexOutOfBoundsException e) {}
        try{ entry += grid[ypos][xpos - 1]; } catch(IndexOutOfBoundsException e) {}
        try{ entry += grid[ypos - 1][xpos - 1]; } catch(IndexOutOfBoundsException e) {}
        return entry;
    }
    
    public static String WhichDirection (int[][] grid, int ypos, int xpos) { //identify which way the spiral moves next from current entries
        int above = 0, below = 0, left = 0, right = 0;
        
        try{ above = grid[ypos + 1][xpos];} catch(IndexOutOfBoundsException e) {}
        try{ below = grid[ypos - 1][xpos];} catch(IndexOutOfBoundsException e) {}
        try{ left = grid[ypos][xpos -1];} catch(IndexOutOfBoundsException e) {}
        try{ right = grid[ypos][xpos + 1];} catch(IndexOutOfBoundsException e) {}
        
        if (left != 0 && above == 0) {
        	return "GoUp";
        } else if (below != 0 && left == 0) {
        	return "GoLeft";
        } else if (right != 0 && below == 0) {
        	return "GoDown";
        } else if (above != 0 && right == 0) {
        	return "GoRight";
        } else {
        	return "error";
        }
    }
}
