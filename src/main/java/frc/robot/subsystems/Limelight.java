/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  private final NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
  private int m_mode = 0;
  /**
   * Creates a new Limelight.
   */
  public Limelight() {
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Limelight tv", limelight.getEntry("tv").getDouble(0));
    SmartDashboard.putNumber("Limelight tx", limelight.getEntry("tx").getDouble(0));
    SmartDashboard.putNumber("Limelight ty", limelight.getEntry("ty").getDouble(0));
    SmartDashboard.putNumber("Limelight ta", limelight.getEntry("ta").getDouble(0));
    SmartDashboard.putNumber("Limelight ts", limelight.getEntry("ts").getDouble(0));
    m_mode = (int) limelight.getEntry("camMode").getNumber(0);
  }

  public double getTv(){
    return limelight.getEntry("tv").getDouble(0);
  }
  public double getTx(){
    return limelight.getEntry("tx").getDouble(0);
  }
  public double getTy(){
    return limelight.getEntry("ty").getDouble(0);
  }
  public double getTa(){
    return limelight.getEntry("ta").getDouble(0);
  }
  public double getTs(){
    return limelight.getEntry("ts").getDouble(0);
  }

  public void setCamMode(boolean mode){
    if(mode){
      m_mode = 1;
    }else{
      m_mode = 0;
    }
    limelight.getEntry("camMode").setNumber(m_mode);
    SmartDashboard.putBoolean("Limelight On", mode);
  }
}
