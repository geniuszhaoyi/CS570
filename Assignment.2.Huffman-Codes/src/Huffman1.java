import java.io.*;

public class Huffman1 {
	String text="";
	int textlength=0;
	int table[]=new int[256];
	public Huffman1(){
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
		return table;
	}
	public String printTable(){
		int[][]table=getTable();
		double sum=0.0;
		String ans="";
		for(int i=0;i<table.length; i++)
			sum+=table[i][1];
		for(int i=0;i<table.length; i++){
			if(table[i][1]==0) break;
			ans+=(char)table[i][0]+" "+(table[i][1]/sum*100.0)+"%\n";
		}
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
        String ans="";
 		for(int i='0';i<='9';i++){
 		ans+=(char)i+", "+huffmanCode[i]+"\n";	
 		}
 		for(int i='A';i<='Z';i++){
 			ans+=(char)i+", "+huffmanCode[i]+"\n";
 			}
 		for(int i='a';i<='z';i++){
 			ans+=(char)i+", "+huffmanCode[i]+"\n";
 			}
 		return ans;
	}
	String getEncoded(){
		// TODO Complete this function
		return null;
	}
	/*
	 *  http://www.cnblogs.com/lovebread/archive/2009/11/23/1609122.html
	 */
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
	static void writeFile(String filename, String str){
		try {

			String content = str;

			File file = new File("filename.txt");
			
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String args[]){
		String input="infile.dat";
		String str=readFileByChars(input);
		Huffman1 hf=new Huffman1();
		hf.add(str);
		System.out.println(hf.printTable());
	}
}
