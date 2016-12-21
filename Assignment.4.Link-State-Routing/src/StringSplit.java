
public class StringSplit {
	public static String[] split(String str){
		str=str.replaceAll( "\\s", " " ).trim();
				
		StringBuffer sb=new StringBuffer();
		sb.append(str.charAt(0));
		for(int i=1;i<str.length();i++){
			if(str.charAt(i-1)==' ' && str.charAt(i)==' '){
				// pass
			}else{
				sb.append(str.charAt(i));
			}
		}
		
		return sb.toString().split(" ");
	}
}
