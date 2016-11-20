import java.util.*;
import java.io.*;

public class IO1 implements IO {		
	@Override
	public String[][] readCompanys(String path) {
		try {
            String pathname = path;  
            File filename = new File(pathname);  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));  
            BufferedReader br = new BufferedReader(reader);  
            String line = "";  
            List<String[]> ans=new ArrayList<String[]>();
            while (line != null) {  
                line = br.readLine();  
                String lists[]=("\t"+line).split("\t");
                if(lists.length==2) break;
                lists[0]=lists[1];
                ans.add(lists);
            }
            br.close();
            return ans.toArray(new String[ans.size()][]);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readArticle() {
		Scanner sin=new Scanner(System.in);
		StringBuffer sb=new StringBuffer();
		System.out.println("Input your article: ");
		while(true){
			String str=sin.nextLine();
			if (str.compareTo(".")==0) break;
			sb.append(str);
		}
		sin.close();
		return Util.rmpr(sb.toString());
	}

	@Override
	public String printRelevance(int[] map, String [][] companies, String article) {
		StringBuffer sb=new StringBuffer();
		
		int companymaxlength=7+2;		//"Company".length()+2
		for(int i=0;i<companies.length;i++){
			int x=companies[i][0].length();
			if(companymaxlength<x) companymaxlength=x;
		}
		int hitcountmaxlength=9+2;	//"Hit Count".length()+2
		for(int i=0;i<companies.length;i++){
			int x=(int)Math.log10(map[i])+1;
			if(hitcountmaxlength<x) hitcountmaxlength=x;
		}
		int relevancemaxlength=9+2;	//"Relevance".length()+2
		for(int i=0;i<companies.length;i++){
			int x=companies[i][1].length();
			if(relevancemaxlength<x) relevancemaxlength=x;
		}
		
		
		sb.append("Company\tHit Count\tRelevance\n");
		int totle=article.split(" ").length;
		int sum=0;
		for (int i=0;i<map.length;i++){
			sb.append(companies[i][0]+"\t"+map[i]+"\t"+((double)map[i]/totle)+"%\n");
			sum+=map[i];
		}
		sb.append("Totle:\t"+sum+"\t"+((double)sum/totle)+"\n");
		sb.append("Totle Words:\t"+totle+'\n');
		return sb.toString();
	}
}
