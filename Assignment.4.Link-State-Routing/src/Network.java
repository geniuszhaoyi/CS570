import java.util.*;
import java.util.Map.Entry;

/**
 * @author ZhaoYi
 *
 */
public class Network {
	public Map<Integer,Router> routers=new HashMap<Integer,Router>();
	
	public Network(FileReader fr){
		Router[] rl=fr.read_infile_dat();
		for(int i=0;i<rl.length;i++){
			rl[i].ID_to_Router=routers;
			rl[i].init_router();
			routers.put(rl[i].routerID, rl[i]);
		}
	}
		
	public void Continue(){
		System.out.println(">>continue");
		Iterator<Entry<Integer, Router>> entries = routers.entrySet().iterator();
		while(entries.hasNext()){
			Map.Entry<Integer, Router> entry = entries.next();
		    Router value = entry.getValue();
		    value.originatePacket();
		}
	}
	public void Print(int routerID){
		System.out.println(">>print "+routerID);
		NetworkPrint.print(routers.get(routerID).tables.tables);
	}
	public void ShutDown(int routerID){
		System.out.println(">>shutdown "+routerID);
		routers.get(routerID).ON=false;
	}
	public void StartUp(int routerID){
		System.out.println(">>startup "+routerID);
		routers.get(routerID).ON=true;		
	}
}
