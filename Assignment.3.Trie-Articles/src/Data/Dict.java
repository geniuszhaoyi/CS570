package Data;

import java.util.*;

public class Dict {
	Map<String, Integer> Name2ID;
	int IDTop;
	Map<Integer, String> ID2Name;
	public Dict(){
		Name2ID=new HashMap<String,Integer>();
		IDTop=64;	//ID 0-63 are Reserved
	}
	public int getID(String name){
		return Name2ID.get(name);
	}
	public void put(String name, int id){
		Name2ID.put(name, id);
	}
	public int add(String name){
		if(Name2ID.get(name)==null){
			Name2ID.put(name,IDTop);
			IDTop+=1;
		}
		return Name2ID.get(name);
	}
	public int[] bunchadd(String []strwords){
		int []words=new int[strwords.length];
		for(int i=0;i<strwords.length;i++){
			words[i]=this.add(strwords[i]);
		}
		return words;
	}
}
