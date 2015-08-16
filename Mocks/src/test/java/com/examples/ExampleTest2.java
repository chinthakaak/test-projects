package com.examples;

import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.*;

/**
 * Created by ka40215 on 6/17+/15.
 */
public class ExampleTest2 {
    private ClassUnderTest classUnderTest;

    private Collaborator mock;

    @Before
    public void setUP(){
        mock = createMock(Collaborator.class);

        classUnderTest = new ClassUnderTest();
        classUnderTest.setListener(mock);
    }

    @Test
    public void testRemoveNonExistingDocument(){
        replay(mock);
        classUnderTest.removeDocument("Does not exist");
        classUnderTest.documentRemoved();
        verify(mock);
    }
}
