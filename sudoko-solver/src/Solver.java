import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solver {	
	Puzzle myPuzzle = new Puzzle();
	
	Solver(HashMap<Integer[], Integer> entryValues) throws Exception{		
		for (Integer[] key : entryValues.keySet()) {
			System.out.println("column: " + key[0].toString() + " Row: " + key[1].toString() + " Value: " + entryValues.get(key));
			myPuzzle.setCell(key[0], key[1], entryValues.get(key));
		}
	}
	
	// TODO - do we want to be looking at solveCell ? checks row, then column, then grid.
	// Advantage of breaking each one down is it gives more algorithm options
	
	
	// Method tries to solve a row that requires only one more cell to be added.
	public boolean solveRow(int rowNum) throws Exception {
		// Get the row
		int[] row = myPuzzle.getRow(rowNum);
		
		// Check to see if the row is complete
		int missingCount = 0;
		for (int i = 0; i < row.length; i++)
			if (row[i] == 0)
				missingCount++;
		
		List<Integer> rowList = new ArrayList<Integer>();
		for (int i = 0; i < row.length; i++)
				rowList.add(row[i]);
		
		if(missingCount == 1){
			for (int i = 1; i <= 9; i++)
				if(! rowList.contains(i)) {
					//rowList.set(rowList.indexOf(0), i);
					myPuzzle.setCell(rowList.indexOf(0), rowNum, i);
				}
		} else {
			return false;
		}
		
		return true;
	}
	
	
	// TODO
	public boolean getSolution() {
		return myPuzzle.checkSolved();
	}
	
	
	// TODO
	public void getLatest() {
		myPuzzle.printPuzzle();
	}
	
}
