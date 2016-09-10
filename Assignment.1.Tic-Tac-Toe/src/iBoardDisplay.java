/**
 * 
 */


/**
 * @author ZhaoYi
 *
 */
public interface iBoardDisplay {
	void printBoard(Board board);
	int askNumPlayers();
	int askNumRows();
	int askNumWinseq();
	String askFilename();
	String askNextStep();	//return two numbers seqarated by space or "Q"
	void printWinTie(int st);
}
