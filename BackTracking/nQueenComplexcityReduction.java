import java.util.Scanner;

public class nQueenComplexcityReduction {

	static boolean col[],d1[],d2[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of board");
		int size = sc.nextInt();
		col = new boolean[size];
		d1 = new boolean[(2*size)];
		d2 = new boolean[2*size];
		
		int board[][] = new int[size][size];
		solveQueen(board,0,size);
	}
	private static boolean solveQueen(int[][] board, int r, int no) {
		if(r == no) {
			printBoard(board);
			System.out.println();
			return false;
		}
		for(int c = 0;c<board[r].length;c++) {
			if(!col[c] && !d1[r-c+no-1] && !d2[r+c]) {
				// if condition is checking safe placement of queen 
				col[c] = d1[r-c+no-1] = d2[r+c] = true;
				board[r][c] = 1;
				solveQueen(board,r+1,no);
				//For all possible Combination;
				// Below two lines are for backtracking
				col[c] = d1[r-c+no-1] = d2[r+c] = false;
				board[r][c] = 0;
			}
		}
		return false;
		
	}
	private static void printBoard(int[][] board) {

		for(int i = 0;i<board.length;i++) {
			for(int j =0;j<board[i].length;j++) {
				if(board[i][j] == 1)
					System.out.print("Q ");
				else
					System.out.print("_ ");
			}
			System.out.println();
		}
	}

}
