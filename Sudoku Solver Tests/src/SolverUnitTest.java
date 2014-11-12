import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class SolverUnitTest {
	
	public HashMap<Integer[], Integer> createpuzzle(){
		HashMap<Integer[], Integer> puzzle = new HashMap<Integer[], Integer>();
		puzzle.put(new Integer[]{0, 0}, 3);
		puzzle.put(new Integer[]{4, 0}, 7);
		puzzle.put(new Integer[]{7, 0}, 8);
		puzzle.put(new Integer[]{1, 1}, 2);
		puzzle.put(new Integer[]{4, 1}, 8);
		puzzle.put(new Integer[]{5, 1}, 9);
		puzzle.put(new Integer[]{8, 1}, 7);
		puzzle.put(new Integer[]{3, 2}, 2);
		puzzle.put(new Integer[]{5, 2}, 1);
		puzzle.put(new Integer[]{6, 2}, 3);
		puzzle.put(new Integer[]{7, 2}, 9);
		puzzle.put(new Integer[]{1, 3}, 7);
		puzzle.put(new Integer[]{2, 3}, 3);
		puzzle.put(new Integer[]{4, 3}, 1);
		puzzle.put(new Integer[]{7, 3}, 4);
		puzzle.put(new Integer[]{0, 4}, 1);
		puzzle.put(new Integer[]{1, 4}, 5);
		puzzle.put(new Integer[]{3, 4}, 9);
		puzzle.put(new Integer[]{5, 4}, 3);
		puzzle.put(new Integer[]{7, 4}, 2);
		puzzle.put(new Integer[]{8, 4}, 8);
		puzzle.put(new Integer[]{1, 5}, 8);
		puzzle.put(new Integer[]{4, 5}, 2);
		puzzle.put(new Integer[]{6, 5}, 6);
		puzzle.put(new Integer[]{7, 5}, 3);
		puzzle.put(new Integer[]{1, 6}, 6);
		puzzle.put(new Integer[]{2, 6}, 2);
		puzzle.put(new Integer[]{3, 6}, 1);
		puzzle.put(new Integer[]{5, 6}, 4);
		puzzle.put(new Integer[]{0, 7}, 4);
		puzzle.put(new Integer[]{3, 7}, 8);
		puzzle.put(new Integer[]{4, 7}, 5);
		puzzle.put(new Integer[]{7, 7}, 7);
		puzzle.put(new Integer[]{1, 8}, 9);
		puzzle.put(new Integer[]{4, 8}, 3);
		puzzle.put(new Integer[]{8, 8}, 4);
		
		return puzzle;
	}
	
	public HashMap<Integer[], Integer> createMediumPuzzle(){
		HashMap<Integer[], Integer> puzzle = new HashMap<Integer[], Integer>();
		puzzle.put(new Integer[]{2, 0}, 4);
		puzzle.put(new Integer[]{3, 0}, 6);
		puzzle.put(new Integer[]{1, 1}, 3);
		puzzle.put(new Integer[]{2, 1}, 5);
		puzzle.put(new Integer[]{3, 1}, 2);
		puzzle.put(new Integer[]{7, 1}, 9);
		puzzle.put(new Integer[]{1, 2}, 2);
		puzzle.put(new Integer[]{4, 2}, 7);
		puzzle.put(new Integer[]{6, 2}, 4);
		puzzle.put(new Integer[]{1, 3}, 7);
		puzzle.put(new Integer[]{3, 3}, 3);
		puzzle.put(new Integer[]{4, 3}, 5);
		puzzle.put(new Integer[]{6, 3}, 9);
		puzzle.put(new Integer[]{2, 4}, 9);
		puzzle.put(new Integer[]{6, 4}, 6);
		puzzle.put(new Integer[]{2, 5}, 6);
		puzzle.put(new Integer[]{4, 5}, 1);
		puzzle.put(new Integer[]{5, 5}, 7);
		puzzle.put(new Integer[]{7, 5}, 8);
		puzzle.put(new Integer[]{2, 6}, 8);
		puzzle.put(new Integer[]{4, 6}, 3);
		puzzle.put(new Integer[]{7, 6}, 2);
		puzzle.put(new Integer[]{1, 7}, 1);
		puzzle.put(new Integer[]{5, 7}, 9);
		puzzle.put(new Integer[]{6, 7}, 8);
		puzzle.put(new Integer[]{7, 7}, 3);
		puzzle.put(new Integer[]{5, 8}, 2);
		puzzle.put(new Integer[]{6, 8}, 5);
		
		return puzzle;
	}
	
	public HashMap<Integer[], Integer> createHardPuzzle(){
		HashMap<Integer[], Integer> puzzle = new HashMap<Integer[], Integer>();
		puzzle.put(new Integer[]{3, 0}, 9);
		puzzle.put(new Integer[]{5, 0}, 6);
		puzzle.put(new Integer[]{2, 1}, 7);
		puzzle.put(new Integer[]{4, 1}, 8);
		puzzle.put(new Integer[]{6, 1}, 4);
		puzzle.put(new Integer[]{0, 2}, 8);
		puzzle.put(new Integer[]{2, 2}, 2);
		puzzle.put(new Integer[]{6, 2}, 6);
		puzzle.put(new Integer[]{8, 2}, 5);
		puzzle.put(new Integer[]{1, 3}, 4);
		puzzle.put(new Integer[]{2, 3}, 3);
		puzzle.put(new Integer[]{6, 3}, 5);
		puzzle.put(new Integer[]{7, 3}, 1);
		puzzle.put(new Integer[]{0, 4}, 9);
		puzzle.put(new Integer[]{8, 4}, 6);
		puzzle.put(new Integer[]{1, 5}, 5);
		puzzle.put(new Integer[]{2, 5}, 8);
		puzzle.put(new Integer[]{6, 5}, 2);
		puzzle.put(new Integer[]{7, 5}, 9);
		puzzle.put(new Integer[]{0, 6}, 2);
		puzzle.put(new Integer[]{2, 6}, 9);
		puzzle.put(new Integer[]{6, 6}, 1);
		puzzle.put(new Integer[]{8, 6}, 3);
		puzzle.put(new Integer[]{2, 7}, 4);
		puzzle.put(new Integer[]{4, 7}, 5);
		puzzle.put(new Integer[]{6, 7}, 7);
		puzzle.put(new Integer[]{3, 8}, 3);
		puzzle.put(new Integer[]{5, 8}, 1);
		
		return puzzle;
	}
	
	@Test
	public void callSolver() throws Exception{
		
		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();
		entryValues.put(new Integer[]{0, 0}, 1);
		Solver solve = new Solver(entryValues);
		
		assertEquals("Puzzle was not created.", false, solve.checkSolved());
	}
	
	@Test(expected=Exception.class)
	public void solveCellNotEmpty() throws Exception{
		HashMap<Integer[], Integer> testPuzzle = createpuzzle();
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.printPuzzle();
		
		// Run through various tests for adding a 1 to a cell.
		assertEquals("Row check did not work.", false, solve.solveEmptyCell(0, 0, 1));	// fails because there is already a value in cell
	}
	
	@Test
	public void solveCellAlgorithm() throws Exception{
		HashMap<Integer[], Integer> testPuzzle = createpuzzle();
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.printPuzzle();
		
		// Run through various tests for adding a 1 to a cell.
		assertEquals("Row check did not work.", false, solve.solveEmptyCell(1, 2, 1));	// fails because there is a 1 already in the row
		assertEquals("Column check did not work.", false, solve.solveEmptyCell(0, 1, 1));	// fails because there is a 1 already in the column
		assertEquals("Grid check did not work.", false, solve.solveEmptyCell(2, 5, 1));	// fails because there is already a 1 in the grid
		assertEquals("Solve cell 0, 3 by row cell elimination", true, solve.solveEmptyCell(0, 3, 2));	// Succeeds
		assertEquals("Solve cell 8, 5 by row cell elimination", true, solve.solveEmptyCell(8, 5, 1));	// Succeeds
		
		solve.myPuzzle.setCell(0, 3, 2);
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
	public void solvePuzzle() throws Exception{

		HashMap<Integer[], Integer> testPuzzle = createpuzzle();
		
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.printPuzzle();
		assertEquals("Puzzle was not solved.", true, solve.solve());
	}
	
	@Test
	public void solveCell() throws Exception{

		HashMap<Integer[], Integer> testPuzzle = createMediumPuzzle();
		
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.setCell(2, 2, 1);
		
		solve.myPuzzle.printPuzzle();
		assertEquals("Solve cell 2, 8 by row cell elimination", true, solve.solveEmptyCell(2, 8, 3));	// Succeeds
	}
	
	@Test
	public void solveMediumPuzzle() throws Exception{

		HashMap<Integer[], Integer> testPuzzle = createMediumPuzzle();
		
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.printPuzzle();
		assertEquals("Puzzle was not solved.", true, solve.solve());
	}

	@Test
	public void solveHardPuzzle() throws Exception{

		HashMap<Integer[], Integer> testPuzzle = createHardPuzzle();
		
		Solver solve = new Solver(testPuzzle);
		solve.myPuzzle.printPuzzle();
		assertEquals("Puzzle was not solved.", true, solve.solve());
	}
}
