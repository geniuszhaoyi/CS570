import java.io.*;
import java.util.*;

/**
 * @author TanJinyu
 *
 */
class IRouter extends Router{
	ArrayList<Link>arrlinks = new ArrayList<Link>();
}
public class FileReader {
	public Router[] read_infile_dat(){
		try{
			Scanner s = new Scanner(new File("infile.dat"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNextLine()){
				list.add(s.nextLine());
			}
			s.close();
			String[] text = new String[list.size()];
			text = list.toArray(text);
			ArrayList<IRouter> RS= new ArrayList<IRouter>();
			IRouter CR = null;
			for(int i=0;i<text.length;i++){
				if(text[i].charAt(0)=='\t'||text[i].charAt(0)==' '){
					Link CL=new Link();	//Current Link
					String[] parts=StringSplit.split(text[i]);
					if(parts.length==1){
						CL.dst_router_id=Integer.parseInt(parts[0]);
						CL.init_link_cost=1.0f;
						CR.arrlinks.add(CL);
					}
					else{
						CL.dst_router_id=Integer.parseInt(parts[0]);
						CL.init_link_cost=Float.valueOf(parts[1]);
						CR.arrlinks.add(CL);
					}
				}else{
					CR = new IRouter();	//Current Router
					String[] parts=StringSplit.split(text[i]);
					CR.arrlinks=new ArrayList<Link>();
					if(parts.length==2){
						CR.routerID=Integer.parseInt(parts[0]);
						CR.name=parts[1];
						CR.network_cost=1.0f;
						RS.add(CR);
					}
					else{
						CR.routerID=Integer.parseInt(parts[0]);
						CR.name=parts[1];
						CR.network_cost=Float.valueOf(parts[2]);
						RS.add(CR);
					}
				}

			}
			
			Router[] routers=new Router[RS.size()];
			for(int j=0;j<RS.size();j++){
				IRouter ir=RS.get(j);
				ir.links=new Link[ir.arrlinks.size()];
				ir.links=ir.arrlinks.toArray(ir.links);
				ir.arrlinks=null;
				routers[j]=ir;
			}

			return routers;
		}catch(FileNotFoundException e){
			System.out.println("file not found");
			System.exit(0);
		}
		return null;
	}
}