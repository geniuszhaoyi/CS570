import java.util.ArrayList;

/**
 * @author TanJinyu
 *
 */
public class NetworkPrint {
	public static void print(ArrayList<Table> tables){
		for(int i=0;i<tables.size();i++){
			System.out.println(tables.get(i).dst_routerID+", "+tables.get(i).cost+", "+tables.get(i).outgoing_routerID);
			
		}
	}
}
