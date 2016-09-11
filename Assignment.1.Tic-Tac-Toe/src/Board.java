/**
 * 
 */

/**
 * @author ZhaoYi
 *
 */
public class Board {
	int winner;
	int [][]board;
	int n;			//board size
	int m;			//number of players
	int k;			//win sequence count
	int cntplayer;	//current player
	
	Board(int NumPlayer, int NumRows, int NumWinseq){
		// TODO Complete this function
		this.board=new int[NumRows][NumRows];
		for(int i=0;i<NumRows;i++) for(int j=0;j<NumRows;j++){
			this.board[i][j]=-1;
		}
		
		// TODO Check if winning is possible
		
	}
	Board(String Filename) throws IngameException{
		// TODO Complete this function
	}
	
	void saveGame(String filename) throws IngameException{
		// TODO Complete this function
	}
	void play(int x,int y) throws IngameException{
		if(this.board[x][y]!=-1) throw new IngameException("This place is occupied! ");
		// TODO Complete this function
	}
	int check(){
		// TODO Complete this function
		return -1;
	}
}
