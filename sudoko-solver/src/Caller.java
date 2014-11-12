import java.util.HashMap;

public class Caller {
	
	public static void main(String[] args) throws Exception {		
		// Solver will take an array as a key, which will be the coordinates and a integer value.
		
		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();
		entryValues.put(new Integer[]{0,  0}, 1);
		Solver solve = new Solver(entryValues);
		
		if (solve.checkSolved() == true)
			System.out.println("Solved");
		else
			System.out.println("Not Solved");
		
		// Print the solution
		solve.myPuzzle.printPuzzle();
	}
}
