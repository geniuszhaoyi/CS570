import java.util.Scanner;

/**
 * 
 */

/**
 * @author ZhaoYi
 *
 */
public class BoardDisplay implements iBoardDisplay {
	Scanner reader;
	BoardDisplay(){
		reader = new Scanner(System.in);
	}
	int nextInt(){
		int option = 0;
		try {
		    option = Integer.parseInt(reader.nextLine());
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		return option;
	}
	String nextLine(){
		String str=reader.nextLine();
		return str;
	}
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
		String rep = " XOABCDEFGHIJKLMNPQRSTUVWYZ";
//		if (rep.charAt(board.board[0][3]+1) == 'X')
//		rep.charAt(0)
////			;
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
		 for(int i=1;i<=n;i++)
		 {
		    System.out.println("");
		    if(i<=9){
		    	System.out.print(i +"  ");
		    }
		    if(10<=i && i<=99){
		    	System.out.print(i+" ");
		    }
		    if(100<=i && i<=999){
		    	System.out.print(i);
		    }
	    	for (int j = 1; j <= n; j++) {
				System.out.print(" " + rep.charAt(board.board[i-1][j-1]+1)+ " ");
				if(j!=n) System.out.print("|");
	    	}
		    System.out.println("");
		    System.out.print("   ");
		    for (int j = 1; i!=n && j <= n; j++) {
				System.out.print("---");
				if(j!=n) System.out.print("+");
			}
		 }
		
		System.out.println("Now it is "+rep.charAt(board.cntplayer+1)+"'s turn: ");
	}
	static public void main1(String args[]){
		Board board=new Board(15,105,3);
		iBoardDisplay ib=new BoardDisplay();
		board.play(1, 5);
		board.play(1, 9);
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
		int numplayers = nextInt();
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
		int askNumRows = nextInt();
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
		int askNumWinseq = nextInt();
		return askNumWinseq;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iBoardDisplay#askNextStep()
	 */
	@Override
	public int[] askNextStep() {
		String str = nextLine();
		String[] parts = str.split(" ");
		if (parts[0].equals("Q"))
			return null;
		else {
			int ans[] = new int[2];
			ans[0] = Integer.parseInt(parts[0])-1;
			ans[1] = Integer.parseInt(parts[1])-1;
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
		System.out.println("Game over");
		if (wt == 2) {
			System.out.print("\n######## The winner is: ");
			String rep = " XOABCDEFGHIJKLMNPQRSTUVWYZ";
			System.out.println(rep.charAt(st+1)+" ########");
		} else
			System.out.println("\n######## The game is a TIE ########");
	}

	@Override
	public String askIfLoadGame() {
		System.out.println("Load a saved game or press enter to create a new game:");
		String str = nextLine();
		return str;
	}

	@Override
	public String askforSaveGame() {
		System.out.println("save the game:");
		String str = nextLine();
		return str;
	}

	@Override
	public void printExceptionSavegame() {
		System.out.println("Something wrong while saving the game. ");
		System.out.println("Please try again. ");
	}

}
