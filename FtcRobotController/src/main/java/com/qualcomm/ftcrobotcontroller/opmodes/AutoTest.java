package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Autonomous parallel thread test
 */
public class AutoTest extends OpMode{
    AutoThread at;
    @Override
    public void start() {
        at = new AutoThread(hardwareMap, this);
        //Start the autonomous mode thread
        at.start();
    }

    @Override
    public void loop() {
        if (at.isAlive()) {
            at.update(hardwareMap);
        }
    }
    @Override
    public void stop() {
        if(at.isAlive()){
            at.interrupt();
        }
    }
}
