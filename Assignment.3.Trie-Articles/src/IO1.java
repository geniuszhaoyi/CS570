import java.util.*;
import java.io.*;

public class IO1 implements IO {
	int totle=0;
	
	String rmpr(String str){
		StringBuffer sb=new StringBuffer();
		for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
        }
		return sb.toString();
	}
	
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
                line = "\n"+br.readLine();  
                String lists[]=line.split("\t");
                lists[0]=lists[1];
                for(int i=1;i<lists.length;i++) lists[i]=rmpr(lists[i]);
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
		Scanner sin=new Scanner(System.in);
		sin.nextLine();
		StringBuffer sb=new StringBuffer();
		while(true){
			String str=sin.nextLine();
			if (str==".") break;
			sb.append(str);
		}
		sin.close();
		return rmpr(sb.toString());
	}

	@Override
	public String printRelevance(int[] map, String [][] companies) {
		StringBuffer sb=new StringBuffer();
		sb.append("Company\tHit Count\tRelevance\n");
		int sum=0;
		for (int i=0;i<map.length;i++){
			sb.append(companies[i][0]+"\t"+map[0]+"\t"+((double)map[0]/totle)+"%\n");
			sum+=map[0];
		}
		sb.append("Totle:\t"+sum+"\t"+((double)sum/totle)+"\n");
		sb.append("Totle Words:\t"+sum+'\n');
		return sb.toString();
	}
}
