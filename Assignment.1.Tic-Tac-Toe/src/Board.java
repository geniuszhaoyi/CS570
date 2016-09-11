/**
 * 
 */

/**
 * @author ZhaoYi
 *
 */
public class Board {
	/** 
	 * The number of the winner win the game is win.
	 */
	int winner;
	/**
	 * n*n space to storage the situation of the game. 
	 * board[i][j]=-1 means the cell is empty. 
	 */
	int [][]board;
	/**
	 * Board size. Number of rows and column. 
	 * Notice the board is a square. 
	 */
	int n;
	/**
	 * Number of players
	 */
	int m;
	/**
	 * Number of win sequence count
	 */
	int k;
	/**
	 * Current player (Next player)
	 */
	int cntplayer;
	
	/**
	 * Create a new Game given 3 numbers below. 
	 * Check if winning is possible, throw IngameException if no one can win in given board. 
	 * @param NumPlayer	Number of players
	 * @param NumRows	Board size
	 * @param NumWinseq	Number of win sequence count
	 * @throws IngameException
	 */
	Board(int NumPlayer, int NumRows, int NumWinseq) throws IngameException{
		// TODO Complete this function
		this.board=new int[NumRows][NumRows];
		for(int i=0;i<NumRows;i++) for(int j=0;j<NumRows;j++){
			this.board[i][j]=-1;
		}
		
		// TODO Check if winning is possible
		
	}
	/**
	 * Recreate a saved game from a file, given filename. 
	 * Throw IngameException if load game failed. 
	 * @param Filename	Filename of the saved game. 
	 * @throws IngameException
	 */
	Board(String Filename) throws IngameException{
		// TODO Complete this function
	}
	/**
	 * Save game to a file, given filename. 
	 * Throw IngameException if save game failed. 
	 * @param filename Filename to save the game. 
	 * @throws IngameException
	 */
	void saveGame(String filename) throws IngameException{
		// TODO Complete this function
	}
	/**
	 * Play the game. 
	 * Place the current player's piece to the board. 
	 * Throw IngameException if cell is occupied. 
	 * @param x x
	 * @param y y
	 * @throws IngameException
	 */
	void play(int x,int y) throws IngameException{
		if(this.board[x][y]!=-1) throw new IngameException("This place is occupied! ");
		// TODO Complete this function
	}
	/**
	 * Check if the game is win or tie
	 * @return 2 for win, 1 for tie or 0 for nothing. 
	 */
	int check(){
		// TODO Complete this function
		return -1;
	}
}
