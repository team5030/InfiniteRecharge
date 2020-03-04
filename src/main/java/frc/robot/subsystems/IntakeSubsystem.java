/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final DoubleSolenoid intake = new DoubleSolenoid(Constants.CAN.kPCM, Constants.PCM.kIntakeForward, Constants.PCM.kIntakeReverse);
  private final TalonSRX leftIntakeMotor = new TalonSRX(Constants.CAN.kLeftIntakeMotor);
  private final TalonSRX rightIntakeMotor = new TalonSRX(Constants.CAN.kRightIntakeMotor);
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {
    leftIntakeMotor.setInverted(true);
    rightIntakeMotor.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void runIntake(double speed){
    leftIntakeMotor.set(ControlMode.PercentOutput,speed);
    rightIntakeMotor.set(ControlMode.PercentOutput,speed);
  }

  public boolean isIntakeDown(){
    if(intake.get()==Value.kForward){
      return true;
    }else{
      return false;
    }
  }

  public void setIntakeDown(){
    intake.set(Value.kForward);
  }

  public void setIntakeUp(){
    intake.set(Value.kReverse);
  }

}
