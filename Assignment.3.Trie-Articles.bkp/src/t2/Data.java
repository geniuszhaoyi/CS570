package t2;
import IO;

import java.util.Map;


public class Data {
	String []article; 
	String [][][]companies;
	int []map;
	Algorithm alg;
	IO io;
	Map<String, Integer> dict;
	public Data(){
		this(null,null);
	}
	public Data(Algorithm alg, IO io){
		this.alg=alg;
		this.io=io;
	}
	public String go() throws Exception{
		if(alg==null || io==null) throw new Exception("\"Peremeter alg or io is null\"");
		
		companies=io.readCompanys("companies.dat");
		article=io.readArticle();
		
		map=alg.genmap(companies, article);
		
		return io.printRelevance(map, companies, alg.words(article));
	}
}
