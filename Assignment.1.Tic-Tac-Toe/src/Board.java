import java.io.*;
import java.util.*;

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
		this.n=NumRows;
		this.m=NumPlayer;
		this.k=NumWinseq;
		this.cntplayer=0;
		this.board=new int[NumRows][NumRows];
		for(int i=0;i<NumRows;i++) for(int j=0;j<NumRows;j++){
			this.board[i][j]=-1;
		}
	}
	/**
	 * Recreate a saved game from a file, given filename. 
	 * Throw IngameException if load game failed. 
	 * @param Filename	Filename of the saved game. 
	 * @throws IngameException
	 */
	Board(String filename) throws IngameException{
        try{
        	Scanner sc = new Scanner(filename);
        	this.n=sc.nextInt();
        	this.m=sc.nextInt();
        	this.k=sc.nextInt();
        	this.cntplayer=sc.nextInt();
        	this.board=new int[this.n][this.n];
	        for(int i=0;i<this.n;i++){
	        	for(int j=0;j<this.n;j++){
	        		this.board[i][j]=sc.nextInt();
	        	}
	        }
        	
	        sc.close();
        }catch(NoSuchElementException e){
			throw new IngameException("IO Exception: File is corruped");
        }
    }
	/**
	 * Save game to a file, given filename. 
	 * Throw IngameException if save game failed. 
	 * @param filename Filename to save the game. 
	 * @throws IngameException
	 */
	void saveGame(String filename) throws IngameException{
		File file = new File(filename); 
		try{
			file.createNewFile();
	        BufferedWriter out = new BufferedWriter(new FileWriter(file));  
	        out.write(""+this.n+" "+this.m+" "+this.k+" "+this.cntplayer+"\n");
	        for(int i=0;i<this.n;i++){
	        	for(int j=0;j<this.n;j++){
	        		out.write(""+this.board[i][j]+" ");
	        	}
	        	out.write("\n");
	        }
	        out.flush();  
	        out.close();
		}catch(IOException e){
			throw new IngameException("IO Exception: Write file failed. ");
		}
	}
	/**
	 * Play the game and Check if the game is win or tie. . 
	 * Place the current player's piece to the board. 
	 * Check if the game is win or tie. 
	 * Throw IngameException if cell is occupied. 
	 * @param x x
	 * @param y y
	 * @throws IngameException
	 */
	int play(int x,int y) throws IngameException{
		if(this.board[x][y]!=-1) throw new IngameException("This place is occupied! ");
		this.board[x][y]=this.cntplayer;
		
		int longest;
		// Check if game is WIN 
		// check this row
		longest=0;
		for(int i=0;i<this.n;i++)
			if(this.board[x][i]==cntplayer) if(++longest>=this.k){
				winner=cntplayer;
				return 2;
			}else ;
			else longest=0;
		// check this column
		longest=0;
		for(int i=0;i<this.n;i++)
			if(this.board[i][y]==cntplayer) if(++longest>=this.k){
				winner=cntplayer;
				return 2;
			}else ;
			else longest=0;
		// check diagonal
		for(int i=0;i<this.n;i++)
			if(i+y-x>=0 && i+y-x<n && this.board[i][i+y-x]==cntplayer) if(++longest>=this.k){
				winner=cntplayer;
				return 2;
			}else ;
			else longest=0;
		for(int i=0;i<this.n;i++)
			if(x+y-i>=0 && x+y-i<n && this.board[i][x+y-i]==cntplayer) if(++longest>=this.k){
				winner=cntplayer;
				return 2;
			}else ;
			else longest=0;
		
		// Check if game is TIE
		// check rows and columns
		// TODO check if game is TIE
		
		cntplayer=(cntplayer+1)%this.m;
		return 0;
	}
}
