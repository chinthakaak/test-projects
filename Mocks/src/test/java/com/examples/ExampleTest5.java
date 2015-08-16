package com.examples;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

/**
 * Created by ka40215 on 6/18/15.
 */
public class ExampleTest5 {
    @Rule
    public EasyMockRule easyMockRule=new EasyMockRule(this);

    @TestSubject
    private ClassUnderTest classUnderTest=new ClassUnderTest();

    @Mock(name = "mock", fieldName = "listener2")
    private Collaborator mock;

    @Test
    public void testRem(){
        replay(mock);
        classUnderTest.removeDocument();
        verify();
    }
}
