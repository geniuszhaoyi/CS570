/**
 * 
 */

/**
 * @author ZhaoYi
 *
 */
public class BoardDisplay implements iBoardDisplay {

	/* (non-Javadoc)
	 * @see iBoardDisplay#printBoard(Board)
	 */
	@Override
	public void printBoard(Board board) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see iBoardDisplay#askNumPlayers()
	 */
	@Override
	public int askNumPlayers() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see iBoardDisplay#askNumRows()
	 */
	@Override
	public int askNumRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see iBoardDisplay#askNumWinseq()
	 */
	@Override
	public int askNumWinseq() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see iBoardDisplay#askNextStep()
	 */
	@Override
	public int[] askNextStep() {
		// TODO Auto-generated method stub
		String[] parts = "123 234".split("-");
		int result=Integer.parseInt(parts[0]);
		return null;
	}

	/* (non-Javadoc)
	 * @see iBoardDisplay#printWinTie(int)
	 */
	@Override
	public void printWinTie(int wt, int st) {	//wt: win(2) or tie(1), st: winner(win) or useless(tie)
		// TODO Auto-generated method stub

	}

	@Override
	public String askIfLoadGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String askforSaveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printExceptionSavegame() {
		// TODO Auto-generated method stub
		
	}

}
