package com.examples;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;

/**
 * Created by ka40215 on 6/18/15.
 */
@RunWith(EasyMockRunner.class)
public class ExampleTest3 {
    @TestSubject
    private ClassUnderTest classUnderTest=new ClassUnderTest();

    @Mock
    private Collaborator mock;

    @Test
    public void testRem(){
        classUnderTest.setListener(mock);
        replay(mock);
        classUnderTest.removeDocument();
    }
}
