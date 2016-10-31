import java.io.*;
import java.util.Arrays;
import java.util.Collections;


public class Huffman {
	String text="";
	int textlength=0;
	int table[]=new int[256];
	public Huffman(){
		for(int i=0;i<256;i++){
			table[i]=0;
		}
	}
	public int add(char ch){
		table[ch]+=1;
		textlength+=1;
		return 1;
	}
	public int add(String str){
		for(int i = 0; i < str.length(); i++) {  
            add(str.charAt(i));  
        }	
		return str.length();
	}
	int [][]getTable(){
		int table[][]=new int[62][2];
		for(int i='A';i<='Z';i++){
			table[i-'A'][0]=i;
			table[i-'A'][1]=this.table[i];
		}
		for(int i='a';i<='z';i++){
			table[i-'a'+26][0]=i;
			table[i-'a'+26][1]=this.table[i];
		}
		for(int i='0';i<='9';i++){
			table[i-'0'+52][0]=i;
			table[i-'0'+52][1]=this.table[i];
		}
		for(int i=0;i<62;i++){
			for(int j=62-1;j>i;j--){
				if(table[j-1][1]<table[j][1]){
					int tmp;
					tmp=table[j-1][1];
					table[j-1][1]=table[j][1];
					table[j][1]=tmp;
					tmp=table[j-1][0];
					table[j-1][0]=table[j][0];
					table[j][0]=tmp;
				}
			}
		}
		return null;
	}
	String printTable(){
		// TODO Complete this function
		return null;
	}
	void doHuffman(){
		
	}
	int []getHuffmanCode(){
		// TODO Complete this function
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
