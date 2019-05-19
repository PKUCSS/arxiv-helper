package arxiv;
import java.util.ArrayList;
import java.util.Collections;

import info.debatty.java.stringsimilarity.*;

/**

 * 
 * @author Sishuo Chen 
 *
 */
 

public class Recommender {
	public static ArrayList<paper> GetRecommend(ArrayList<paper> Source,ArrayList<paper> Read) {
		ArrayList<paper> ret = new ArrayList<paper>() ; 
		if(Read.size() > 100) {
			Read = (ArrayList<paper>) Read.subList(Read.size()-100, Read.size()) ; 
		}       // 取最近阅读的100篇作为样本
		for(paper np:Read) np.score = 0.00 ;
		JaroWinkler jw = new JaroWinkler(); 
		for(paper np:Source) np.print(); 
		for(paper np:Source) {
			for(paper op:Read) {
				if(np.summary == null) np.summary = "" ; 
				if(op.summary == null ) op.summary = ""  ;
				np.score += jw.similarity(np.summary,op.summary) ; 
			}
		}
		Collections.sort(Source) ; 
		for(int i = 0 ; i < 25 && i < Source.size(); i ++ ) {
			ret.add(Source.get(i)) ; 
		}
		return ret ; 
	}
	
	public static void main(String args[]) {
		JaroWinkler jw = new JaroWinkler();
        
        // substitution of s and t
        System.out.println(jw.similarity("Analogue computers use continuous properties of physical system for modeling. In the paper is described possibility of modeling by analogue quantum computers for some model of data analysis. It is analogue associative memory and a formal neural network. A particularity of the models is combination of continuous internal processes with discrete set of output states. The modeling of the system by classical analogue computers was offered long times ago, but now it is not very effectively in comparison with modern digital computers. The application of quantum analogue modelling looks quite possible for modern level of technology and it may be more effective than digital one, because number of element may be about Avogadro number (N=6.0E23).", "This paper presents a multiscale decomposition algorithm. Unlike standard wavelet transforms, the proposed operator is both linear and shift invariant. The central idea is to obtain shift invariance by averaging the aligned wavelet transform projections over all circular shifts of the signal. It is shown how the same transform can be obtained by a linear filter bank."));
        
        // substitution of s and n
        System.out.println(jw.similarity("My string", "My ntrisg"));
		
	}
	 
}
