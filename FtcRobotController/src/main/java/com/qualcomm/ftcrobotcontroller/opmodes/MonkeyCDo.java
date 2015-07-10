package com.qualcomm.ftcrobotcontroller.opmodes;

import android.util.Log;

import com.lasarobotics.ftc.controller.Controller;
import com.lasarobotics.ftc.monkeyc.MonkeyData;
import com.lasarobotics.ftc.monkeyc.MonkeyDo;
import com.lasarobotics.ftc.sensor.Gyroscope;
import com.qualcomm.ftcrobotcontroller.MyApplication;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by Ehsan on 7/9/2015.
 */
public class MonkeyCDo extends OpMode {
    //basic FTC classes
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    GyroSensor hw_gyro;
    MonkeyDo reader;
    //advanced FTC classes
    Controller one = new Controller();
    Controller two = new Controller();
    Gyroscope gyro;

    @Override
    public void start() {
        gamepad1.setJoystickDeadzone(.1F);
        gamepad2.setJoystickDeadzone(.1F);
//        leftFront = hardwareMap.dcMotor.get("leftFront");
//        rightFront = hardwareMap.dcMotor.get("rightFront");
//        leftBack = hardwareMap.dcMotor.get("leftBack");
//        rightBack = hardwareMap.dcMotor.get("rightBack");
//        hw_gyro = hardwareMap.gyroSensor.get("hw_gyro");
//        gyro = new Gyroscope(hw_gyro);
        reader = new MonkeyDo("test.txt",MyApplication.getAppContext());
    }

    @Override
    public void loop() {
        MonkeyData m = reader.getNextCommand();

        one = m.updateControllerOne(one);
        two = m.updateControllerTwo(two);

        if (m.hasUpdate())
        {
            Log.d("debug", "Monkey Time: " + reader.t.getClockValue("global") + " Command Time: " + m.getTime());
        }
    }

    @Override
    public void stop() {
    }
}