import java.io.*;
import java.util.*;

/**
 * @author TanJinyu
 *
 */
public class FileReader {
	class ILink{
		int dst_routerID;
		float link_cost;
	}
	class IRouter{
		int routerID;
		String routerName;
		float cost;
		ILink[] links;
	}
	public Router[] read_infile_dat(){
		Scanner s = new Scanner(new File("infile.dat"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNextLine()){
		    list.add(s.nextLine());
		}
		s.close();
		
		String[] text = new String[list.size()];
		text = list.toArray(text);
		

		
		IRouter[] routers=new IRouter[10];
		routers[0].routerID
		routers[0].links=new ILink[20];
		routers[0].links[1].link_cost
		
		return null;
	}
}
