package com.springinaction.consumer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.springinaction.provider.*;

/**
 * Created by ka40215 on 6/21/15.
 */
public class HelloConsumer implements ActionListener {
    private final HelloService service;
    private final Timer timer;

    public HelloConsumer(HelloService service) {
        super();

        this.service = service;

        timer = new Timer(5000, this);
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
