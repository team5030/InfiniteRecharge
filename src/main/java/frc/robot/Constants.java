/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //CAN ids
    public static final int pdpid = 0;
    public static final int pcmid = 1;
    public static final int leftMotorid_2 = 2;
    public static final int righMotorid_1 = 3;
    public static final int rightMotorid_2 = 4;
    public static final int leftMotorid_1 = 5;
    public static final int turretMotorid = 6;
    public static final int shooterMotorid = 7;
    
    //Controller ports
    public static final int driverPortid = 0;
    public static final int operatorPortid = 1;

    //Solenoid control port 
    public static final int hoodHighid = 1;
    public static final int hoodLowid = 2;

    //Math constans
    public static final int rotationPerDegree = 1;
}
