package com.qualcomm.ftcrobotcontroller.opmodes.lib;

/**
 *  Mathematical and Precision Utilities
 */
public class Util {
    /**
     * Double equality epsilon
     */
    private final static double EPSILON = 0.000001;

    /**
     * Gives a "deadzone" where any value less
     * than this would return zero.
     *
     * @param deadband Maximum value that returns zero
     * @param value Value to test
     * @return Deadbanded value
     */
    public static double deadband(double deadband, double value)
    {
        if (Math.abs(value) > deadband) { return value; }
        return 0;
    }

    /**
     * Returns if two double values are equal to within epsilon.
     * @param a First value
     * @param b Second value
     * @return True if the values are equal, false otherwise
     */
    public static Boolean equal(double a, double b)
    {
        return (Math.abs(a - b) < EPSILON);
    }

    /**
     * Returns if two double values are equal to within a distance.
     * @param a First value
     * @param b Second value
     * @param distance Maximum distance between a and b
     * @return True if the values are equal ot within distance, false otherwise
     */
    public static Boolean equal(double a, double b, double distance)
    {
        return (Math.abs(a - b) < distance);
    }

    /**
     * Ignores values equal to the fail value (normally zero).
     * @param value Current value
     * @param lastvalue Previous value
     * @param fail Filter this value, normally zero
     * @return Filtered value
     */
    public static double filter(double value, double lastvalue, double fail)
    {
        return (value == fail) ? lastvalue : value;
    }

    /**
     * Forces a numerical value to be between a min
     * and a max
     *
     * @param min If less than min, returns min
     * @param max If greater than max, returns max
     * @param value Value to test
     * @return Coerced value
     */
    public static double coerce(double min, double max, double value) {
        return (value > max) ? max : (value < min) ? min : value;
    }

    /**
     * Normalize Gyroscope bounds to within 0 and 360
     * @param gyro The current Gyroscope value
     * @return The normalized Gyroscope value, between 0 and 360.
     */
    public static double normalizeGyro(double gyro) {
        if (gyro < 0){
            return (360 + gyro) % 360;
        }
        return gyro % 360;
    }
}
