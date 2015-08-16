import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ka40215 on 7/26/15.
 */
public class ContentBasedRouter {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("content-based.xml");
    }
}
