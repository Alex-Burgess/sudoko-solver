import java.util.ArrayList;
import java.util.Arrays;

public class Puzzle {
	ArrayList<int[]> rows = new ArrayList<int[]>();
	
	Puzzle(){
		// Create 9 arrays (rows) of size 9 (columns).
		for (int i = 0; i < 9; i++ )
			rows.add(new int[9]);
	}
	
	public int getCell(int columnNum, int rowNum){
		int[] row = rows.get(rowNum);	// Get the row array in question
		return row[columnNum]; 
	}
	
	public void setCell(int columnNum, int rowNum, int value) throws Exception
	{
		// Check if the value is between 1 and 9.
		if(value < 1 || value > 9)
			throw new Exception("Rule violation: Value being added to cell is not in the range of 1-9.");
		
		int[] row = rows.get(rowNum);	// Get the row array in question
		
		if(row[columnNum] != 0)
			throw new Exception("Rule violation: Cell already contains a value. Column ("+ columnNum +"), Row ("+ rowNum +").");
		
		if(checkRow(rowNum, value) == false)
			throw new Exception("Rule violation: Row already contains a value. Column ("+ columnNum +"), Row ("+ rowNum +").");
		
		if(checkColumn(columnNum, value) == false)
			throw new Exception("Rule violation: Column already contains a value. Column ("+ columnNum +"), Row ("+ rowNum +").");
		
		row[columnNum] = value;
	}
	
	public boolean checkRow(int rowNum, int value)
	{
		// Checks that the value does not exist in the row.  False means it is already present.
		int[] row = rows.get(rowNum);
		
		for(int i = 0; i < 9; i++)
			if(row[i] == value)
				return false;
		
		return true;
	}
	
	public boolean checkColumn(int columnNum, int value)
	{
		// Checks that the value does not exist in the column.  False means it is already present.
		for(int i = 0; i < 9; i++)
		{
			int[] row = rows.get(i);
			
			if(row[columnNum] == value)
				return false;
		}
		
		return true;
	}
	
//	public int getGridNum(int columnNum, int rowNum){
//		int gridNum;
//		
//		return gridNum;
//	}
	
	public boolean checkGrid(int columnNum, int rowNum, int value)
	{
		// Checks whether the grid number entered contains the value.
		
		//getGridNum
		
		// TODO How to traverse the grid?
		
		return true;
	}
	
	public void printPuzzle(){
		for (int i = 0; i < 9; i++ )
			System.out.println(Arrays.toString(rows.get(i)));
	}

}
