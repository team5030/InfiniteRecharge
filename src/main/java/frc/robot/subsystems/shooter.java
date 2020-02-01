/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shooter extends SubsystemBase {
  private CANSparkMax turretMotor;
  private CANSparkMax shooterMotor;
  private Solenoid hoodOpen;
  private Solenoid hoodClosed;
  private NetworkTable table;
  private NetworkTableEntry tx;
  private NetworkTableEntry ty;
  private NetworkTableEntry ta;
  private NetworkTableEntry camMode;
  /**
   * Creates a new shooter.
   */
  public shooter() {
    turretMotor = new CANSparkMax(Constants.turretMotorid,MotorType.kBrushless);
    shooterMotor = new CANSparkMax(Constants.shooterMotorid,MotorType.kBrushless);
    hoodOpen = new Solenoid(Constants.pcmid,Constants.hoodControlid_1);
    hoodClosed = new Solenoid(Constants.pcmid,Constants.hoodControlid_2);
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    camMode = table.getEntry("camMode");
    camMode.setBoolean(false);

  

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void switchVisionMode(){
    if(camMode.getBoolean(true)==true)
      camMode.setBoolean(false);
    else
      camMode.setBoolean(false);

  }
}
