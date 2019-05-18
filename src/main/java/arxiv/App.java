package arxiv;
import com.avos.avoscloud.*;

/**
 * Hello world!
 *
 */
public class App  
{
    public static void main( String[] args ) throws AVException
    {	
    	AVOSCloud.initialize("m0rQBplH1SM5GAYFvt22VI0z-gzGzoHsz","MS8SRy9i4rsKkk0j8HtDJm6x","EAElMEaXzhmulzrx0ddcey0Q");
        System.out.println( "Hello World! PKU！"  );
        AVOSCloud.setDebugLogEnabled(true);
        /*
        try {
            AVUser user = new AVUser();// 新建 AVUser 对象实例
            user.setUsername("SS");// 设置用户名
            user.setPassword("123456");// 设置密码
            user.setEmail("664558419@qq.com");// 设置邮箱
            user.signUp();
        } catch (AVException e) {
            // 失败的原因可能有多种，常见的是用户名已经存在。
            e.printStackTrace();
        }
        */ 
        
        AVUser avUser = AVUser.logIn("SS", "123456");
        avUser.put("age",25);
        avUser.getCurrentUser().save();
        
        System.out.println( avUser.getInt("age")) ; 
    }
}
