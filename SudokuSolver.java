import java.util.Scanner;

public class SudokuSolver {
	public static void main(String[] args) {
		
		//System.out.println();
		
		Scanner in = new Scanner(System.in);
		
		Integer[][] board = new Integer[9][9];
		
		for(int i = 0; i < 9; i++) {
			String sLine = in.nextLine();
			String[] sInd = sLine.split(" ");
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(sInd[j]);
			}
		}
		
	printBoard(board);
	}
	
	public static void printBoard(Integer[][] board) {
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
