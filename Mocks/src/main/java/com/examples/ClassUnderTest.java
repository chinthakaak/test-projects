package com.examples;

/**
 * Created by ka40215 on 6/17/15.
 */
public class ClassUnderTest {
    private Collaborator listener;
    private Collaborator listener2;
    // ...
    public void setListener(Collaborator listener) {
        this.listener = listener;
    }

    public void setListener2(Collaborator listener) {
        this.listener2 = listener;
    }
    public void addDocument(String title, byte[] document) {
        // ...
    }

    public void removeDocument(){

    }

    public void removeDocument(String document){
//        listener.documentAdded("rr");
//        listener.documentRemoved("");
//        removeDocument();
    }

    public void documentRemoved(){

    }
}
