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
        System.out.println( "Hello World! PKU��"  );
        AVOSCloud.setDebugLogEnabled(true);
        /*
        try {
            AVUser user = new AVUser();// �½� AVUser ����ʵ��
            user.setUsername("SS");// �����û���
            user.setPassword("123456");// ��������
            user.setEmail("664558419@qq.com");// ��������
            user.signUp();
        } catch (AVException e) {
            // ʧ�ܵ�ԭ������ж��֣����������û����Ѿ����ڡ�
            e.printStackTrace();
        }
        */ 
        
        AVUser avUser = AVUser.logIn("SS", "123456");
        avUser.put("age",25);
        avUser.getCurrentUser().save();
        
        System.out.println( avUser.getInt("age")) ; 
    }
}
