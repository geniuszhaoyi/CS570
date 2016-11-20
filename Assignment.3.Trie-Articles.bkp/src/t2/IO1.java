package t2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class IO1 implements IO {

	@Override
	public String[][][] readCompanys(String path) {
		try {
            String pathname = path;  
            File filename = new File(pathname);  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));  
            BufferedReader br = new BufferedReader(reader);  
            String line = "";  
            List<String[][]> ans=new ArrayList<String[][]>();
            while (line != null) {  
                line = br.readLine();  
                String lists[]=("\t"+line).split("\t");
                if(lists.length==2) break;
                String ll[][]=new String[lists.length][];
                for(int i=0;i<lists.length;i++){
                	ll[i]=lists[i].split(" ");
                }
                ll[0][0]=lists[1];
                ans.add(ll);
            }
            br.close();
            return ans.toArray(new String[ans.size()][][]);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String []readArticle() {
		Scanner sin=new Scanner(System.in);
		StringBuffer sb=new StringBuffer();
		System.out.println("Input your article: ");
		while(true){
			String str=sin.nextLine();
			if (str.compareTo(".")==0) break;
			sb.append(str);
		}
		sin.close();
		return Util.rmpr(sb.toString()).split(" ");
	}

	int companymaxlength=7+2;		//"Company".length()+2
	int hitcountmaxlength=9+2;	//"Hit Count".length()+2
	int relevancemaxlength=9+2;	//"Relevance".length()+2
	
	StringBuffer formline(String company, String hitcount, String relevance){
		StringBuffer sb=new StringBuffer();
		
		sb.append(company);
		for(int i=0;i<companymaxlength-company.length();i++) sb.append(' ');
		sb.append(hitcount);
		for(int i=0;i<hitcountmaxlength-hitcount.length();i++) sb.append(' ');
		sb.append(relevance);
		for(int i=0;i<relevancemaxlength-relevance.length();i++) sb.append(' ');
		
		sb.append('\n');

		return sb;
	}
	
	@Override
	public String printRelevance(int[] map, String [][] companies, int totle) {
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<companies.length;i++){
			int x=companies[i][0].length();
			if(companymaxlength<x) companymaxlength=x;
		}
		for(int i=0;i<companies.length;i++){
			int x=(int)Math.log10(map[i])+1;
			if(hitcountmaxlength<x) hitcountmaxlength=x;
		}
		for(int i=0;i<companies.length;i++){
			int x=companies[i][1].length();
			if(relevancemaxlength<x) relevancemaxlength=x;
		}
		
		sb.append(formline("Company", "Hit Count", "Relevance"));
		
		int sum=0;
		for (int i=0;i<map.length;i++){
			sb.append(formline(companies[i][0], ""+map[i], (double)map[i]/totle+"%"));
			sum+=map[i];
		}
		
		sb.append(formline("Totle:",""+sum,((double)sum/totle)+"%"));

		return sb.toString();
	}
}
