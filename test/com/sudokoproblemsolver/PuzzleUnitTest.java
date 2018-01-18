package com.sudokoproblemsolver;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.sudokoproblemsolver.Puzzle;

public class PuzzleUnitTest {

	Puzzle testPuzzle = new Puzzle();
	
	@Test
	public void puzzleCreationSizeTest() {
		// Does the puzzle get created as a 9x9.
		assertEquals(0, testPuzzle.getCell(8, 8), "9th column and 9th row cell was not zero");
	}
	
	@Test
	public void tenthColumnFailTest() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			testPuzzle.getCell(9, 8);
		});
	}
	
	@Test
	public void tenthRowFailTest() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			testPuzzle.getCell(8, 9);
		});
	}
	
	@Test
	public void addCellTest() throws Exception{
		testPuzzle.setCell(0, 0, 1); 		// Row 1
		assertEquals(1, testPuzzle.getCell(0, 0), "1st column 1st row cell was not 1");
	}
	
	@Test
	public void cellOverwriteFailTest() throws Exception {
		// Tests don't run in order, so pick a new cell. Using row 2
		testPuzzle.setCell(1, 1, 1);
		
		Exception exception = assertThrows(Exception.class, () -> {
			testPuzzle.setCell(1, 1, 9);	// Now try to overwrite this field.
		});
			
		assertEquals(exception.getMessage(), "Rule violation: Cell already contains the value 9. Column (1), Row (1)." );
	}
	
	@Test
	public void addInvalidNumberFailTest() throws Exception{
		Exception exception = assertThrows(Exception.class, () -> {
			testPuzzle.setCell(2, 2, 10);
		});
		
		assertEquals(exception.getMessage(), "Rule violation: Value being added to cell is not in the range of 1-9." );
	}

	@Test
	public void duplicateNumberToRowFailTest() throws Exception{
		// Adding a 1 to the first cell in a row and 1 to the second cell in a row should fail. Using row 4
		testPuzzle.setCell(0, 3, 1);	// Add value of 1 to column 1, row 3.
		
		Exception exception = assertThrows(Exception.class, () -> {
			testPuzzle.setCell(1, 3, 1);	// Add value of 1 to column 2, row 3.
		});
			
		assertEquals(exception.getMessage(), "Rule violation: Row already contains the value 1. Column (1), Row (3)." );
	}
	
	@Test
	public void duplicateNumberToColumnFailTest() throws Exception{
		// Adding a 1 to the first cell in a column and 1 to the second cell in a column should fail. Using column 5
		testPuzzle.setCell(4, 0, 1);	// Add value of 1 to column 5, row 1.
		
		Exception exception = assertThrows(Exception.class, () -> {
			testPuzzle.setCell(4, 1, 1);	// Add value of 1 to column 5, row 2.
		});
		
		assertEquals(exception.getMessage(), "Rule violation: Column already contains the value 1. Column (4), Row (1).");	
	}
	
	@Test
	public void testGridCoordinatesCreation(){
		Integer[] expectedResult = new Integer[] {6, 6};		
		Integer[] actualResult = testPuzzle.getGridCoordinates(9);
		assertArrayEquals(expectedResult, actualResult, "Test message");
	}
	
	@Test
	public void duplicateNumberToGridFailTest() throws Exception{
		Puzzle testPuzzle2 = new Puzzle();
		// Use the bottom, right grid of the puzzle to test that duplicate values cannot be added.
		testPuzzle2.setCell(0, 0, 1);	// Add a 1 to column 1, row 1.
		
		Exception exception = assertThrows(Exception.class, () -> {
			testPuzzle2.setCell(2, 2, 1);	// Add a 1 to column 3, row 3.
		});
		
		assertEquals(exception.getMessage(), "Rule violation: Grid already contains the value 1. Column (2), Row (2).");
	}
	
	@Test
	public void duplicateNumberToGridFailTest2() throws Exception{
		Puzzle testPuzzle2 = new Puzzle();
		// Use the bottom, right grid of the puzzle to test that duplicate values cannot be added.
		testPuzzle2.setCell(3, 0, 1);	// Add a 1 to column 4, row 1.
		
		Exception exception = assertThrows(Exception.class, () -> {
			testPuzzle2.setCell(5, 2, 1);	// Add a 1 to column 6, row 3.
		});
		
		assertEquals(exception.getMessage(), "Rule violation: Grid already contains the value 1. Column (5), Row (2).");
	}
	
	@Test
	public void duplicateNumberToGridFailTest3() throws Exception{
		Puzzle testPuzzle2 = new Puzzle();
		// Use the bottom, right grid of the puzzle to test that duplicate values cannot be added.
		testPuzzle2.setCell(3, 6, 1);	// Add a 1 to column 4, row 7.
		
		Exception exception = assertThrows(Exception.class, () -> {
			testPuzzle2.setCell(5, 8, 1);	// Add a 1 to column 6, row 9.
		});
		
		assertEquals(exception.getMessage(), "Rule violation: Grid already contains the value 1. Column (5), Row (8).");
	}
	
	@Test
	public void duplicateNumberToGridFailTest4() throws Exception{
		Puzzle testPuzzle2 = new Puzzle();
		// Use the bottom, right grid of the puzzle to test that duplicate values cannot be added.
		testPuzzle2.setCell(6, 6, 1);	// Add a 1 to row 7, column 7.
		
		Exception exception = assertThrows(Exception.class, () -> {
			testPuzzle2.setCell(8, 8, 1);	// Add a 1 to row 9, column 9.
		});
		
		assertEquals(exception.getMessage(), "Rule violation: Grid already contains the value 1. Column (8), Row (8).");
	}
	
}
