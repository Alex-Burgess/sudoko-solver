import java.util.ArrayList;
import java.util.Arrays;

public class Puzzle {
	ArrayList<int[]> rows = new ArrayList<int[]>();
	
	Puzzle(){
		// Create 9 arrays (rows) of size 9 (columns).
		for (int i = 0; i < 9; i++ )
			rows.add(new int[9]);
	}
	
	// TODO finish
	public int getCell(int columnNUm, int rowNum){
		int cellValue = 1;
		
		return cellValue; 
	}
	
	// TODO finish
	public void setCell(int columnNUm, int rowNum){
		
	}
	
	public void printPuzzle(){
		for (int i = 0; i < 9; i++ )
			System.out.println(Arrays.toString(rows.get(i)));
	}

}
