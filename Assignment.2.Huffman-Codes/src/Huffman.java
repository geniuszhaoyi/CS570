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
		// TODO Complete this function
		return 0;
	}
	public int add(String str){
		// TODO Complete this function
		return 0;
	}
	int []getTable(){
		// TODO Complete this function
		return null;
	}
	String printTable(){
		// TODO Complete this function
		return null;
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