package com.qualcomm.ftcrobotcontroller.opmodes;


import com.lasarobotics.ftc.drive.Mecanum;
import com.lasarobotics.ftc.controller.ButtonState;
import com.lasarobotics.ftc.controller.Controller;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * A Test Teleop
 */
public class MecanumPrototypeTeleop extends OpMode {
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    Controller one = new Controller();
    Controller two = new Controller();

    @Override
    public void start() {
        gamepad1.setJoystickDeadzone(.1F);
        gamepad2.setJoystickDeadzone(.1F);
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");
    }

    @Override
    public void loop() {
        //update gamepads to controllers with events
        one.update(gamepad1);
        two.update(gamepad2);

        Mecanum.Arcade(one.left_stick_y, one.left_stick_x, one.right_stick_x, leftFront, rightFront, leftBack, rightBack);
        if(two.a.state == ButtonState.PRESSED){
            //ButtonToggle a Controller two pressed sample...
            //Useful for toggles since button is only in the state once "per press" after which it moves to "Held" state
        }
    }

    @Override
    public void stop() {

    }
}
