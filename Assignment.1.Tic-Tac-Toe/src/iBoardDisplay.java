/**
 * 
 */


/**
 * @author ZhaoYi
 *
 */
public interface iBoardDisplay{
	void printBoard(Board board);
	void printWinTie(int wt, int st);
	void printString(String str);
	int askNumPlayers();
	int askNumRows();
	int askNumWinseq();
	String askFilename();
	int []askNextStep();	//return two numbers separated by space or "Q"
	String askIfLoadGame();
	String askforSaveGame();
	void printExceptionSavegame();
}
