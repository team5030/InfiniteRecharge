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

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Turret extends SubsystemBase {
  private CANSparkMax turretMotor;
  private CANSparkMax shooterMotor;
  private Solenoid hoodHigh;
  private Solenoid hoodLow;


  /**
   * Creates a new shooter.
   */
  public Turret() {
    turretMotor = new CANSparkMax(Constants.turretMotorid,MotorType.kBrushless);
    shooterMotor = new CANSparkMax(Constants.shooterMotorid,MotorType.kBrushless);
    hoodHigh = new Solenoid(Constants.pcmid,Constants.hoodHighid);
    hoodLow = new Solenoid(Constants.pcmid,Constants.hoodLowid); 

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setFlyWheelSpeed(double ySpeed){
    shooterMotor.set(ySpeed);
  }
  public void rotateTurret(double degree){
    CANEncoder encoder = turretMotor.getEncoder();
    encoder.setPosition(0);
    double initEncoder = encoder.getPosition();
     
  }
  public void setHoodHigh(boolean ishigh){
    if(ishigh==true){
      hoodLow.set(false);
      hoodHigh.set(true);
    }
    else{
      hoodHigh.set(false);
      hoodLow.set(true);
    }

  }
}
