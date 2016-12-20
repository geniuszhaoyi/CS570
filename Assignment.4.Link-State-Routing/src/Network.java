import java.util.*;

/**
 * @author ZhaoYi
 *
 */
public class Network {
	//Graph g;
	//Router[] routers;
	public Map<Integer,Router> routers;
	
	
	public Network(FileReader fr){
		Router[] rl=fr.read_infile_dat();
		for(int i=0;i<rl.length;i++){
			rl[i].ID_to_Router=routers;
			routers.put(rl[i].routerID, rl[i]);
		}
		
//		
//		IRouter[] ir=new IRouter[10];
//		
//		routers=new HashMap<Integer,Router>();
//		for(int i=0;i<ir.length;i++){
//			Router router=new Router();
//			router.routerID=ir[i].routerID;
//			router.name=new String(ir[i].routerName);
//			router.network_cost=ir[i].cost;
//			
//			
//			
//			routers.put(router.routerID, router);
//		}
//		
//		for(int i=0;i<ir.length;i++) this.routers[i]=new Router();
//
//		for(int i=0;i<ir.length;i++){
//			this.routers[i].routerID=ir[i].routerID;
//			this.routers[i].name=new String(ir[i].routerName);
//			this.routers[i].network_cost=ir[i].cost;
//			this.routers[i].links=new Link[ir[i].links.length];
//			for(int j=0;j<ir[i].links.length;j++){
//				Link link=new Link();
//				link.dst_router_id=ir[i].links[j].dst_routerID;
//				link.init_link_cost=ir[i].links[j].link_cost;
//				for(int k=0;k<ir.length;k++){
//					if(ir[k].routerID==link.dst_router_id){
//						link.dst_router=this.routers[k];
//						break;
//					}
//				}
//			}
//
//		}
		
		
	}
	
	public void Continue(){
		// TODO Auto-generated method stub
		System.out.println(">>continue");
	}
	public void Print(int routerID){
		// TODO Auto-generated method stub
		System.out.println(">>print "+routerID);
		
	}
	public void ShutDown(int routerID){
		// TODO Auto-generated method stub
		System.out.println(">>shutdown "+routerID);
		
	}
	public void StartUp(int routerID){
		// TODO Auto-generated method stub
		System.out.println(">>startup "+routerID);
		
	}
}
