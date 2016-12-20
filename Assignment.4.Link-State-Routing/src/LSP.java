/**
 * @author ZhaoYi
 *
 */
public class LSP {
	public int ori_router_ID;
	public int seq;
	public int ttl;
	public Tables tables;
	
	public LSP(){
		
	}
	public LSP(LSP lsp){
		this.ori_router_ID=lsp.ori_router_ID;
		this.seq=lsp.seq;
		this.ttl=lsp.ttl;
		this.tables=lsp.tables;
	}
	public LSP duplicate(){
		LSP lsp=new LSP();
		lsp.ori_router_ID=this.ori_router_ID;
		lsp.seq=this.seq;
		lsp.ttl=this.ttl;
		lsp.tables=this.tables;
		return lsp;
	}
}
