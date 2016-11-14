
///searching the text for each company name
public class Alg1 implements Algorithm {
	@Override
	public int[]go(String[][] companies, String article) {
		int[]map=new int[companies.length];
		
		for(int i=0;i<companies.length;i++){
			int sum=0;
			for(int j=1;j<companies[i].length;j++){
				sum+=kmp(article, companies[i][j]);
			}
			map[i]=sum;
		}

		return map;
	}
	void getNext(String pattern, int next[]) {  
        int j = 0;  
        int k = -1;  
        int len = pattern.length();  
        next[0] = -1;  
        while (j < len - 1) {  
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {  
            	j++;  
                k++;  
                next[j] = k;  
            } else {  
                k = next[k];  
            }  
        }  
    }  
    int kmp(String s, String pattern) {  
        int i = 0;  
        int j = 0;  
        int slen = s.length();  
        int plen = pattern.length();
        int[] next = new int[plen];
        getNext(pattern, next);
        int sum=0;
        while (i < slen && j < plen) {  
            if (s.charAt(i) == pattern.charAt(j)) {  
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
            }
        }
        return sum;  
    }  
}
