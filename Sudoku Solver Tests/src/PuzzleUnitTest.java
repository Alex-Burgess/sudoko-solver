import static org.junit.Assert.*;

import org.junit.Test;

public class PuzzleUnitTest {

	Puzzle testPuzzle = new Puzzle();
	
	@Test
	public void puzzleCreationSizeTest() {
		// Does the puzzle get created as a 9x9.
		assertEquals("9th column and 9th row cell was not zero", 0, testPuzzle.getCell(8, 8));
	}
	
	@Test(expected=Exception.class)
	public void tenthColumnFailTest() {
		// Update this to be specific about the error.
		assertEquals("Could not add a 10th column cell", 0, testPuzzle.getCell(9, 8));
	}
	
	@Test(expected=Exception.class)
	public void tenthRowFailTest() {
		// TODO Update this to be specific about the error.
		assertEquals("Could not add a 10th row cell", 0, testPuzzle.getCell(8, 9));
	}
	
	@Test
	public void addCellTest() throws Exception{
		testPuzzle.setCell(0, 0, 1); 		// Row 1
		assertEquals("1st column 1st row cell was not 1", 1, testPuzzle.getCell(0, 0));
	}
	
	@Test(expected=Exception.class)
	public void cellOverwriteFailTest() throws Exception{
		// Tests don't run in order, so pick a new cell. Using row 2
		testPuzzle.setCell(1, 1, 1);
		testPuzzle.setCell(1, 1, 9);	// Now try to overwrite this field.
		assertEquals("1st column 1st row cell was overwritten", 9, testPuzzle.getCell(1, 1));
	}
	
	@Test(expected=Exception.class)
	public void addInvalidNumberFailTest() throws Exception{
		testPuzzle.setCell(2, 2, 10);		// Using row 3
		assertEquals("Adding a cell value of 10 worked", 0, testPuzzle.getCell(2, 2));
	}

	@Test(expected=Exception.class)
	public void duplicateNumberToRowFailTest() throws Exception{
		// Adding a 1 to the first cell in a row and 1 to the second cell in a row should fail. Using row 4
		testPuzzle.setCell(0, 3, 1);	// Add value of 1 to column 1, row 3.
		testPuzzle.setCell(1, 3, 1);	// Add value of 1 to column 2, row 3.
		assertEquals("Adding a duplicate value to column 2, row 4 worked", 1, testPuzzle.getCell(1, 3));	// test to see if the value of column 2, row 3 is 1.
	}
	
	@Test(expected=Exception.class)
	public void duplicateNumberToColumnFailTest() throws Exception{
		// Adding a 1 to the first cell in a column and 1 to the second cell in a column should fail. Using column 5
		testPuzzle.setCell(4, 0, 1);	// Add value of 1 to column 5, row 1.
		testPuzzle.setCell(4, 1, 1);	// Add value of 1 to column 5, row 2.
		assertEquals("Adding a duplicate value to column 5, row 2 worked", 1, testPuzzle.getCell(4, 2));	// test to see if the value of column 5, row 2 is 1.
	}
	
	@Test
	public void testGridCoordinatesCreation(){
		Integer[] expectedResult = new Integer[] {6, 6};		
		Integer[] actualResult = testPuzzle.getGridCoordinates(9);
		assertArrayEquals("Test message", expectedResult, actualResult);
	}
	
	@Test(expected=Exception.class)
	public void duplicateNumberToGridFailTest() throws Exception{
		Puzzle testPuzzle2 = new Puzzle();
		// Use the bottom, right grid of the puzzle to test that duplicate values cannot be added.
		testPuzzle2.setCell(0, 0, 1);	// Add a 1 to column 1, row 1.
		testPuzzle2.setCell(2, 2, 1);	// Add a 1 to column 3, row 3.
		assertEquals("Adding a duplicate value to column 3, row 3 worked", 1, testPuzzle2.getCell(2, 2));	// test to see if the value of column 9, row 9 is 1.
	}
	
	@Test(expected=Exception.class)
	public void duplicateNumberToGridFailTest2() throws Exception{
		Puzzle testPuzzle2 = new Puzzle();
		// Use the bottom, right grid of the puzzle to test that duplicate values cannot be added.
		testPuzzle2.setCell(3, 0, 1);	// Add a 1 to column 4, row 1.
		testPuzzle2.setCell(5, 2, 1);	// Add a 1 to column 6, row 3.
		assertEquals("Adding a duplicate value to column 6, row 3 worked", 1, testPuzzle2.getCell(5, 2));	// test to see if the value of column 9, row 9 is 1.
	}
	
	@Test(expected=Exception.class)
	public void duplicateNumberToGridFailTest3() throws Exception{
		Puzzle testPuzzle2 = new Puzzle();
		// Use the bottom, right grid of the puzzle to test that duplicate values cannot be added.
		testPuzzle2.setCell(3, 6, 1);	// Add a 1 to column 4, row 7.
		testPuzzle2.setCell(5, 8, 1);	// Add a 1 to column 6, row 9.
		assertEquals("Adding a duplicate value to column 6, row 9 worked", 1, testPuzzle.getCell(5, 8));	// test to see if the value of column 9, row 9 is 1.
	}
	
	@Test(expected=Exception.class)
	public void duplicateNumberToGridFailTest4() throws Exception{
		Puzzle testPuzzle2 = new Puzzle();
		// Use the bottom, right grid of the puzzle to test that duplicate values cannot be added.
		testPuzzle2.setCell(6, 6, 1);	// Add a 1 to row 7, column 7.
		testPuzzle2.setCell(8, 8, 1);	// Add a 1 to row 9, column 9.
		assertEquals("Adding a duplicate value to column 9, row 9 worked", 1, testPuzzle.getCell(8, 8));	// test to see if the value of column 9, row 9 is 1.
	}
	
	@Test
	public void checkNotSolved() {
		assertEquals("The puzzle has been solved", false, testPuzzle.checkSolved());
	}
	
}
