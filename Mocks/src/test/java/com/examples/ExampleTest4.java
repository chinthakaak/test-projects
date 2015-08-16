package com.examples;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;

/**
 * Created by ka40215 on 6/18/15.
 */
public class ExampleTest4 {
    @Rule
    public EasyMockRule easyMockRule=new EasyMockRule(this);

    @TestSubject
    private ClassUnderTest classUnderTest=new ClassUnderTest();

    @Mock
    private Collaborator mock;

    @Test
    public void testRem(){
        replay(mock);
        classUnderTest.removeDocument();
    }
}
