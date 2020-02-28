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

import edu.wpi.first.wpilibj.SlewRateLimiter;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private final SlewRateLimiter speedSlewRate = new SlewRateLimiter(Constants.Drive.kSlewRate),
                                rotationSlewRate = new SlewRateLimiter(Constants.Drive.kSlewRate);
  //The drive motors
  private final CANSparkMax m_leftFrontMotor = new CANSparkMax(Constants.CAN.kLeftFrontDriveMotor, MotorType.kBrushless),
                            m_leftRearMotor = new CANSparkMax(Constants.CAN.kLeftRearDriveMotor, MotorType.kBrushless),
                            m_rightFrontMotor = new CANSparkMax(Constants.CAN.kRightFrontDriveMotor, MotorType.kBrushless),
                            m_rightRearMotor = new CANSparkMax(Constants.CAN.kRightRearDriveMotor, MotorType.kBrushless);
  //dirve motor groups
  private final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(m_leftFrontMotor,m_leftRearMotor),
                                     m_rightMotors = new SpeedControllerGroup(m_rightFrontMotor,m_rightRearMotor);
  
  // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  // The drive encoders
  private final CANEncoder m_leftFrontEncoder = m_leftFrontMotor.getEncoder(),
                           m_leftRearEncoder = m_leftRearMotor.getEncoder(),
                           m_rightFrontEncoder = m_rightFrontMotor.getEncoder(),
                           m_rightRearEncoder = m_rightRearMotor.getEncoder();

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    setEncodersConvertion(Constants.GearBoxRatio.kDrive);
    setEncodersPosition(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("m_leftFrontEncoder", m_leftFrontEncoder.getPosition());
  }

  public void arcadeDrive(final double xSpeed, final double zRotation) {
    m_drive.arcadeDrive(speedSlewRate.calculate(xSpeed), rotationSlewRate.calculate(zRotation));
  }
  //sets the convertion ratio for the drive encoders
  private void setEncodersConvertion(double factor){
    setEncoderConvertion(factor,m_leftFrontEncoder);
    setEncoderConvertion(factor,m_leftRearEncoder);
    setEncoderConvertion(factor, m_rightFrontEncoder);
    setEncoderConvertion(factor, m_rightRearEncoder);
  }
  private void setEncoderConvertion(double factor,CANEncoder encoder){
    encoder.setPositionConversionFactor(factor);
    encoder.setVelocityConversionFactor(factor);
  }

  public double getLeftFrontEncoder(){
    return m_leftFrontEncoder.getPosition();
  }
  public double getLeftRearEncoder(){
    return m_leftRearEncoder.getPosition();
  }
  public double getrightFrontEncoder(){
    return m_leftFrontEncoder.getPosition();
  }
  public double getrightRearEncoder(){
    return m_leftRearEncoder.getPosition();
  }

  public void setEncodersPosition(double position){
    m_leftFrontEncoder.setPosition(position);
    m_leftRearEncoder.setPosition(position);
    m_rightFrontEncoder.setPosition(position);
    m_rightRearEncoder.setPosition(position);
  }
}
