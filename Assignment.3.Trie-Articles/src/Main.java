
public class Main {
	public static void main(String[] args) {
		IO io=new IO1();
		Algorithm al=new Alg1();
		System.out.println(al.go(io.readCompanys("companies.dat"), io.readArticle()));
	}
}
