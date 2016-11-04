import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


class HN{
	char ch;
	int cnt;
	HN left, right;
	int depth;
	public HN(char ch, int cnt, HN left, HN right, int depth){
		this.ch=ch;
		this.cnt=cnt;
		this.left=left;
		this.right=right;
		this.depth=depth;
	}
}

class HNcmp implements Comparator<HN>{
    @Override
    public int compare(HN x, HN y){
        if(x.cnt!=y.cnt) return x.cnt-y.cnt;
        return x.depth-y.depth;
    }
}

public class Huffman1 {
	int table[]=new int[256];
	public Huffman1(){
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
		int i;
		for(i=0;i<62;i++){
			if(table[i][1]==0) break;
		}
		int [][]ans=new int[i][2];
		for(int j=0;j<i;j++){
			ans[j][0]=table[j][0];
			ans[j][1]=table[j][1];
		}
		return ans;
	}
	public String printTable(){
		int[][]table=getTable();
		double sum=0.0;
		String ans="";
		for(int i=0;i<table.length; i++)
			sum+=table[i][1];
		for(int i=0;i<table.length; i++){
			if(table[i][1]==0) break;
			ans+=(char)table[i][0]+", "+(table[i][1]/sum*100.0)+"%\n";
		}
		return ans;
	}
	HN root=null;
	void doHuffman(){
		int[][]table=getTable();
		Comparator<HN> comparator=new HNcmp();
        PriorityQueue<HN> queue=new PriorityQueue<HN>(10, comparator);
        
        for(int i=0;i<table.length;i++){
        	queue.add(new HN((char)table[i][0],table[i][1],null,null,1));
        }
        
		while(queue.size()>=2){
			HN x=queue.remove();
			HN y=queue.remove();
			HN n=new HN((char)-1,x.cnt+y.cnt,x,y,Math.max(x.depth, y.depth)+1);
			queue.add(n);
		}
		
		root=queue.remove();
	}
	void gethc(String []ans, HN node, String cnt){
		if(node.left==null && node.right==null && node.ch!=(char)-1){
			ans[node.ch]=new String(cnt);
		}else if(node.left!=null && node.right!=null && node.ch==(char)-1){
			gethc(ans,node.left,cnt+'0');
			gethc(ans,node.right,cnt+'1');
		}else{
			System.out.println(node.left);
			System.out.println(node.right);
			System.out.println(node.ch);
			System.out.println(node.depth);
			System.out.println(cnt);
			System.out.println("#################\nERROR! \n#################");
		}
	}
	String []getHuffmanCode(){
		String []ans=new String[256];
		gethc(ans,root,"");
		return ans;
	}
	String printHuffmanCode(){
		String huffmanCode[]=getHuffmanCode();
        String ans="";
 		for(int i=0;i<256;i++){
 			if(huffmanCode[i]==null) continue;
 			ans+=(char)i+", "+huffmanCode[i]+"\n";
 		}
 		return ans;
	}
	String getEncoded(String str){
		String huffmanCode[]=getHuffmanCode();
		StringBuffer sb = new StringBuffer("");		
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			if(huffmanCode[ch]==null) continue;
			sb.append(huffmanCode[ch]);
		}
		return sb.toString();
	}
	/*
	 *  http://www.cnblogs.com/lovebread/archive/2009/11/23/1609122.html
	 */
	static String readFileByChars(String fileName) throws Exception{
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
            throw new Exception(e.getMessage());
        }
        return ans.toString();
	}
	static void writeFile(String filename, String content) throws Exception{
		try {
			File file = new File(filename);
			
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			throw new Exception(e.getMessage());
		}	
	}
	public void stringcheck(String str) throws Exception{
		if(str==null) throw new Exception("String not exist! ");
		if(str.length()==0) throw new Exception("String is empty! Check your infile.dat");
		if(str.length()<=1) throw new Exception("String is too short! Check your infile.dat");
		
		int i;
		int table[]=new int[256];
		for(i=0;i<256;i++) table[i]=0;
		
		int j=0;
		for(i=0;i<str.length();i++){
			table[str.charAt(i)]+=1;
		}
		for(i='a';i<='z';i++){
			if(table[i]!=0) j+=1;
		}
		for(i='A';i<='Z';i++){
			if(table[i]!=0) j+=1;
		}
		for(i='0';i<='9';i++){
			if(table[i]!=0) j+=1;
		}
		if(j<=1) throw new Exception("too few difference chars! Check your infile.dat");
		
		if(str.length()>=100000000) throw new Exception("String is too large! Check your infile.dat");
		
		
	}
	public static void main(String args[]){
		try{
			String input="infile.dat";
			Huffman1 hf=new Huffman1();
			String ans="";
			String str="";
			str=readFileByChars(input);
			hf.stringcheck(str);			
			hf.add(str);
			ans+="- 1. The frequency table for the source text\n";
			ans+=hf.printTable();
			hf.doHuffman();
			ans+="\n- 2. The Huffman code for each letter and digit in the source code\n";
			ans+=hf.printHuffmanCode();
			ans+="\n- 3. The length of the coded message in terms of number of bits\n";
			ans+=hf.getEncoded(str).length();
			writeFile("outfile.dat",ans);
			System.out.println("Succeed! See outfile.dat");
		}catch(Exception e){
			System.out.println("########\nERROR!\n########");
			System.out.println(e.getMessage());
//			e.printStackTrace();
			return ;
		}
	}
}
