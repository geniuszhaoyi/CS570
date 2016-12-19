/**
 * @author ZhaoYi
 *
 */
public class Table {
	public String routerName;
	public float cost;
	public Link outgoing;
	public Table(String n, float c){
		routerName=n;
		cost=c;
	}
}
