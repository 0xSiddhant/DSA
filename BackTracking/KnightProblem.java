public class KnightProblem {

	static int d = 8;
	static int rowDir[] = { +2, +1, -1, -2, -2, -1, +1, +2 };
	static int colDir[] = { +1, +2, +2, +1, -1, -2, -2, -1 };

	public static void main(String[] args) {

		int board[][] = new int[8][8];
		board[0][0] = 1;
		if (solveKnight(board, 8, 1, 0, 0)) {
			// My function was able to solve it
			printBoard(board);
		}else
			System.out.println("Unable To solve it");
	}

	private static void printBoard(int[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean solveKnight(int[][] board, int n, int move_no, int curRow, int curCol) {
		if (move_no == n * n) {
			return true;
		}
		for (int curDir = 0; curDir < 8; curDir++) {
			int nextRow = curRow + rowDir[curDir];
			int nextCol = curCol + colDir[curDir];
			if (canPlace(board, n, nextRow, nextCol)) {
				// Place the knight
				board[nextRow][nextCol] = move_no + 1;
				boolean isSucessful = solveKnight(board, n, move_no + 1, nextRow, nextCol);
				if (isSucessful)
					return true;
				// erase the knight		------>> BACKTRACKING
				board[nextRow][nextCol] = 0;
			}
		}

		return false;
	}

	private static boolean canPlace(int[][] board, int n, int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n && board[r][c] == 0;
	}

}
