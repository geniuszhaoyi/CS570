package Data;

public class Name {
	Dict dict;
	public int []words;
	public String []strwords;
	public String name;
	public Name(Dict dict){
		this.dict=dict;
	}
	public Name(Dict dict, String name){
		this.name=name;
		strwords=name.split(" ");
		words=dict.bunchadd(strwords);
	}
}
