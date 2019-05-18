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
        System.out.println( "Hello World! PKU£¡"  );
        AVOSCloud.setDebugLogEnabled(true);
        AVObject testObject = new AVObject("TestObject");
        testObject.put("words","Hello World!");
        testObject.save();
    }
}
