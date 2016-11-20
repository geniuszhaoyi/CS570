import Data.*;

public class Ctrl {
	Article article; 
	Company []companies;
	Dict dict;
	Algorithm alg;
	IO io;
	public Ctrl(){
		this(null,null);
	}
	public Ctrl(Algorithm alg, IO io){
		this.alg=alg;
		this.io=io;
		dict=new Dict();
	}
	public String go(){
		try{
			return gote();
		}catch(Exception e){
			StringBuffer sb=new StringBuffer();
			sb.append("########  Error!  ########\n");
			//e.printStackTrace();
			sb.append(e.getMessage()+"\n");
			sb.append("########  Error!  ########\n");
			return sb.toString();
		}
	}
	public String gote() throws Exception{
		if(alg==null || io==null || dict==null) throw new Exception("\"Peremeter alg, io or dict is null\"");
		
		String []lines=io.readLines("companies.dat");
		companies=new Company[lines.length];
		for(int i=0;i<lines.length;i++){
			companies[i]=new Company(dict,lines[i]);
		}
		article=new Article(dict,io.read2Period());
		
//		for(int i=0;i<companies.length;i++){
//			for(int j=0;j<companies[i].synNames.length;j++){
//				for(int k=0;k<companies[i].synNames[j].words.length;k++){
//					System.out.print(companies[i].synNames[j].words[k]+",");
//				}
//				System.out.print("\t");
//			}
//			System.out.print("\n");
//		}
		
		alg.genmap(companies, article);
		
		return io.printRelevance(companies, article);
	}
}
