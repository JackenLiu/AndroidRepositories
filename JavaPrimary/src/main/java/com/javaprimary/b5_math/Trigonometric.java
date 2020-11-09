package com.javaprimary.b5_math;

public class Trigonometric {
    public static void main(String[] args) {
        System.out.printf("");
    }

    public static float getSinAngle(float longSide, float angleLong) {
        return Math.round(Math.asin(angleLong / longSide) / Math.PI * 180);
    }

    public static float getCosAngle(float longSide, float angleLong) {
        return Math.round(Math.acos(angleLong / longSide) / Math.PI * 180);
    }

    public static float getTwoPointsDistance(float x1, float y1, float x2, float y2) {
        return Math.round(Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2))));
    }

    public static float getSinLong(float angle, float longSide) {
        return Math.round(Math.sin(Math.toRadians(angle)) * longSide);
    }

    public static float getCosLong(float angle, float longSide) {
        return Math.round(Math.cos(Math.toRadians(angle)) * longSide);
    }

    public static float getTanNearLong(float angle, float opposize) {
        return Math.round(opposize / Math.tan(Math.toRadians(angle)));
    }
}
