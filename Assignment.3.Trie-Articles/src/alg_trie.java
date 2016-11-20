import java.util.*;

import Data.Article;
import Data.Company;


public class alg_trie implements Algorithm {
	class trie{
		int word=2;	//2 for root
		List<trie> children=new ArrayList<trie>();
		List<Integer> terminal=new ArrayList<Integer>();
	}
	
	void trie_add(trie root, int []name, int index, int companyID){
		if(name.length==index){
			root.terminal.add(companyID);
			return ;
		}
		int i;
		for(i=0;i<root.children.size();i++){
			if(root.children.get(i).word==name[index]){
				break;
			}
		}
		if(i==root.children.size()){
			trie n=new trie();
			n.word=name[index];
			root.children.add(n);
		}
		trie_add(root.children.get(i),name,index+1,companyID);
	}
	
	@Override
	public void genmap(Company[] companies, Article article) {
		trie root=new trie();
		for(int i=0;i<companies.length;i++){
			for(int j=0;j<companies[i].synNames.length;j++){
				trie_add(root,companies[i].synNames[j].words,0,i);
			}
			companies[i].hitcount=0;
		}
		trie p=root;
		int ai=0;
		while(ai<article.words.length){
			int i;
			for(i=0;i<p.children.size();i++){
				if(p.children.get(i).word==article.words[ai]){
					break;
				}
			}
			if(i!=p.children.size()){
				for(int j=0;j<p.children.get(i).terminal.size();j++){
					companies[p.children.get(i).terminal.get(j)].hitcount+=1;
				}
				p=p.children.get(i);
			}else{
				p=root;
			}
			ai+=1;
		}
	}

}
