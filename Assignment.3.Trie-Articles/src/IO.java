import java.io.IOException;

import Data.*;

public interface IO {
	String []readLines();
	String []readLines(String file) throws IOException;
	String read2Period();
	String read2Period(String file);
	String printRelevance(Company []companies, Article article);
}
