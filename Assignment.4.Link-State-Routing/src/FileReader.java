import java.io.*;
import java.util.*;

/**
 * @author TanJinyu
 *
 */
public class FileReader {
	public Router[] read_infile_dat(){
		Scanner s = new Scanner(new File("infile.dat"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNextLine()){
		    list.add(s.nextLine());
		}
		s.close();
		
		String[] text = new String[list.size()];
		text = list.toArray(text);
		

		
		Router[] routers=new Router[10];
		routers[0].routerID=0;
		routers[0].links=new Link[20];
		routers[0].links[1].init_link_cost=0.0f;
		
		return null;
	}
}
