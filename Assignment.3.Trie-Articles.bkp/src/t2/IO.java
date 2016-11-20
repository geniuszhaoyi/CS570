package t2;


public interface IO {
	String [][][]readCompanys(String path);
	String []readArticle();
	String printRelevance(int[]map, String [][]companies, int words);
}
