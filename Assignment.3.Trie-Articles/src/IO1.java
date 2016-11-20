import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Data.Article;
import Data.Company;


public class IO1 implements IO {
	@Override
	public String[] readLines() {
		return null;
	}

	@Override
	public String[] readLines(String pathname) throws IOException {
        File filename = new File(pathname);  
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));  
        BufferedReader br = new BufferedReader(reader);  
        String line = "";  
        List<String> ans=new ArrayList<String>();
        while (line != null) {  
            line = br.readLine();
            if(line==null || line.length()==0 || line=="\n") continue;
//            System.out.print("|"+line+"|");
//            System.out.println(line.length());
            ans.add(line);
        }
        br.close();
        return ans.toArray(new String[ans.size()]);

	}

	@Override
	public String read2Period() {
		Scanner sin=new Scanner(System.in);
		StringBuffer sb=new StringBuffer();
		System.out.println("Input your article: ");
		while(true){
			String str=sin.nextLine();
			if (str.compareTo(".")==0) break;
			sb.append(str+"\n");
		}
		sin.close();
		return sb.toString();
	}

	@Override
	public String read2Period(String file) {
		return null;
	}
	
	int companymaxlength=7;		//"Company".length()+3
	int hitcountmaxlength=9;	//"Hit Count".length()+2
	
	StringBuffer formline(String company, String hitcount, String relevance){
		StringBuffer sb=new StringBuffer();
		
		sb.append(company);
		for(int i=-2;i<companymaxlength-company.length();i++) sb.append(' ');
		sb.append(hitcount);
		for(int i=-2;i<hitcountmaxlength-hitcount.length();i++) sb.append(' ');
		sb.append(relevance);
		
		sb.append('\n');

		return sb;
	}

	@Override
	public String printRelevance(Company []companies, Article article) {
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<companies.length;i++){
			int x=companies[i].primeName.name.length();
			if(companymaxlength<x) companymaxlength=x;
		}
		for(int i=0;i<companies.length;i++){
			int x=(int)Math.log10(companies[i].hitcount)+1;
			if(hitcountmaxlength<x) hitcountmaxlength=x;
		}
		
		sb.append(formline("Company", "Hit Count", "Relevance"));
		
		int sum=0;
		for (int i=0;i<companies.length;i++){
			sb.append(formline(companies[i].primeName.name, ""+companies[i].hitcount, (double)companies[i].hitcount*100.0/article.totleWords+"%"));
			sum+=companies[i].hitcount;
		}
		
		sb.append(formline("Totle:",""+sum,((double)sum*100.0/article.totleWords)+"%"));
		sb.append("Total Words: "+article.totleWords+"\n");
		return sb.toString();
	}

}
