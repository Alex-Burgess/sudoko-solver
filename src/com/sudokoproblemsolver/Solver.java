package com.sudokoproblemsolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solver {	
	Puzzle myPuzzle = new Puzzle();
	
	Solver(HashMap<Integer[], Integer> entryValues) throws Exception{		
		for (Integer[] key : entryValues.keySet()) {
			myPuzzle.setCell(key[0], key[1], entryValues.get(key));
		}
	}
	
	public boolean solve() throws Exception {
		// Go through each cell, see if it can be solved, by rowCount, then columnCount....
		int count = 0;
		int maxLoop = 20;
		
		while (!checkSolved()  && count < maxLoop) {
			count++;
			System.out.println("Count: " + count);
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (myPuzzle.getCell(i, j) == 0) {
						for(int k = 1; k <= 9; k++){
							if (solveEmptyCell(i, j, k) == true) {
								myPuzzle.setCell(i, j, k);
								break;
							}
						}	
					}
				}
			}
		}
		
		if(checkSolved()) {
			System.out.println("Puzzle solved, WAHOO! (Number of loops: " + count + ")");
			myPuzzle.printPuzzle();
			return true;
		}
		else {
			System.out.println("Puzzle could not be solved. (Number of loops: " + count + ")");
			myPuzzle.printPuzzle();
		}
		
		return false;	// Return false unless algorithm runs through and solves the puzzle
	}
	
	public boolean solveEmptyCell(int colNum, int rowNum, int value) throws Exception {
		if (myPuzzle.getCell(colNum, rowNum) > 0)
			throw new Exception("The cell entered was not empty.");
		
		if (myPuzzle.isValueInRow(rowNum, value))	// Does the row contain the value already.  If so, it's not possible to add it.
			return false;
		
		if (myPuzzle.isValueInColumn(colNum, value))	// Does the column contain the value already.  If so, it's not possible to add it.
			return false;
		
		if (myPuzzle.isValueInGrid(colNum, rowNum, value))	// Does the grid contain the value already.  If so, it's not possible to add it.
			return false;
		
		// Value can possibly be added to the cell.
		// Can all of the other free cells be eliminated as possibilities for taking this value?  if all other free cells can be eliminated, return true.
		
		if (eliminateByRowOrColumn("column", colNum, value))	// Attempt to eliminate the other free cells in the column
			return true;
		
		if (eliminateByRowOrColumn("row", rowNum, value))	// Attempt to eliminate the other free cells in the row
			return true;
		
		if (eliminateByGrid(colNum, rowNum, value))		// Attempt to eliminate the other free cells in the grid
			return true;
		
		// If all the possible methods for adding a value failed then cell can not be solved.
		return false;
	}
	
	public boolean eliminateByGrid(int colNum, int rowNum, int value) {
		List<int[]> gridRows = myPuzzle.getGrid(myPuzzle.getGridNum(colNum, rowNum));	// Get the whole grid, which the cell is part of
		List<int[]> freeRefs = new ArrayList<int[]>();	// Array list of possible cell coordinates
		
		for (int i = 0; i < gridRows.size(); i++ ) {
			int[] gridRow = gridRows.get(i);
			for (int j = 0; j < gridRow.length; j++)
				if(gridRow[j] == 0) {
					Integer[] gridCoordinates = myPuzzle.getGridCoordinates(myPuzzle.getGridNum(colNum, rowNum));
					freeRefs.add(new int[]{j + gridCoordinates[0], i + gridCoordinates[1]});
				}
		}
		
		// If there is only one possible option to add this value in the row, then the value can be added to this cell
		if (freeRefs.size() == 1) {
			return true;
		} else if (freeRefs.size() > 1) {
			// If the number of possibilities is greater than 1, can we eliminate the remaining free cells by checking the row or column.
			int gridCount = 0;
			for (int i = 0; i < freeRefs.size(); i++) {
				int[] freeCellCoordinates = freeRefs.get(i);				
				if ( !myPuzzle.isValueInColumn(freeCellCoordinates[0], value) && !myPuzzle.isValueInRow(freeCellCoordinates[1], value))
					gridCount++;
			}
			
			if (gridCount == 1)
				return true;
		}
		
		return false;
	}
	
	public boolean eliminateByRowOrColumn(String columnOrRow, int columnOrRowNum, int value) throws Exception {
		// Can all of the other free cells be eliminated as possibilities for taking this value?  if all other free cells can be eliminated, return true.
		
		int[] columnOrRowToCheck = new int[9];
		switch(columnOrRow){
		case "row": columnOrRowToCheck = myPuzzle.getRow(columnOrRowNum);
			break;
		case "column": columnOrRowToCheck = myPuzzle.getColumn(columnOrRowNum);
			break;
		default: throw new Exception("Item Type entered was not correct.  itemType must be row, column, or grid.");
		}
			
		List<int[]> freeRefs = new ArrayList<int[]>();	// Array list of possible cell coordinates
		
		// Check all cells, there should be at least one possibility (this cell), but there could be more.
		for (int i = 0; i < 9; i++) {
			if (columnOrRowToCheck[i] == 0){
				if (columnOrRow == "row") {
					if(!myPuzzle.isValueInColumn(i, value))
						freeRefs.add(new int[]{i, columnOrRowNum});
				}
				else {
					if(!myPuzzle.isValueInRow(i, value))
						freeRefs.add(new int[]{columnOrRowNum, i});
				}
			}			
		}
		
//		System.out.println(columnOrRow + " Number of free cells:" + freeRefs.size());
		
		// If there is only one possible option to add this value in the row, then the value can be added to this cell
		if (freeRefs.size() == 1) {
			return true;
		} else if (freeRefs.size() > 1) {
			// If the number of possibilities is greater than 1, can we eliminate the remaining free cells by checking the grid.
			int gridCount = 0;
			for (int i = 0; i < freeRefs.size(); i++) {
				int[] freeCellCoordinates = freeRefs.get(i);				
				if (!myPuzzle.isValueInGrid(freeCellCoordinates[0], freeCellCoordinates[1], value))
					gridCount++;
			}
			
			if (gridCount == 1)
				return true;
		}
		
		return false;
	}	
	
	public boolean checkSolved() {
		for(int i = 0; i < 9; i++)
		{
			int[] row = myPuzzle.getRow(i);
			
			for(int j = 0; j < 9; j++)
				if(row[j] == 0)
					return false;
			
		}
		return true;
	}
}
