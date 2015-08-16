package com.examples;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.*;

/**
 * Created by ka40215 on 6/18/15.
 */
public class SupportTest {

    private Collaborator firstCollaborator;
    private Collaborator secondCollaborator;
    private ClassUnderTest classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new ClassUnderTest();
    }

    @Test
    public void addDocument() {
        // creation phase
        firstCollaborator = createMock(Collaborator.class);
        secondCollaborator = createMock(Collaborator.class);
        classUnderTest.setListener(firstCollaborator);
        classUnderTest.setListener(secondCollaborator);

        // recording phase
        firstCollaborator.documentAdded("New Document");
        secondCollaborator.documentAdded("New Document");
        replay(); // replay all mocks at once

        // test
        classUnderTest.addDocument("New Document", new byte[0]);
        verify(); // verify all mocks at once
    }
}
