import java.util.*;

/**
 * @author ZhaoYi
 *
 */
public class Router {
	public int routerID;
	public String name;
	public float network_cost;
	public Link[] links;	//direct connected routers
	public Table[] tables;	//routing table
	public Map<Integer,Integer> SeenSEQFromRouter=new HashMap<Integer,Integer>();
	public int lsp_seq=1;
	
	public void receivePacket(LSP lsp, int senderID){
		lsp.ttl-=1;
		if(lsp.ttl<=0 || (SeenSEQFromRouter.get(lsp.ori_router_ID)!=null && 
				lsp.ttl<=SeenSEQFromRouter.get(lsp.ori_router_ID))){
			//Discard this LSP
		}else{
			//Compare with routing table
			// TODO Auto-generated method stub
			
			//send out LSP
			for(int i=0;i<links.length;i++) if(links[i].dst_router_id!=senderID) 
				links[i].dst_router.receivePacket(lsp, routerID);
		}
	}
	/**
	 * The router class should also contain a function named something similar to originatePacket 
	 * that takes no arguments. This function will perform two functions. It should cause the router 
	 * to generate an LSP packet based on the current state of the network as it understands it, 
	 * and send it to all directly connected routers. Before it sends the packet, however, it should 
	 * also increment a "tick" counter and consider if there are any directly connected routers 
	 * from which it has not received a packet in 2 ticks. If that occurs, the router should alter 
	 * its graph to reflect that the cost of the link to the other router is now infinity (or some 
	 * arbitrarily huge number that you choose to represent infinity, if your language does not 
	 * have a special infinity value.).
	 */
	public void originatePacket(){
		LSP lsp=new LSP();
		lsp.ori_router_ID=routerID;
		lsp.seq=lsp_seq; lsp_seq+=1;
		lsp.ttl=10;
		lsp.tables=new Table[tables.length];
		// TODO Auto-generated method stub
	}
}
