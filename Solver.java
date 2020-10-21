import java.util.Scanner;

public class Solver {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
				
		Integer[][] board = new Integer[9][9];
				
		for(int i = 0; i < 9; i++) {
			String sLine = in.nextLine();
			String[] sInd = sLine.split(" ");
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(sInd[j]);
			}
		}
				
		solve(board);	
		//printBoard(board);
		in.close();
	}
			
	public static void printBoard(Integer[][] board) {
				
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean ifPossible(Integer[][] arr, int y, int x, int n) {
		for(int i = 0; i < 9; i++) {
			if(arr[y][i] == n) {
				return false;
			}
		}
		for(int i = 0; i < 9; i++) {
			if(arr[i][x] == n) {
				return false;
			}
		}
		int x_floor = (int) (Math.floor(x/3)*3);
		int y_floor = (int) (Math.floor(y/3)*3);
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(arr[y_floor + i][x_floor + j] == n) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void solve(Integer[][] arr) {
		for(int j = 0; j < 9; ++j) {
			for(int i = 0; i < 9; ++i) {
				if(arr[j][i] == 0) {
					for(int k = 0; k < 10; ++k) {
						if(ifPossible(arr,j,i,k) == true) {
							arr[j][i] = k;
							solve(arr);
							arr[j][i] = 0;
						}
					}
					return;
				}
			}
		}
		printBoard(arr);
	}
	
	
}

