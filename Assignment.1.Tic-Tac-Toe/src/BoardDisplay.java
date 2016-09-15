import java.util.Scanner;

/**
 * 
 */

/**
 * @author ZhaoYi
 *
 */
public class BoardDisplay implements iBoardDisplay {

	/*
	 * (non-Javadoc)
	 * 
	 * @see iBoardDisplay#printBoard(Board)
	 * 
	 * |    1  10  99  999 
	 * |1   X | O | Z | 
	 * |   ---+---+---+---+--- 
	 * |2
	 * |   ---+---+---+---+--- 
	 * |3
	 * |   ---+---+---+---+--- 
	 * |  
	 * |  
	 * |100 
	 * |101 
	 * board: n*n
	 * matrix
	 */
	@Override
	public void printBoard(Board board) {
//		board.board[0][3] = 1;
//		String rep = "XOABCDEFGHIJKLMNPQRSTUVWYZ";
//		if (rep.charAt(board.board[0][3]) == 'X')
//			;
		// -------------------------------------------------
		int n = board.n;
		System.out.print("   ");
		if (n <= 9) {
			for (int i = 1; i <= n; i++) {
				System.out.print(" " + i + "  ");
			}

		}
		if (10 <= n && n <= 99) {
			for (int i = 1; i <= 9; i++) {
				System.out.print(" " + i + "  ");
			}
			for (int i = 10; i <= n; i++) {
				System.out.print(i + "  ");
			}
		}
		if (100 <= n && n <= 999) {
			for (int i = 1; i <= 9; i++) {
				System.out.print(" " + i + "  ");
			}
			for (int i = 10; i <= 99; i++) {
				System.out.print(i + "  ");
			}
			for (int i = 100; i <= n; i++) {
				System.out.print(i + " ");
			}
		}
		// -------------------------------------------------
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}
	static public void main(String args[]){
		Board board=new Board(15,105,3);
		iBoardDisplay ib=new BoardDisplay();
		ib.printBoard(board);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iBoardDisplay#askNumPlayers()
	 */
	@Override
	public int askNumPlayers() {
		System.out.println("How many players: ");
		Scanner reader = new Scanner(System.in);
		int numplayers = reader.nextInt();
		reader.close();
		return numplayers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iBoardDisplay#askNumRows()
	 */
	@Override
	public int askNumRows() {
		System.out.println("please set the number of rows: ");
		Scanner reader = new Scanner(System.in);
		int askNumRows = reader.nextInt();
		reader.close();
		return askNumRows;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iBoardDisplay#askNumWinseq()
	 */
	@Override
	public int askNumWinseq() {
		System.out.println("please set the win sequence count: ");
		Scanner reader = new Scanner(System.in);
		int askNumWinseq = reader.nextInt();
		reader.close();
		return askNumWinseq;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iBoardDisplay#askNextStep()
	 */
	@Override
	public int[] askNextStep() {
		Scanner reader = new Scanner(System.in);
		String str = reader.nextLine();
		reader.close();
		String[] parts = str.split(" ");
		if (parts[0].equals("Q"))
			return null;
		else {
			int ans[] = new int[2];
			ans[0] = Integer.parseInt(parts[0]);
			ans[1] = Integer.parseInt(parts[1]);
			return ans;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iBoardDisplay#printWinTie(int)
	 */
	@Override
	public void printWinTie(int wt, int st) { // wt: win(2) or tie(1), st:
												// winner(win) or useless(tie)
		if (wt == 2) {
			System.out.println("The winner is:");
			String rep = "XOABCDEFGHIJKLMNPQRSTUVWYZ";
			System.out.println(rep.charAt(st));
		} else
			System.out.println("Tie");
	}

	@Override
	public String askIfLoadGame() {
		System.out.println("Load a saved game or press enter to create a new game:");
		Scanner reader = new Scanner(System.in);
		String str = reader.nextLine();
		reader.close();
		return str;
	}

	@Override
	public String askforSaveGame() {
		System.out.println("save the game:");
		Scanner reader = new Scanner(System.in);
		String str = reader.nextLine();
		reader.close();
		return str;
	}

	@Override
	public void printExceptionSavegame() {
		System.out.println("Something wrong while saving the game. ");
		System.out.println("Please try again. ");
	}

}
