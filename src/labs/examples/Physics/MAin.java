package labs.example.Physics;

import java.lang.Math;

@SuppressWarnings("unused") //meant to fix a weird conflict
public class MAin {
    public static void main(String[] args) throws Exception{
        Physics maths = new Physics();

        double distance1 = 5;
        double distance2 = 6;

        maths.getDistance(distance1, distance2);
        
        maths.getVelocity(19, 1);
        
        maths.getMomentum(5, 31);
        
        maths.getForce(44, 46);
        
        maths.getWork(80, 17);
        
        maths.getKineticEnergy(10, 500);
        
        maths.getPotentialEnergy(67, 3);
        
        maths.getAngle(14, 13);
        
        if (maths.getAngle(4, 3) > 37 && maths.getAngle(3, 4) < 36.87){
            maths.logInvalidAngleInfo(maths.getAngle(4, 3));
        }
        
        else {
            maths.logValidAngleInfo(maths.getAngle(4, 3));
        }
        
        if (maths.getDistance(maths.getTimeFromSunToEarthInHours(), maths.getLightSpeedinMPH()) > 92955807.3) {
            System.out.println("The distance from the sun to the earth is greater than 92955807.3 miles.");
        } //gets the distance
        else {
            System.out.println("The distance from the sun to the earth is less than 92955807.3 miles.");
        } //gets the distance
    }
}