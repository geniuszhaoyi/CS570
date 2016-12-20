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
	public Map<Integer,Router> ID_to_Router;	//
	
	public Tables tables;	//routing table
	public int lsp_seq=1;
		
	int tick=0;
	public Map<Integer,Integer> LastSeenTick=new HashMap<Integer,Integer>();
	//public int[] LastSeenTick;
	public Map<Integer,Integer> SeenSEQFromRouter=new HashMap<Integer,Integer>();
	
	public void receivePacket(LSP rclsp, int senderID){
		LSP lsp=new LSP(rclsp);
		lsp.ttl-=1;
		LastSeenTick.put(senderID, tick); //I see this router on this tick
		if(lsp.ttl<=0 || (SeenSEQFromRouter.get(lsp.ori_router_ID)!=null && 
				lsp.ttl<=SeenSEQFromRouter.get(lsp.ori_router_ID))){
			//Discard this LSP
		}else{
			//LSP not discarded
			SeenSEQFromRouter.put(senderID, lsp.seq); //Highest SEQ from this router
			//Compare with routing table
			float cost_this_to_LSPOrigin=this.tables.get_cost_routerID(lsp.ori_router_ID);
			for(int i=0;i<lsp.tables.length;i++){
				float cost_ori_to_dst=lsp.tables.get_cost_routerID(lsp.tables.at(i).dst_routerID);
				float cost_this_to_dst=this.tables.get_cost_routerID(lsp.tables.at(i).dst_routerID);
				if(cost_this_to_dst > cost_this_to_LSPOrigin + cost_ori_to_dst){
					cost_this_to_dst = cost_this_to_LSPOrigin + cost_ori_to_dst;
					this.tables.set_cost_routerID(lsp.tables.at(i).dst_routerID,cost_this_to_dst);
				}
			}
			
			//send out LSP
			for(int i=0;i<links.length;i++) if(links[i].dst_router_id!=senderID) 
				ID_to_Router.get(links[i].dst_router_id).receivePacket(lsp, routerID);
		}
	}

	public void originatePacket(){
		tick+=1;
		//directly connected routers no response
		
		for(int i=0;i<links.length;i++){
			if(LastSeenTick.get(links[i].dst_router_id)<=tick-2){
				this.tables.set_cost2Inf_routerID(links[i].dst_router_id);
			}
		}
		
		LSP lsp=new LSP();
		lsp.ori_router_ID=routerID;
		lsp.seq=lsp_seq; lsp_seq+=1;
		lsp.ttl=10;
		lsp.tables=tables;
		
		for(int i=0;i<links.length;i++)
			ID_to_Router.get(links[i].dst_router_id).receivePacket(lsp, routerID);
	}
}
