package com.qualcomm.ftcrobotcontroller.opmodes;


import com.lasarobotics.ftc.drive.Mecanum;
import com.lasarobotics.ftc.controller.Controller;
import com.lasarobotics.ftc.monkeyc.MonkeyC;
import com.lasarobotics.ftc.sensor.Gyroscope;
import com.lasarobotics.ftc.util.Timers;
import com.qualcomm.ftcrobotcontroller.MyApplication;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * A Test Teleop
 */
public class MonkeyCWrite extends OpMode {
    //basic FTC classes
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    GyroSensor hw_gyro;
    MonkeyC writer;
    //advanced FTC classes
    Controller one = new Controller();
    Controller two = new Controller();
    Gyroscope gyro;
    public void start() {
        gamepad1.setJoystickDeadzone(.1F);
        gamepad2.setJoystickDeadzone(.1F);
//        leftFront = hardwareMap.dcMotor.get("leftFront");
//        rightFront = hardwareMap.dcMotor.get("rightFront");
//        leftBack = hardwareMap.dcMotor.get("leftBack");
//        rightBack = hardwareMap.dcMotor.get("rightBack");
//        hw_gyro = hardwareMap.gyroSensor.get("hw_gyro");
//        gyro = new Gyroscope(hw_gyro);
        writer = new MonkeyC();
    }

    @Override
    public void loop() {
        //update gamepads to controllers with events
        one.update(gamepad1);
        two.update(gamepad2);
        writer.add(one, two);
        telemetry.addData("Status",writer.size() + " commands written");
        //Drive commands go here (must match when playing back)
    }

    @Override
    public void stop() {
        writer.write("test.txt", MyApplication.getAppContext());
    }
}
