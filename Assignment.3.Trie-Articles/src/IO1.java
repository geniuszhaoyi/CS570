import java.util.*;
import java.io.*;

public class IO1 implements IO {

	@Override
	public String[][] readCompanys(String path) {
		// TODO Auto-generated method stub
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			  
            /* 读入TXT文件 */  
            String pathname = path; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
            File filename = new File(pathname); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(  
                    new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            line = br.readLine();  
            List<String[]> ans=new ArrayList<String[]>();
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据  
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