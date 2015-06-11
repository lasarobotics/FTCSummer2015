package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Ehsan on 6/9/2015.
 */
public class AutoTest extends OpMode{
    Thread at;
    @Override
    public void start() {
        at = new AutoThread(hardwareMap);
        //Start the autonomous mode thread
        at.start();
    }

    @Override
    public void loop() {}
    @Override
    public void stop() {
        if(at.isAlive()){
            at.interrupt();
        }
    }
}
