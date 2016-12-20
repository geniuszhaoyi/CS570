/**
 * @author ZhaoYi
 *
 */
public class Tables {
	public int length;
	public Table[] tables;
	public Table at(int i){
		return tables[i];
	}
	/**
	 * Get the cost from table owner to router 'routerID'
	 */
	public float get_cost_routerID(int routerID){
		for(int i=0;i<length;i++){
			if(tables[i].dst_routerID==routerID) return tables[i].cost;
		}
		return Float.POSITIVE_INFINITY;
	}
	public void set_cost_routerID(int routerID, float cost){
		for(int i=0;i<length;i++){
			if(tables[i].dst_routerID==routerID) tables[i].cost=cost;
		}
	}
	public void set_cost2Inf_routerID(int routerID){
		set_cost_routerID(routerID, Float.POSITIVE_INFINITY);
	}
}
