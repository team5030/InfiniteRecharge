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

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class TurretSubsystem extends SubsystemBase {
  private final CANSparkMax turretMotor = new CANSparkMax(Constants.CAN.kTurretMotor, MotorType.kBrushless);
  private final CANSparkMax flyWheelMotor = new CANSparkMax(Constants.CAN.kFlyWheelMotor, MotorType.kBrushless);
  private final DoubleSolenoid hood = new DoubleSolenoid(Constants.CAN.kPCM,Constants.PCM.kChannel_0, Constants.PCM.kChannel_1);
  private final CANEncoder turretEncoder = turretMotor.getEncoder();

  /**
   * Creates a new shooter.
   */
  public TurretSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void rotateTurret(double zRotation) {
    turretMotor.set(zRotation);
  }

  public double getTurretPosition() {
    return turretEncoder.getPosition();
  }

  public double getTurretVelocity() {
    return turretEncoder.getVelocity();
  }

  public void setFlyWheelSpeed(double ySpeed) {
    flyWheelMotor.set(ySpeed);
  }

  public void setHoodHigh() {
    hood.set(Value.kForward);
  }

  public void setHoodLow() {
    hood.set(Value.kReverse);
  }
  public boolean isHoodHigh(){
    if(hood.get()==Value.kForward){
      return true;
    }else{
      return false;
    }
  }
}
