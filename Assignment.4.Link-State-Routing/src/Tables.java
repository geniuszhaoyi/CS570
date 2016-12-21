import java.util.*;

/**
 * @author ZhaoYi
 *
 */
public class Tables {
	public ArrayList<Table> tables=new ArrayList<Table>();

	public int length(){
		return tables.size();
	}
	public Table at(int i){
		return tables.get(i);
	}
	/**
	 * Get the cost from table owner to router 'routerID'
	 */
	public float get_cost_routerID(int routerID){
		for(int i=0;i<length();i++){
			if(tables.get(i).dst_routerID==routerID) return tables.get(i).cost;
		}
		return Float.POSITIVE_INFINITY;
	}
	public int get_outgoingrouterID_routerID(int routerID){
		for(int i=0;i<length();i++){
			if(tables.get(i).dst_routerID==routerID) return tables.get(i).outgoing_routerID;
		}
		return -1;
	}
	public void set_table(int routerID, float cost, int outgoing_routerID){
		int i;
		for(i=0;i<length();i++){
			if(tables.get(i).dst_routerID==routerID){
				tables.get(i).cost=cost;
				tables.get(i).outgoing_routerID=outgoing_routerID;
				break;
			}
		}
		if(i==length()){	// routerID not in tables
			Table table=new Table(routerID, cost, outgoing_routerID);
			tables.add(table);
		}
	}
	public void set_cost2Inf_routerID(int routerID){
		for(int i=0;i<length();i++){
			if(tables.get(i).dst_routerID==routerID){
				tables.get(i).cost=Float.POSITIVE_INFINITY;
			}
			if(tables.get(i).outgoing_routerID==routerID){
				tables.get(i).cost=Float.POSITIVE_INFINITY;
			}
		}
	}
	public Tables gene_LSPTables(){
		Tables tables=new Tables();
		
		ArrayList<Table> clonedList = new ArrayList<Table>(this.tables.size());
	    for (Table table : this.tables) {
	        clonedList.add(new Table(table));
	    }
	    tables.tables=clonedList;
	    
		return tables;
	}
}
