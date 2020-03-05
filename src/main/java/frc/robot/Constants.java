/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class OI {
        public static final int kDriverControllerPort = 0,
                                kOperatorControllerPort = 1;
    }

    public final class CAN {
        public static final int kPDP = 0,
                                kFlyWheelMotor = 1,
                                kTurretMotor = 2,
                                kLeftRearDriveMotor = 3,
                                kLeftFrontDriveMotor = 4,
                                kPCM = 5,
                                kLeftIntakeMotor = 6,
                                kRightIntakeMotor = 7,
                                kRightRearDriveMotor = 8,
                                kRightFrontDriveMotor = 9,
                                kTowerMotor = 10,
                                kHooperMotor = 11;                        
    }

    public final class PCM {
        public static final int kIntakeReverse = 0,
                                kHoodReverse = 1,
                                kIntakeForward = 2,
                                kHoodForward = 3;
    }

    public final class XboxControllerMap {
        public static final int kA = 1,
                                kB = 2,
                                kX = 3,
                                kY = 4,
                                kLB = 5,
                                kRB = 6,
                                kVB = 7,
                                kMB = 5,
                                kL3 = 9,
                                kR3 = 10;
    }
    public final class GearBoxRatio {
        public static final double kDrive = 11.0/98.0;
        public static final double kTurret = 0;
    }
    public final class Drive{
        public static final double kSlewRate = 0.8;
    }
    public final class Misc {
        public static final double kMaxDriveSpeed = 0.5;
        public static final double kIntakespeed = 1;
    }
}