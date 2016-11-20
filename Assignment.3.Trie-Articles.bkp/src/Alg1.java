
///searching the text for each company name
public class Alg1 implements Algorithm {
	@Override
	public int[]go(String[][] companies, String raw_article) {
		int[]map=new int[companies.length];
		String article=Util.rmpr(raw_article);
		
		for(int i=0;i<companies.length;i++){
			int sum=0;
			char art_arr[]=article.toCharArray();
			for(int j=1;j<companies[i].length;j++){
				companies[i][j]=Util.rmpr(companies[i][j]);
				sum+=kmp(art_arr, companies[i][j].toCharArray());
			}
			System.out.println(art_arr);
			System.out.println();
			System.out.println();
			map[i]=sum;
		}

		return map;
	}
	void getNext(char[] pattern, int next[]) {  
        int j = 0;  
        int k = -1;  
        int len = pattern.length;  
        next[0] = -1;  
        while (j < len - 1) {  
            if (k == -1 || pattern[k] == pattern[j]) {  
            	j++;  
                k++;  
                next[j] = k;  
            } else {  
                k = next[k];  
            }  
        }  
    }  
    int kmp(char[] s, char[] pattern) {  
        int i = 0;  
        int j = 0;  
        int slen = s.length;  
        int plen = pattern.length;
        int[] next = new int[plen];
        getNext(pattern, next);
        int sum=0;
        while (i < slen && j < plen) {  
            if (s[i] == pattern[j]) {  
                i++;
                j++;
            } else {
                if (next[j] == -1) {  
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }
            }
            if (j == plen) {
                sum+=1;
                j=0;
                //replace matched chars with special chars '#'
                for(int k=i-plen;k<i;k++){
                	s[k]='#';
                }
            }
        }
        return sum;  
    }  
}
