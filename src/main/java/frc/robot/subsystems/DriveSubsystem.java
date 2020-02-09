/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  // The motors on the left side of the drive.
  private final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(
      new CANSparkMax(Constants.CAN.kLeftDriveMotor_1, MotorType.kBrushless),
      new CANSparkMax(Constants.CAN.kLeftDriveMotor_2, MotorType.kBrushless));

  // The motors on the right side of the drive.
  private final SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(
      new CANSparkMax(Constants.CAN.kRightDriveMotor_1, MotorType.kBrushless),
      new CANSparkMax(Constants.CAN.kRightDriveMotor_2, MotorType.kBrushless));

  // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  // The left-side drive encoder
  private final CANEncoder m_leftEncoder = new CANSparkMax(Constants.CAN.kLeftDriveMotor_1, MotorType.kBrushless)
      .getEncoder();

  // The right-side drive encoder
  private final CANEncoder m_rightEncoder = new CANSparkMax(Constants.CAN.kLeftDriveMotor_1, MotorType.kBrushless)
      .getEncoder();

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(final double xSpeed, final double zRotation) {
    m_drive.arcadeDrive(xSpeed, zRotation);
  }

  public void tankDrive(final double leftSpeed, final double rightSpeed) {
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  public double getAveragePosition() {
    return (m_leftEncoder.getPosition() + m_rightEncoder.getPosition()) / 2.0;
  }

  public double getAverageVelocity() {
    return (m_leftEncoder.getVelocity() + m_rightEncoder.getVelocity()) / 2.0;
  }
}
