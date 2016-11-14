import java.util.Map;

public interface IO {
	String [][]readCompanys(String path);
	String readArticle();
	String printRelevance(Map<Integer, Integer> map);
}
