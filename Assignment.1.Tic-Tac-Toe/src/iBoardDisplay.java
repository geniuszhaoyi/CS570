/**
 * 
 */


/**
 * @author ZhaoYi
 *
 */
public interface iBoardDisplay{
	/**
	 * Print game board to screen in given format. 
	 * @param board Board
	 * @see Board
	 */
	void printBoard(Board board);
	
	/**
	 * Print status if the game is win or tie. 
	 * @param wt wt=1 if the game is TIE, wt=2 if the game is WIN, wt=0 if the game is not win or tie. 
	 * @param st Player number who wins when wt=2, useless when wt=1. 
	 */
	void printWinTie(int wt, int st);
	
	/**
	 * Ask number of players. 
	 * Print lines to ask user to enter a number, the number of players. 
	 * Convert user input string to number, throw NumberFormatException if the string does not contain a parsable integer.
	 * @return Number of players.
	 * @see NumberFormatException
	 */
	int askNumPlayers();
	
	/**
	 * Ask number of rows (columns). 
	 * Print lines to ask user to enter a number, the number of rows or columns, since they are equal. 
	 * Convert user input string to number, throw NumberFormatException if the string does not contain a parsable integer.
	 * @return Number of rows (columns). 
	 * @see NumberFormatException
	 */
	int askNumRows();

	/**
	 * Ask number of win sequence. 
	 * Print lines to ask user to enter a number, ask what the win sequence count should be (i.e. 3 would be normal standard tic­tac­toe). 
	 * Convert user input string to number, throw NumberFormatException if the string does not contain a parsable integer.
	 * @return Number of win sequence. 
	 * @see NumberFormatException
	 */
	int askNumWinseq();
	
	/**
	 * Ask where to play next. 
	 * Ask the user for a row and column number separated by spaces, or Q to quit. 
	 * Convert user input string to number, throw NumberFormatException if the string does not contain a parsable integer.
	 * @return int[2] for x and y. Or null to quit. 
	 * @see NumberFormatException
	 */
	int []askNextStep();
	
	/**
	 * Ask if and where to load game. 
	 * Empty string for not load game from file. 
	 * @return String for filename or Empty string for not load. 
	 */
	String askIfLoadGame();
	
	/**
	 * Ask if and where to save game. 
	 * Empty string for not save game from file. 
	 * @return String for filename or Empty string for not save. 
	 */
	String askforSaveGame();
	
	/**
	 * Print a message that save game failed. 
	 */
	void printExceptionSavegame();
	
	void printException(Exception e);
}
