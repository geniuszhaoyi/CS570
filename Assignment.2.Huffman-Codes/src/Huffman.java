import java.io.*;


public class Huffman {
	String text="";
	int table[]=new int[256];
	public Huffman(){
		for(int i=0;i<256;i++){
			table[i]=0;
		}
	}
	public int add(char ch){
		table[ch]+=1;
		return 1;
	}
	public int add(String str){
		for(int i = 0; i < str.length(); i++) {  
            add(str.charAt(i));  
        }	
		return str.length();
	}
	int [][]getTable(){
		return null;
	}
	String printTable(){
		int[][]table=getTable();
		String ans="";
	   for(int i=0;i<table.length; i++)
		ans+=(char)table[i][0]+" "+table[i][1]+"%/n";
		return ans;
	}
	void doHuffman(){
		
	}
	String []getHuffmanCode(){
		// TODO Complete this function
		return null;
	}
	String printHuffmanCode(){
		String huffmanCode[]=getHuffmanCode();
		//zhaoyi
		return null;
	}
	String getEncoded(){
		// TODO Complete this function
		return null;
	}
	// http://www.cnblogs.com/lovebread/archive/2009/11/23/1609122.html
	static String readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        StringBuffer ans=new StringBuffer();;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                if (((char) tempchar) != '\r') {
                    ans.append((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans.toString();
	}
	static void main(String args[]){
		String input="infile.dat";
		
	}
}
