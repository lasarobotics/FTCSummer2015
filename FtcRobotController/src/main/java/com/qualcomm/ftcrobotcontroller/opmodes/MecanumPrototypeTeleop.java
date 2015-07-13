package com.qualcomm.ftcrobotcontroller.opmodes;


import com.lasarobotics.ftc.drive.Mecanum;
import com.lasarobotics.ftc.controller.Controller;
import com.lasarobotics.ftc.sensor.Gyroscope;
import com.lasarobotics.ftc.controller.ButtonState;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * A Test Teleop
 */
public class MecanumPrototypeTeleop extends OpMode {
    //basic FTC classes
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    GyroSensor hw_gyro;

    //advanced FTC classes
    Controller one = new Controller();
    Controller two = new Controller();
    Gyroscope gyro;

    @Override
    public void start() {
        gamepad1.setJoystickDeadzone(.1F);
        gamepad2.setJoystickDeadzone(.1F);
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        hw_gyro = hardwareMap.gyroSensor.get("hw_gyro");
        gyro = new Gyroscope(hw_gyro);
    }

    @Override
    public void loop() {
        //update gamepads to controllers with events
        one.update(gamepad1);
        two.update(gamepad2);
        gyro.update(hw_gyro);

        Mecanum.Arcade(one.left_stick_y, one.left_stick_x, one.right_stick_x, leftFront, rightFront, leftBack, rightBack);
        if(two.a == ButtonState.PRESSED){
            //ButtonToggle a Controller two pressed sample...
            //Useful for toggles since button is only in the state once "per press" after which it moves to "Held" state
        }
        if (gyro.getRotation() >= 90)
        {
            //something like this can be used to tell if the robot rotated 90 degrees clockwise
        }
    }

    @Override
    public void stop() {

    }
}
