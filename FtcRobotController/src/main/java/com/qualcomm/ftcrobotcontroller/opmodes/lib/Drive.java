package com.qualcomm.ftcrobotcontroller.opmodes.lib;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Ehsan on 6/4/2015.
 */
public class Drive {
    public static void tank(DcMotor left, DcMotor right, double leftValue,double rightValue ){
        left.setPower((leftValue/127)*100);
        right.setPower((rightValue/127)*100);
    }
    public static void mecanumArcade (double y,double x, double c,DcMotor leftFront,DcMotor rightFront,DcMotor leftBack, DcMotor rightBack){
        double leftFrontVal = y + x + c;
        double rightFrontVal = y - x - c;
        double leftBackVal  = y - x + c;
        double rightBackVal  = y + x - c;
        leftFront.setPower(leftFrontVal*100);
        rightFront.setPower(rightFrontVal*100);
        leftBack.setPower(leftBackVal*100);
        rightBack.setPower(rightBackVal*100);
    }
    public static void mecanumArcadeFieldOriented(double y,double x, double c, double gyroheading,DcMotor leftFront,DcMotor rightFront,DcMotor leftBack, DcMotor rightBack){
        double cosA = Math.cos(Math.toRadians(Util.checkGyroBounds(gyroheading)));
        double sinA = Math.sin(Math.toRadians(Util.checkGyroBounds(gyroheading)));
        double xOut = x * cosA - y * sinA;
        double yOut = x * sinA + y * cosA;
        mecanumArcade(yOut,xOut,c,leftFront,rightFront,leftBack,rightBack);
    }
}
