/**
 * @author ZhaoYi
 *
 */
public class Table {
	public int dst_routerID;
	public float cost;
	public int outgoing_routerID;
	public Table(int dst_routerID, float cost, int outgoing_routerID){
		this.dst_routerID=dst_routerID;
		this.cost=cost;
		this.outgoing_routerID=outgoing_routerID;
	}
	public Table(Table table){
		this.dst_routerID=table.dst_routerID;
		this.cost=table.cost;
		this.outgoing_routerID=table.outgoing_routerID;
	}
}
