import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

/**
 * Created by ka40215 on 7/13/15.
 */
//import org.apache.camel
public class FirstTest extends CamelTestSupport {
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception{
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:/data/data/inbox").to("file:/data/data/outbox");
            }
        };
    }

    @Override
    public void setUp() throws Exception {
        deleteDirectory("/data/data/inbox");
        deleteDirectory("/data/data/outbox");
        super.setUp();
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
