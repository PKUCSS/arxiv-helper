package arxiv ; 

 
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

public class paper {
    String updated ;
    String published ; 
    String title ;
    String summary ;
    ArrayList<String> authors ; 
    String link ; 
    String pdflink ;
   
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
    }
}