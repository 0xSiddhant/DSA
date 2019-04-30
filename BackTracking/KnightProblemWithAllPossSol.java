import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class KnightProblemWithAllPossSol {

	static int d = 8;
	static int rowDir[] = { +2, +1, -1, -2, -2, -1, +1, +2 };
	static int colDir[] = { +1, +2, +2, +1, -1, -2, -2, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of board");
		int size = sc.nextInt();
		int board[][] = new int[size][size];
		board[0][0] = 1;
		solveKnight(board, size, 1, 0, 0);
	}

	private static void printBoard(int[][] board) {
		// TODO Auto-generated method stub
		try {
			FileWriter w = new FileWriter("possibleSol.txt",true);
			PrintWriter pw = new PrintWriter(w);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					//System.out.print(board[i][j] + " ");
					pw.print(board[i][j]+" ");
				}
				//System.out.println();
				pw.println();
			}
			pw.println("================================");
			
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void solveKnight(int[][] board, int n, int move_no, int curRow, int curCol) {
		if (move_no == n * n) {
			printBoard(board);
			//System.out.println("===========================");
			return ;
		}
		for (int curDir = 0; curDir < 8; curDir++) {
			int nextRow = curRow + rowDir[curDir];
			int nextCol = curCol + colDir[curDir];
			if (canPlace(board, n, nextRow, nextCol)) {
				// Place the knight
				board[nextRow][nextCol] = move_no + 1;
				solveKnight(board, n, move_no + 1, nextRow, nextCol);
				// erase the knight		------>> BACKTRACKING
				board[nextRow][nextCol] = 0;
			}
		}

		return;
	}

	private static boolean canPlace(int[][] board, int n, int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n && board[r][c] == 0;
	}

}
