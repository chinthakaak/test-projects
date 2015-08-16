package com.springinaction.dm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ka40215 on 6/21/15.
 */
public class HelloConsumer implements ActionListener {
    private final HelloService service;
    private final Timer timer;

    public HelloConsumer(HelloService service) {
        super();

        this.service = service;

        timer = new Timer(1000, this);
    }

    public void startTimer(){
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }
    public void actionPerformed(ActionEvent e) {
        service.hello();
    }
}
