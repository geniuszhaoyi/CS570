import Data.Article;
import Data.Company;


public class alg_search implements Algorithm{

	@Override
	public void genmap(Company[] companies, Article article) {		
		for(int i=0;i<companies.length;i++){
			int sum=0;
			int []articlewords=article.words.clone();
			for(int j=0;j<companies[i].synNames.length;j++){
				sum+=kmp(articlewords, companies[i].synNames[j].words);
			}
//			for(int j=0;j<articlewords.length;j++){
//				System.out.print(articlewords[j]+"\t");
//			}
//			System.out.println();
			companies[i].hitcount=sum;
		}
	}
	void getNext(int[] pattern, int next[]) {  
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
    int kmp(int[] s, int[] pattern) {  
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
                //replace matched chars with unused ID 1
//                for(int k=i-plen;k<i;k++){
//                	s[k]=1;
//                }
            }
        }
        return sum;  
    }

}
