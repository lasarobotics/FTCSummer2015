package com.qualcomm.ftcrobotcontroller.opmodes.lib;

/**
 * Created by Ehsan on 6/4/2015.
 */
public class Util {

    public static double checkGyroBounds(double gyro) {
        if (gyro < 0){
            return 360 - Math.abs(gyro);
        }
        return gyro;
    }
}
