package arxiv;
 
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





/**

 * 
 * @author Sishuo Chen 
 *
 */
 


public class search {
    
   // public static Map<String, String> type_map = new HashMap<String, String>();
    
    /* sortBy can be "relevance", "lastUpdatedDate", "submittedDate" 
     sortOrder can be either "ascending" or "descending" 
     A sample query using these new parameters looks like:
     http://export.arxiv.org/api/query?search_query=ti:"electron thermal conductivity"&sortBy=lastUpdatedDate&sortOrder=ascending
     
     prefix method can be:
        prefix	explanation
        ti	Title
        au	Author
        abs	Abstract
        co	Comment
        jr	Journal Reference
        cat	Subject Category
        rn	Report Number
        id	Id (use id_list instead)
        all	All of the above
    */ 
    public static ArrayList <paper> GetPapers(String method,String query,String sortBy, String sortOrder,String max_results) throws Exception {
        // http://export.arxiv.org/api/query?search_query=ti:%22electron%20thermal%20conductivity%22&sortBy=lastUpdatedDate&sortOrder=ascending&max_results=1000"
        String url = "http://export.arxiv.org/api/query?search_query=" + method + ":" + query + "&sortBy="+sortBy+"&sortOrder="+sortOrder+"&max_results="+max_results;  
        Document document = Jsoup.connect(url).get();
		Elements entries = document.getElementsByTag("entry");
        ArrayList <paper> papers  = new ArrayList<paper>() ;
        
		for(Element entry:entries) {
            paper newpaper = new paper() ;
            newpaper.authors = new ArrayList<String>() ;
            newpaper.categories = new ArrayList<String>() ; 
            for (Element element:entry.children()){
                //  System.out.println(element.tagName()) ; 
               // Systemut.println(element.text()) ;
                switch(element.tagName()){
                    case "updated":
                        newpaper.updated = element.text() ;
                        break ;
                    case "published":
                        newpaper.published = element.text() ;
                        break;
                    case "title":
                        newpaper.title = element.text() ; 
                        break ;
                    case "author":    
                        //System.out.println(element.child(0).text())  ;
                        newpaper.authors.add(element.child(0).text()) ;
                        break ;
                    case "link":
                        if (element.attr("title").equals("doi")) 
                            break ;                        
                        if (element.attr("type").equals("text/html") ) {
                            newpaper.link = element.attr("href") ;
                        }
                        else 
                            newpaper.pdflink = element.attr("href") ;
                        break;
                    case "category":
                        newpaper.categories.add(element.attr("term")) ;
                    default:
                        //System.out.println("") ;
                        break ; 
                }
            
                // System.out.println(element.tag()+"\n") ;
            }
             //System.out.println("\n") ;
             papers.add(newpaper) ;
        }
        /*
        for (paper newpaper : papers) {
            newpaper.print() ; 
        }
        */
        return papers ; 
    }
    
    
    public static ArrayList<paper> FindMostSimilar(String title) throws Exception {   // caution : year: two digits 
        String url = "http://export.arxiv.org/api/query?search_query=all:" + title + "&sortBy=relevance&sortOrder=descending&max_results=11" ;
        ArrayList<paper> most_similar_papers = GetPapers("all",title,"relevance","descending","11") ;
        ArrayList<paper>  ret = new ArrayList<paper>() ;
        for (int i = 1 ; i < most_similar_papers.size() ; i++) {
            ret.add(most_similar_papers.get(i)) ;  
        }
        return ret ; 
    }
    
    public static ArrayList<paper> GetNewPapersByCat(String cat) throws Exception {
       // String url = "http://export.arxiv.org/api/query?search_query=cat:" + cat + "&sortBy=lastUpdatedDate&sortOrder=descending&max_results=100" ;
        return GetPapers("cat",cat,"lastUpdatedDate","descending","10") ;
    }
    
    public static ArrayList<paper> GetNewPapersByAu(String au) throws Exception {
        return GetPapers("au",au,"relevance","descending","100") ;
    }
    
	public static void main(String[] args) throws Exception {
		/*ArrayList<paper> newpapers = GetPapers("ti","cnn","lastUpdatedDate","ascending","10") ; 
        for (paper newpaper : newpapers) {
            newpaper.print() ;
        }
        System.out.println(newpapers.size()) ; 
        
        ArrayList<paper> papers = FindMostSimilar("Asymptotic Spectral Distribution of Crosscorrelation Matrix in Asynchronous CDMA") ;
        for (paper newpaper:papers) {
            newpaper.print() ;
        }
        */
        ArrayList<paper> papers  = GetNewPapersByAu("Kevin H. Knuth") ; 
        for (paper newpaper:papers) {
            newpaper.print() ;
        }
    }
}