import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.ConnectionFactory;
import java.io.File;

/**
 * Created by ka40215 on 7/13/15.
 */
public class SpringFirstTest extends CamelSpringTestSupport {



    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("test.xml");
    }

    @Test
    public void testFileMove() throws InterruptedException {
        template.sendBodyAndHeader("file:/data/data/inbox", "Hello", Exchange.FILE_NAME,"f.txt");
        Thread.sleep(1000);
        File target =new File("/data/data/outbox/f.txt");
        assertTrue("File not moved",target.exists());

        String content = context.getTypeConverter().convertTo(String.class,target);
        assertEquals("Content","Hello",content);
    }
}
