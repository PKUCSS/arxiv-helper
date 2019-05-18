package arxiv;
import java.util.ArrayList;

import com.avos.avoscloud.*;


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
	public String GetName() {
		return this.avUser.getString("Name") ; 
	}
	
	public String LikedPapers() {
		return this.avUser.getString("Liked") ; 
	}
	public void add2Liked(paper newpaper) throws AVException {
		String liked = this.LikedPapers() ;
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
		AVUser.getCurrentUser().save() ;
 	}
	public ArrayList<paper> GetLikedPapers() {
		String rawstr = this.LikedPapers() ; 
		System.out.println(rawstr) ; 
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
	public void LogOut() {
		avUser.logOut();// 清除缓存用户对象
		IfLogIn = false ; 
		avUser = new AVUser() ; 
	    AVUser currentUser = avUser.getCurrentUser();// 现在的 currentUser 是 n
	}
	
	public void requestPasswordReset(String email) {
		avUser.requestPasswordReset(email);
	}
	
	public static void main(String[] args) throws Exception {
		User user = new User() ; 
		AVOSCloud.initialize("m0rQBplH1SM5GAYFvt22VI0z-gzGzoHsz","MS8SRy9i4rsKkk0j8HtDJm6x","EAElMEaXzhmulzrx0ddcey0Q");
		// user.SignUp("1304476664@qq.com","123456")  ;
		user.LogIn("1304476664@qq.com","123456") ;
	    //user.SetName("ss") ;
	    //AVUser.getCurrentUser().save() ;
		paper newpaper = search.GetNewPapersByAu("Kevin H. Knuth").get(0) ; 
		user.add2Liked(newpaper); 
		
		for(paper np:user.GetLikedPapers()) {
			np.print(); 
		}
		for (String s:"$cs.LO$cs.DM$math.CO".split("\\$")) {
			System.out.println(s) ;
		}
	}
}
