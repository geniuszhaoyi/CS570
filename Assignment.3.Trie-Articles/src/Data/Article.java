package Data;

import java.util.HashMap;
import java.util.Map;

public class Article {
	String article;
	public int totleWords;
	public String []strwords;
	public int[] words;
	Dict dict;
	public Article(Dict dict){
		this.dict=dict;
		totleWords=0;
	}
	public Article(Dict dict, String raw_article){
		this.dict=dict;
		StringBuffer sb=new StringBuffer();
		for(int j=0;j<raw_article.length();j++){
			char c=raw_article.charAt(j);
			if(c>='A' && c<='Z') sb.append(c);
			else if(c>='a' && c<='z') sb.append(c);
			else if(c>='0' && c<='9') sb.append(c);
			else if(c==' ' && sb.charAt(sb.length()-1)!=' '){
				sb.append(" ");
			}
			else if(c=='\n'){
				if(sb.charAt(sb.length()-1)!=' ')
					sb.append(" # ");
				else
					sb.append("# ");
			}
		}
		this.article=sb.toString();
		
		strwords=this.article.split(" ");
		words=dict.bunchadd(strwords);
		
		String []sws={"a", "an", "the", "and", "or", "but", "#"};
		Map<String, Integer> stopwords=new HashMap<String, Integer>();
		for(int i=0;i<sws.length;i++) stopwords.put(sws[i], 1);
		
		int sum=0;
		for(int i=0;i<strwords.length;i++){
			Integer x=stopwords.get(strwords[i].toLowerCase());
			if(x==null) sum+=1;
		}
		totleWords=sum;
	}	
}
