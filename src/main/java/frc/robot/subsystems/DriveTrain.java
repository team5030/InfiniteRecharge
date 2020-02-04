/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private CANSparkMax leftMotor_1;
  private CANSparkMax leftMotor_2;
  private CANSparkMax rightMotor_1;
  private CANSparkMax rightMotor_2;
  private SpeedControllerGroup m_left;
  private SpeedControllerGroup m_right;
  private DifferentialDrive m_drive;
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    leftMotor_1 = new CANSparkMax(Constants.leftMotorid_1, MotorType.kBrushless);
    leftMotor_2 = new CANSparkMax(Constants.leftMotorid_2, MotorType.kBrushless);
    rightMotor_1 = new CANSparkMax(Constants.righMotorid_1, MotorType.kBrushless);
    rightMotor_2 = new CANSparkMax(Constants.rightMotorid_2, MotorType.kBrushless);
    m_left = new SpeedControllerGroup(leftMotor_1, leftMotor_2);
    m_right = new SpeedControllerGroup(rightMotor_1, rightMotor_2);
    m_drive = new DifferentialDrive(m_left, m_right);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
  public void arcadeDrive(double xSpeed, double zRotation){
    m_drive.arcadeDrive(xSpeed, zRotation);
  }
  public void tankDrive(double leftSpeed, double rightSpeed){
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }
  public void stop() {
    m_drive.stopMotor();
  }
}
