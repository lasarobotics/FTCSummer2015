package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Autonomous parallel thread test
 */
public class AutoThread extends Thread {
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    HardwareMap hardwareMap;
    //Empty Constructor
    public AutoThread(HardwareMap h) {
        hardwareMap = h;
    }

    //Here is where the autonomous-mode linear sequence of events occurs
    @Override
    public void run() {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");

        //Simulated action one
        doStuffMethod(1000);
        //Simulated action two
        doStuffMethod(2000);
    }

    public void doStuffMethod(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
