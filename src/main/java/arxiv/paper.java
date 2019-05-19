package arxiv ; 

/**

 * 
 * @author Sishuo Chen 
 *
 */
 

 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

 
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class paper  implements Comparable<paper>{
    String updated ;
    String published ; 
    String title ;
    String summary ;
    ArrayList<String> authors ; 
    String link ; 
    String pdflink ;
    Double score ; 
    ArrayList<String> categories ; 
    public void print() {
        System.out.println("updated: "+this.updated) ;
        System.out.println("published: " + this.published) ;
        System.out.println("title: " + this.title) ;
        System.out.print("authors: " ) ;
        for (String author : authors) 
            System.out.print(author+" ") ; 
        System.out.println("\nlink: " +link  ) ;
        System.out.println("pdflink: " +pdflink  ) ;
         System.out.print("categories: " ) ;
        for (String cat : categories) {
             System.out.print(cat+" ") ; 
        }
        System.out.println("\n************\n ") ;
    }
    public paper() {
    	authors =  new ArrayList<String>() ;
    	categories =  new ArrayList<String>() ;
    	score = 0.00 ; 
    }
    public String PrintString() {
    	String ret = "" ; 
    	ret += "发表时间：  " + this.published + "\n" ; 
    	ret += "更新时间：  " + this.updated + "\n" ; 
    	ret += "标题： " + this.title + "\n"  ; 
    	ret += "摘要： " + this.summary +  "\n" ; 
    	ret += "作者：" ;
    	for(String au:this.authors) {
    		ret += " " + au ; 
    	}
    	ret += "\n" ;
    	ret += "Arxiv原文链接：" +this.link +  "\n" ; 
    	for(String cat:this.categories) {
    		ret += " " + cat ; 
    	}
    	return ret ; 
    }
	@Override
	public int compareTo(paper arg0) {
		if(this.score < arg0.score) return -1 ; 
		if(this.score > arg0.score) return 1 ; 
		return 0;
	} 
}