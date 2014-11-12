import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class SolverUnitTest {
	
	public HashMap<Integer[], Integer> createEasyPuzzle(){
		HashMap<Integer[], Integer> easyPuzzle = new HashMap<Integer[], Integer>();
		easyPuzzle.put(new Integer[]{0,  0}, 3);
		easyPuzzle.put(new Integer[]{4,  0}, 7);
		easyPuzzle.put(new Integer[]{7,  0}, 8);
		easyPuzzle.put(new Integer[]{1,  1}, 2);
		easyPuzzle.put(new Integer[]{4,  1}, 8);
		easyPuzzle.put(new Integer[]{5,  1}, 9);
		easyPuzzle.put(new Integer[]{8,  1}, 7);
		easyPuzzle.put(new Integer[]{3,  2}, 2);
		easyPuzzle.put(new Integer[]{5,  2}, 1);
		easyPuzzle.put(new Integer[]{6,  2}, 3);
		easyPuzzle.put(new Integer[]{7,  2}, 9);
		easyPuzzle.put(new Integer[]{1,  3}, 7);
		easyPuzzle.put(new Integer[]{2,  3}, 3);
		easyPuzzle.put(new Integer[]{4,  3}, 1);
		easyPuzzle.put(new Integer[]{7,  3}, 4);
		easyPuzzle.put(new Integer[]{0,  4}, 1);
		easyPuzzle.put(new Integer[]{1,  4}, 5);
		easyPuzzle.put(new Integer[]{3,  4}, 9);
		easyPuzzle.put(new Integer[]{5,  4}, 3);
		easyPuzzle.put(new Integer[]{7,  4}, 2);
		easyPuzzle.put(new Integer[]{8,  4}, 8);
		easyPuzzle.put(new Integer[]{1,  5}, 8);
		easyPuzzle.put(new Integer[]{4,  5}, 2);
		easyPuzzle.put(new Integer[]{6,  5}, 6);
		easyPuzzle.put(new Integer[]{7,  5}, 3);
		easyPuzzle.put(new Integer[]{1,  6}, 6);
		easyPuzzle.put(new Integer[]{2,  6}, 2);
		easyPuzzle.put(new Integer[]{3,  6}, 1);
		easyPuzzle.put(new Integer[]{5,  6}, 4);
		easyPuzzle.put(new Integer[]{0,  7}, 4);
		easyPuzzle.put(new Integer[]{3,  7}, 8);
		easyPuzzle.put(new Integer[]{4,  7}, 5);
		easyPuzzle.put(new Integer[]{7,  7}, 7);
		easyPuzzle.put(new Integer[]{1,  8}, 9);
		easyPuzzle.put(new Integer[]{4,  8}, 3);
		easyPuzzle.put(new Integer[]{8,  8}, 4);
		
		return easyPuzzle;
	}
	
	@Test
	public void callSolver() throws Exception{
		
		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();
		entryValues.put(new Integer[]{0,  0}, 1);
		Solver solve = new Solver(entryValues);
		
		assertEquals("Puzzle was not created.", false, solve.checkSolved());
	}
	
//	@Test
//	public void solveRowByCount() throws Exception{
//		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();
//		for (int i = 0; i < 8; i++ ){
//			entryValues.put(new Integer[]{i,  0}, i + 1);
//		}
//		
//		Solver solve = new Solver(entryValues);
//
//		System.out.println("Solve Row By Count Test:");
//		solve.myPuzzle.printPuzzle();
//		assertEquals("Puzzle was not created.", true, solve.solveByCount("row", 0));
//		System.out.println("Solution Row By Count Test:");
//		solve.myPuzzle.printPuzzle();
//		System.out.println();
//	}
//	
//	@Test
//	public void solveColumnByCount() throws Exception{
//		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();
//		for (int i = 0; i < 8; i++ ){
//			entryValues.put(new Integer[]{0,  i}, i + 1);
//		}
//		
//		Solver solve = new Solver(entryValues);
//		
//		System.out.println("Solve Column By Count Test:");
//		solve.myPuzzle.printPuzzle();
//		assertEquals("Puzzle was not created.", true, solve.solveByCount("column", 0));
//		System.out.println("Solution Column By Count Test:");
//		solve.myPuzzle.printPuzzle();
//		System.out.println();
//	}
//	
//	@Test
//	public void solveGridByCount() throws Exception{
//		// Try to solve internal grid 1.
//		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();		
//		entryValues.put(new Integer[]{3,  0}, 1);
//		entryValues.put(new Integer[]{3,  1}, 2);
//		entryValues.put(new Integer[]{3,  2}, 3);
//		entryValues.put(new Integer[]{4,  0}, 4);
//		entryValues.put(new Integer[]{4,  1}, 5);
//		entryValues.put(new Integer[]{4,  2}, 6);
//		entryValues.put(new Integer[]{5,  0}, 7);
//		entryValues.put(new Integer[]{5,  1}, 8);
//		
//		Solver solve = new Solver(entryValues);
//		
//		System.out.println("Solve Grid By Count Test:");
//		solve.myPuzzle.printPuzzle();
//		assertEquals("Puzzle was not created.", true, solve.solveGridByCount(2));
//		assertEquals("Puzzle was not created.", 9, solve.myPuzzle.getCell(5, 2));
//		System.out.println("Solution Grid By Count Test:");
//		solve.myPuzzle.printPuzzle();
//		System.out.println("\n");
//	}
	
	@Test(expected=Exception.class)
	public void solveCellNotEmpty() throws Exception{
		HashMap<Integer[], Integer> testPuzzle = createEasyPuzzle();
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.printPuzzle();
		
		// Run through various tests for adding a 1 to a cell.
		assertEquals("Row check did not work.", false, solve.solveEmptyCell(0, 0, 1));	// fails because there is already a value in cell
	}
	
	@Test
	public void solveCellAlgorithm() throws Exception{
		HashMap<Integer[], Integer> testPuzzle = createEasyPuzzle();
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.printPuzzle();
		
		// Run through various tests for adding a 1 to a cell.
		assertEquals("Row check did not work.", false, solve.solveEmptyCell(1, 2, 1));	// fails because there is a 1 already in the row
		assertEquals("Column check did not work.", false, solve.solveEmptyCell(0, 1, 1));	// fails because there is a 1 already in the column
		assertEquals("Grid check did not work.", false, solve.solveEmptyCell(2, 5, 1));	// fails because there is already a 1 in the grid
		assertEquals("Solve cell 0, 3 by row cell elimination", true, solve.solveEmptyCell(0, 3, 2));	// Succeeds
		assertEquals("Solve cell 8, 5 by row cell elimination", true, solve.solveEmptyCell(8, 5, 1));	// Succeeds
		
		solve.myPuzzle.setCell(0, 3, 2);
//		solve.myPuzzle.printPuzzle();
		assertEquals("Solve cell 2, 4 by row cell elimination", true, solve.solveEmptyCell(2, 4, 6));	// Succeeds
		
		solve.myPuzzle.setCell(2, 4, 6);
		assertEquals("Solve cell 2, 5 by row cell elimination", true, solve.solveEmptyCell(2, 5, 4));	// Succeeds
		
		solve.myPuzzle.setCell(2, 5, 4);
		
		assertEquals("Solve cell 0, 5 by row cell elimination", true, solve.solveEmptyCell(0, 5, 9));	// Succeeds
		
		solve.myPuzzle.setCell(0, 5, 9);
		
		System.out.println("Solved grid.");
		solve.myPuzzle.printPuzzle();
		
	}
	
	@Test
	public void solveEasyPuzzle() throws Exception{

		HashMap<Integer[], Integer> testPuzzle = createEasyPuzzle();
		
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.printPuzzle();
		assertEquals("Puzzle was not solved.", true, solve.solve());
	}

}
