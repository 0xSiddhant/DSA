import java.util.Scanner;

public class nQueenProblemAllPossibleSol {

	public static void main(String[] args) {

		System.out.println("Enter the size of board");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int board[][] = new int[size][size];
		
		solveNQueen(board,0,size);
	}

	private static boolean solveNQueen(int[][] board, int i, int n) {
		//Base Case
		if(i == n) {
			// You have successfully place queens in a row(0,...,n-1)
			// Print the board
			printBoard(board);
			System.out.println("=================");
			return true;
		}
		
		// Recursive case
		//Try to place the queen in the current row and call onn the remining part which is check by recursion
		for(int  j=0;j<board[i].length;j++) {
			if(isSafe(board,i,j,n)) {
				board[i][j] = 1;
				
				/*boolean nextQueenRakhSakteHai = solveNQueen(board, i+1, n);
				if(nextQueenRakhSakteHai)
					return true;*/
				
				/// A small Hack....
				solveNQueen(board, i+1, n);
				
				
				// Means i,j is not the right position. --- Assumption is wrong
				board[i][j] = 0;// BackTracking
			}
		}
		// You have tried for all position in the current row but couldn't place a queen
		return false;
	}

	private static void printBoard(int[][] board) {

		for(int i =0;i<board.length;i++) {
			for(int j =0;j<board[i].length;j++) {
				if(board[i][j] == 1)
					System.out.print("Q ");
				else
					System.out.print("_ ");
			}
			System.out.println();
		}
	}

	private static boolean isSafe(int[][] board, int i, int j, int n) {
		//You can check for col
		for(int row = 0;row<=i;row++) {
			if(board[row][j] == 1)
				return false;
		}
		// You can check for leftDiagonal
		int x = i;
		int y = j;
		while(x>=0 && y>=0) {
			if(board[x][y] == 1)
				return false;
			x--;
			y--;
		}
		// You can check for rightDiagonal
		x = i;
		y= j;
		while(x>=0 && y<n) {
			if(board[x][y] == 1) {
				return false;
			}
			x--;
			y++;
		}
		// The position is now safe, col and diagonals
		return true;
	}

}
