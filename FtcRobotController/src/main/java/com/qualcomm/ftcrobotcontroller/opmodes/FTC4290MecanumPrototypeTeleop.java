package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.lib.Drive;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Ehsan on 6/4/2015.
 */
public class FTC4290MecanumPrototypeTeleop extends OpMode {
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    @Override
    public void start() {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");
    }

    @Override
    public void loop() {
        Drive.mecanumArcade(gamepad1.left_stick_y,gamepad1.left_stick_x,gamepad1.right_stick_x,leftFront,rightFront,leftBack,rightBack);
    }

    @Override
    public void stop() {

    }
}
