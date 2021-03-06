/**
 * @author ZhaoYi
 *
 */
public class Game {
	/**
	 * Control module. 
	 * @throws IngameException
	 * @see File "Flow Chart.pdf"
	 */
	static void game() throws IngameException{
		Board board;
		iBoardDisplay ibd=new BoardDisplay();
		try{
			String loadgameFn=ibd.askIfLoadGame();
			
			if(loadgameFn.compareTo("")==0){		//@Deprecated - should use Status Code
				// Create a new game
				int np=ibd.askNumPlayers();
				int nr=ibd.askNumRows();
				int nw=ibd.askNumWinseq();
				board=new Board(np,nr,nw);
			}else{
				// Restart a saved game
				board=new Board(loadgameFn);
			}
			
			while(true){
				ibd.printBoard(board);
				int []nextStep=ibd.askNextStep();
				if(nextStep==null){	//@Deprecated - should use Status Code
					while(true){
						try{
							String sg=ibd.askforSaveGame();
							if(sg.compareTo("")!=0) board.saveGame(sg);
							break;
						}catch(IngameException e){
							ibd.printExceptionSavegame();
						}
					}
					break;
				}else{
					int ck=board.play(nextStep[0], nextStep[1]);
					if(ck!=0){	//Someone wins(2) or tie(1)
						ibd.printBoard(board);
						ibd.printWinTie(ck,board.winner);
						break;
					}
				}
			}
		}catch(Exception e){
			ibd.printException(e);
		}
	}
	public static void main(String[] args) {
		game();
	}
}
