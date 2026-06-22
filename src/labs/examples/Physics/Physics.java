package labs.example.Physics;

import java.lang.Math;

public class Physics {
    
    final static double GRAVITY = 9.81;

    public double getDistance(double v, double t){
        double x = (v * t); 
        return x;
    }; //distanc calculator
    public double getVelocity(double x, double t){
        double v = (x / t); 
        return v;
    }; //velocit calculator
    public double getWork(double f, double d){
        double w = (f * d); 
        return w;
    }; //work time calculator
    public double getMomentum(double m, double v){
        double p = (m * v); 
        return p;
    }; //momentum calculator
    public double getForce(double m, double a){
        double f = (m * a); 
        return f;
    }; //force calculator
    public double getAngle(double x, double y){
        double theta = Math.atan2(x,y);
        double thetaAngle = Math.toDegrees(theta);
        return thetaAngle;
    }; //angle calculator
    public double getPotentialEnergy(double m, double h){
        double pe = (m * GRAVITY * h);
        return pe;
    }; //potential energy calculator
    public double getKineticEnergy(double m, double v){
        double ke = ((1/2)*m*(v*v));
        return ke;
    };
    public void logValidAngleInfo(double degrees){
        System.out.println("logging the angle" + degrees + "degrees. This is a valid 3-4-5 right triangle.");
    };
    public void logInvalidAngleInfo(double degrees){
        System.out.println("logging the angle" + degrees + "degrees. This is not a right angle.");
    };
    public double getTimeFromSunToEarthInHours(){
        double lightSpeedMPH = getLightSpeedinMPH();
        double distanceSunToEarth = 92955807.3;
        double time = distanceSunToEarth / lightSpeedMPH;
        return time;
    }
    public double getLightSpeedinMPH(){
        double lightSpeed = 186282;
        double lightSpeedMPH = lightSpeed * 3600;
        return lightSpeedMPH;
    }
}