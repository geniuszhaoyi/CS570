/**
 * @author ZhaoYi
 *
 */
public class LSP {
	public int ori_router_ID;
	public int seq;
	public int ttl;
	public Table[] tables;
	
	public LSP duplicate(){
		LSP lsp=new LSP();
		lsp.ori_router_ID=this.ori_router_ID;
		lsp.seq=this.seq;
		lsp.ttl=this.ttl;
		lsp.tables=this.tables;
		return lsp;
	}
}
