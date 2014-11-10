import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class SolverUnitTest {
	// This is a unit test for the constructor
	//@Test
	public void callSolver() throws Exception{
		
		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();
		entryValues.put(new Integer[]{0,  0}, 1);
		Solver solve = new Solver(entryValues);
		
		assertEquals("Puzzle was not created.", false, solve.getSolution());
		
//		try {
//			Solver newSolver = new Solver(entryValues);
//		} catch (Exception e) {
//			fail(e.getMessage());
//		}
	}
	
	// Create a puzzle with 8 values in 1 row and try solve row.
	@Test
	public void solveRow() throws Exception{
		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();
		entryValues.put(new Integer[]{0,  0}, 1);
		entryValues.put(new Integer[]{1,  0}, 2);
		entryValues.put(new Integer[]{2,  0}, 3);
		entryValues.put(new Integer[]{3,  0}, 4);
		entryValues.put(new Integer[]{4,  0}, 5);
		entryValues.put(new Integer[]{5,  0}, 6);
		entryValues.put(new Integer[]{6,  0}, 7);
		entryValues.put(new Integer[]{7,  0}, 8);
		Solver solve = new Solver(entryValues);
		
		assertEquals("Puzzle was not created.", true, solve.solveRow(0));
	}
	
	// Create a puzzle with 8 values in 1 row and try solve row.
	@Test
	public void solveColumn() throws Exception{
		HashMap<Integer[], Integer> entryValues = new HashMap<Integer[], Integer>();
		entryValues.put(new Integer[]{0,  0}, 1);
		entryValues.put(new Integer[]{0,  1}, 2);
		entryValues.put(new Integer[]{0,  2}, 3);
		entryValues.put(new Integer[]{0,  3}, 4);
		entryValues.put(new Integer[]{0,  4}, 5);
		entryValues.put(new Integer[]{0,  5}, 6);
		entryValues.put(new Integer[]{0,  6}, 7);
		entryValues.put(new Integer[]{0,  7}, 8);
		Solver solve = new Solver(entryValues);
		
		assertEquals("Puzzle was not created.", true, solve.solveColumn(0));
	}

}
