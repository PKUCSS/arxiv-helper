package arxiv;
import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.*;

/**

 * 
 * @author Sishuo Chen 
 *
 */
 

public class User {
	AVUser avUser ; 
	boolean IfLogIn ;
	public User() {
		IfLogIn = false ; 
	}
	public String GetEmail() {
		return avUser.getEmail() ;
	}
	public boolean LogIn(String name,String password) {
		try {
			avUser = AVUser.logIn(name, password);
			this.IfLogIn = true ;
			System.out.println("登录成功！") ; 
		}
		catch (Exception e){
			e.printStackTrace(); 
			return false ;
		}
		return true ; 
	}
	public boolean SignUp(String email,String password) {
		try { 
			avUser = new AVUser();// 新建 AVUser 对象实例
            avUser.setUsername(email);// 系统用户名和邮箱相同
            avUser.setPassword(password);// 设置密码
            avUser.setEmail(email);// 设置邮箱
            avUser.signUp();
             
            return true ; 
		}
		catch (Exception e){
			e.printStackTrace(); 
			return false ;
		}
	}
	public Boolean SetName(String name)  {
		try {
			avUser.put("Name",name) ;
			AVUser.getCurrentUser().save() ;
			return true ; 
		}
		catch (Exception e){
			e.printStackTrace(); 
			return false ;
		}
	}
	
	public String GetCity() {
		return this.avUser.getString("City") ; 
	}
	public Boolean SetCity(String City)  {
		try {
			avUser.put("City",City) ;
			AVUser.getCurrentUser().save() ;
			return true ; 
		}
		catch (Exception e){
			e.printStackTrace(); 
			return false ;
		}
	}
	
	public ArrayList<String> GetLikedCats() {
		String rawstr = this.avUser.getString("cats") ; 
		if(rawstr == null ) return  new ArrayList<String>() ;    
		ArrayList<String> ret =  new ArrayList<String>() ;  
		for (String s: rawstr.split("#")) {
			if (s.equals("") == true) continue ; 
			ret.add(s) ;
		}
		return ret ; 
	}
	public void SetLiked(ArrayList<String> liked)  {
		String ret = "" ; 
		for(String str:liked) {
			ret += "#"+str ;
		}
		this.avUser.put("cats",ret);  
	}
	
	public String GetName() {
		return this.avUser.getString("Name") ; 
	}
	
	public String LikedPapers() {
		return this.avUser.getString("Liked") ; 
	}
	public String ReadPapers() {
		return this.avUser.getString("Read") ; 
	}
	
	public void add2Read(paper newpaper) throws AVException {
		String liked = this.ReadPapers() ;
		ArrayList<paper> Liked = this.GetReadPapers() ; 
		if(liked != null)
			for(paper np:Liked) {
				if (newpaper.title.equals(np.title)) {
					return  ; 
				}
			}                          // Avoid repetition
		
		liked += "@" ;
		liked += "#" + newpaper.updated + "#" + newpaper.published + "#" + newpaper.title + "#" + newpaper.summary ;
		liked += "#" ; 
		for (String au: newpaper.authors) {
			liked += "$" + au ;
		}
		liked += "#" + newpaper.link ; 
		liked += "#" + newpaper.pdflink ; 
		liked += "#" ; 
		for (String cat: newpaper.categories) {
			liked += "$" + cat ; 
		}
		liked += "@" ; 
		this.avUser.put("Read", liked);
		AVUser.getCurrentUser().save() ;    // remenber to save 
 	}
	
	public void add2Liked(paper newpaper) throws AVException {
		String liked = this.LikedPapers() ;
		System.out.println("************************") ; 
		ArrayList<paper> Liked = this.GetLikedPapers() ; 
		for(paper np:Liked) {
			if (newpaper.title.equals(np.title)) {
				return  ; 
			}
		}                          // Avoid repetition
		
		liked += "@" ;
		liked += "#" + newpaper.updated + "#" + newpaper.published + "#" + newpaper.title + "#" + newpaper.summary ;
		liked += "#" ; 
		for (String au: newpaper.authors) {
			liked += "$" + au ;
		}
		liked += "#" + newpaper.link ; 
		liked += "#" + newpaper.pdflink ; 
		liked += "#" ; 
		for (String cat: newpaper.categories) {
			liked += "$" + cat ; 
		}
		liked += "@" ; 
		this.avUser.put("Liked", liked);
		AVUser.getCurrentUser().save() ;    // remenber to save 
 	}
	public ArrayList<paper> GetLikedPapers() {
		String rawstr = this.LikedPapers() ; 
		if(rawstr == null) {
			rawstr = "" ; 
		}
		// System.out.println(rawstr) ; 
		ArrayList<paper> ret =  new ArrayList<paper>() ; 
		for(String paperstr : rawstr.split("@")) {
			System.out.println(paperstr) ; 
			paper newpaper = new paper() ; 
			String[] attrs = paperstr.split("#") ;
			if (attrs.length < 5 ) {
				continue ; 
			}
			System.out.println(attrs[0]) ; 
			if(attrs[0].equals("null") ) continue ;  
		    newpaper.updated = attrs[1] ; 
		    newpaper.published = attrs[2] ; 
		    newpaper.title = attrs[3] ; 
		    newpaper.summary = attrs[4] ; 
		    newpaper.link = attrs[6] ; 
		    newpaper.pdflink = attrs[7] ; 
		    for(String au:attrs[5].split("\\$")) {
		    	
		    	newpaper.authors.add(au) ;
		    }
		    for(String cat:attrs[8].split("\\$")) {
		    	newpaper.categories.add(cat) ; 
		    }
		    ret.add(newpaper) ; 
		}
		return ret ; 
	}
	
	public ArrayList<paper> GetReadPapers() {
		String rawstr = this.ReadPapers() ; 
		if(rawstr == null) {
			return null ; 
		}
		// System.out.println(rawstr) ; 
		ArrayList<paper> ret =  new ArrayList<paper>() ; 
		for(String paperstr : rawstr.split("@")) {
			System.out.println(paperstr) ; 
			paper newpaper = new paper() ; 
			String[] attrs = paperstr.split("#") ;
			if (attrs.length < 5 ) {
				continue ; 
			}
			System.out.println(attrs[0]) ; 
			if(attrs[0].equals("null") ) continue ;  
		    newpaper.updated = attrs[1] ; 
		    newpaper.published = attrs[2] ; 
		    newpaper.title = attrs[3] ; 
		    newpaper.summary = attrs[4] ; 
		    newpaper.link = attrs[6] ; 
		    newpaper.pdflink = attrs[7] ; 
		    for(String au:attrs[5].split("\\$")) {
		    	
		    	newpaper.authors.add(au) ;
		    }
		    for(String cat:attrs[8].split("\\$")) {
		    	newpaper.categories.add(cat) ; 
		    }
		    ret.add(newpaper) ; 
		}
		return ret ; 
	}
	
	public ArrayList<paper> GetRecommendPapers() throws Exception {
		if (IfLogIn == false) {
			return null ; 
		}
		ArrayList<paper> Source = new ArrayList<paper>() ; 
		ArrayList<paper> Read = this.GetReadPapers() ;  
		if(Read == null || Read.size() == 0 ) return null ; 
		ArrayList<String> cats =  this.GetLikedCats()  ;
		
		if(cats == null ) cats = new ArrayList<String>() ; 
		if(cats.size() == 0 ) cats.add(Read.get(0).categories.get(0)) ; 
		for(paper p:Read) {
			for(String cat:p.categories) {
				if(cats.contains(cat) == false) {
					cats.add(cat) ; 
				}
			}
		}
		if(cats.size() == 0 ) cats.add("cs.CV") ; 
		List<String> newcats = cats.subList(0, cats.size()) ; 
		if(cats.size() > 5) newcats = cats.subList(0, 5) ; 
		for(String cat:newcats) {
			System.out.println(cat); 
		}   
		for(String cat:newcats) {
			try{
				Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace(); 
				}
			for(paper p:search.GetNewPapersByCat(cat)) {
				Source.add(p) ;  
			}
		}
		return Recommender.GetRecommend(Source, Read) ; 
		
	}
	
	public  ArrayList<paper> GetRecentPapers() {
		ArrayList<paper> Read = this.GetReadPapers() ;
		ArrayList<paper> ret = new ArrayList<paper>() ; 
		int l = Read.size() ;
		int s = 0 ; 
		for( ;s < l-25 ; s++) ; 
		for (int i = s ; i < l ; i++ ) {
			ret.add(Read.get(i)) ; 
		}
		return ret; 
	}
	
	public void LogOut() {
		avUser.logOut();// 清除缓存用户对象
		IfLogIn = false ; 
		avUser = new AVUser() ;  
 	    AVUser currentUser = avUser.getCurrentUser();// 现在的 currentUser 是 n
	}
	
	public void requestPasswordReset(String email) {
		AVUser.requestPasswordReset(email);
	}
	
	public void ClearLiked() throws AVException {
		this.avUser.put("Liked", ""); 
		AVUser.getCurrentUser().save() ;
	}
	
	public static void main(String[] args) throws Exception {
		User user = new User() ; 
		AVOSCloud.initialize("m0rQBplH1SM5GAYFvt22VI0z-gzGzoHsz","MS8SRy9i4rsKkk0j8HtDJm6x","EAElMEaXzhmulzrx0ddcey0Q");
		// user.SignUp("arxivtest@126.com","123456")  ;
		// return ; 
  
		user.LogIn("arxivtest@126.com","123456") ;
	    //user.SetName("ss") ; 
	    //AVUser.getCurrentUser().save() ;
		/*
		paper newpaper = search.GetNewPapersByAu("Kevin H. Knuth").get(0) ; 
		
		for(paper np:search.GetNewPapersByAu("Kevin H. Knuth")) {
			user.add2Read(np);
 		}
		
		
		
		ArrayList<paper> sss = user.GetRecommendPapers() ;  
		for(paper np:sss) {
			np.print(); 
			System.out.println("7387e983789");    
		}  
		*/ 
		
	} 
}
