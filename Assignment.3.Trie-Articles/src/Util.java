
public class Util {
	static String rmpr(String str){
		StringBuffer sb=new StringBuffer();
		for(int i = 0; i < str.length(); i++){
			char c=str.charAt(i);
            if(c>='A' && c<='Z') sb.append(c);
            else if(c>='a' && c<='z') sb.append(c);
            else if(c>='0' && c<='9') sb.append(c);
//            else if(c=='\n' || c==' '){sb.append(' ');} 
            else{
            	if(i>=1 && sb.charAt(sb.length()-1)!=' ')	//not efficiency
            		sb.append(' ');
            }
        }
		if(sb.charAt(sb.length()-1)!=' ') sb.append(' ');
		return sb.toString();
	}

}
