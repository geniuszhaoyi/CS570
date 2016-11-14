import java.util.*;
import java.io.*;

public class IO1 implements IO {

	@Override
	public String[][] readCompanys(String path) {
		try {
            String pathname = path;  
            File filename = new File(pathname);  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename));  
            BufferedReader br = new BufferedReader(reader);  
            String line = "";  
            line = br.readLine();  
            List<String[]> ans=new ArrayList<String[]>();
            while (line != null) {  
                line = br.readLine();  
                String lists[]=line.split("\t");
                ans.add(lists);
            }
            br.close();
            return ans.toArray(new String[ans.size()][]);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printRelevance(Map<String, Integer> map) {
		StringBuffer sb=new StringBuffer();
		sb.append("Company\tHit Count\tRelevance");
		return null;
	}

}