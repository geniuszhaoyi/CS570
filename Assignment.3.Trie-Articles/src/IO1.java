import java.util.*;
import java.io.*;

public class IO1 implements IO {

	@Override
	public String[][] readCompanys(String path) {
		// TODO Auto-generated method stub
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  
			  
            /* ����TXT�ļ� */  
            String pathname = path; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
            File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // ����һ������������reader  
            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line = "";  
            line = br.readLine();  
            List<String[]> ans=new ArrayList<String[]>();
            while (line != null) {  
                line = br.readLine(); // һ�ζ���һ������  
                String lists[]=line.split("\t");
                ans.add(lists);
            }
            
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
	public String printRelevance(Dict dict) {
		// TODO Auto-generated method stub
		return null;
	}

}