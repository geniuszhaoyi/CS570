import java.util.HashMap;
import java.util.Map;


public class Dict {
	Map<String, Integer> map;
	public Dict(){
		map=new HashMap<String, Integer>();
	}
	public Integer set(String key, int val){
		return map.put(key,val);
	}
	public Integer get(String key){
		return map.get(key);
	}
}
