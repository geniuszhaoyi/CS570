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
			ans+=table[i][1]+"\t"+(char)table[i][0]+", "+(table[i][1]/sum*100.0)+"%\n";
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
	static void writeFile(String filename, String content){
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
			e.printStackTrace();
		}	
	}
	
	public static void main(String args[]){
		String input="infile.dat";
		String str=readFileByChars(input);
		String ans="";
		Huffman1 hf=new Huffman1();
		hf.add(str);
		ans+=hf.printTable();
		hf.doHuffman();
		ans+=hf.printHuffmanCode();
		ans+=hf.getEncoded(str).length();
		writeFile("outfile.dat",ans);
	}
}
