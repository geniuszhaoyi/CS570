
public class Method1 {
	public static void main(String[] args) {
		IO io=new IO1();
		Algorithm al=new Alg1();
		String [][] companies=io.readCompanys("companies.dat");
		String article=io.readArticle();
		int[]map=al.go(companies, article);
		System.out.println(io.printRelevance(map, companies, article));
	}
}
