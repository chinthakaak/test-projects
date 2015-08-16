package com.examples;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import static org.easymock.EasyMock.*;

/**
 * Created by ka40215 on 6/18/15.
 */
public class ExampleTest6 {
    @Rule
    public EasyMockRule easyMockRule=new EasyMockRule(this);

    @TestSubject
    private ClassUnderTest classUnderTest=new ClassUnderTest();

    private Collaborator mock;

    @Test
    public void testRem(){
        mock = createMockBuilder(Collaborator.class).addMockedMethod("documentRemoved").createMock();
        replay(mock);
        classUnderTest.removeDocument();

        verify();
    }
}
