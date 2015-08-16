package com.examples;

import org.easymock.EasyMock;
import org.junit.Test;

public class PartialMockTests
{
    class PartialMock
    {
        void foo()
        {
            // Code inside foo() will not be invoked while testing
            System.out.println("foo");
        }

        void boo()
        {
            // Code inside boo should be invoked
            System.out.println("boo");
            foo();
        }
    }

    @Test
    public void testPartialMock()
    {
        PartialMock partialMock = EasyMock
                .createMockBuilder(PartialMock.class) //create builder first
                .addMockedMethod("foo") // tell EasyMock to mock foo() method
                .createMock();          // create the partial mock object

        // tell EasyMock to expect call to mocked foo()
        partialMock.foo();
        EasyMock.expectLastCall().once();
        EasyMock.replay(partialMock);

        partialMock.boo(); // call boo() (not mocked)

        EasyMock.verify(partialMock);
    }
}
