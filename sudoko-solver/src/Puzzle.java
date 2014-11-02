import java.util.ArrayList;

public class Puzzle {
	ArrayList<int[]> rows = new ArrayList<int[]>();
	
	public Puzzle(){
		// Create 9 arrays (rows) of size 9 (columns).
		for (int i = 0; i < 9; i++ )
			rows.add(new int[9]);
	}
	
	public void printPuzzle(){
		for (int i = 0; i < 9; i++ )
			System.out.println(rows.get(i));
	}

}
