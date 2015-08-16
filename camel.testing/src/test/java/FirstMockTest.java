import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import javax.jms.ConnectionFactory;

public class FirstMockTest extends CamelTestSupport {
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("jms:quote").to("mock:quote");
            }
        };
    }
    @Override
    public void setUp() throws Exception {
        CamelContext context = new DefaultCamelContext();

        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("vm://localhost");
        context.addComponent("jms",
                JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
//                from("file:/data/data/f.txt?noop=true")
//                        .to("jms:queue:test");

                from("jms:queue:test").to("mock:test");
            }
        });

        context.start();
//        Thread.sleep(1000);
//        context.stop();

//        super.setUp();
    }
    @Test
    public void testQuote() throws Exception {
        MockEndpoint quote = getMockEndpoint("mock:test");
        quote.expectedMessageCount(1);
//        template.sendBody("jms:quote", "Camel rocks");
        quote.assertIsSatisfied();
    }
}




















