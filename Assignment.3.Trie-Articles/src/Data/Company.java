package Data;

public class Company {
	public Name primeName;
	public Name []synNames;
	Dict dict;
	public Integer hitcount;
	public Company(Dict dict){
		this.dict=dict;
		this.hitcount=null;
	}
	public Company(Dict dict, String line){
		this(dict);
//		System.out.println(line);
		String []lists=line.split("\t");
		
		primeName=new Name(dict, lists[0]);
		synNames=new Name[lists.length];
		
		for(int i=0;i<lists.length;i++){
			StringBuffer sb=new StringBuffer();
			for(int j=0;j<lists[i].length();j++){
				char c=lists[i].charAt(j);
				if(c>='A' && c<='Z') sb.append(c);
				if(c>='a' && c<='z') sb.append(c);
				if(c>='0' && c<='9') sb.append(c);
				if(c==' ') sb.append(c);
			}
			synNames[i]=new Name(dict, sb.toString());
		}
	}
}
