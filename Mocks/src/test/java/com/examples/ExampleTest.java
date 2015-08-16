//package com.examples;
//import com.examples.ClassUnderTest;
//import com.examples.Collaborator;
//import org.easymock.EasyMockSupport;
//import org.easymock.Mock;
//import static org.easymock.EasyMock.*;
//
//import org.easymock.TestSubject;
//import org.junit.*;
//
//public class ExampleTest extends EasyMockSupport {
//    @Rule
//    public EasyMockRule rule = new EasyMockRule(this);
//
//    @TestSubject
//    private ClassTested classUnderTest = new ClassTested();
//
//    @Mock
//    private Collaborator mock;
//
//    @Test
//    public void removeNonExistingDocument() {
//        replayAll();
//        classUnderTest.removeDocument("Does not exist");
//    }
//
//    @Test
//    public void addDocument() {
//        mock.documentAdded("New Document");
//        replayAll();
//        classUnderTest.addDocument("New Document", "content");
//        verifyAll();
//    }
//
//    @Test
//    public void addAndChangeDocument() {
//        mock.documentAdded("Document");
//        mock.documentChanged("Document");
//        expectLastCall().times(3);
//        replayAll();
//        classUnderTest.addDocument("Document", "content");
//        classUnderTest.addDocument("Document", "content");
//        classUnderTest.addDocument("Document", "content");
//        classUnderTest.addDocument("Document", "content");
//        verifyAll();
//    }
//}