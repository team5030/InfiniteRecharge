/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class Drive extends CommandBase {
  private final DriveTrain m_driveTrain;
  private final XboxController m_driver;
  
  public Drive(DriveTrain driveTrain, XboxController driver) {
    m_driveTrain = driveTrain;
    m_driver = driver;
    addRequirements(m_driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double zRotation = m_driver.getX(Hand.kLeft);
    double rightTrigger = m_driver.getTriggerAxis(Hand.kRight);
    double leftTrigger = m_driver.getTriggerAxis(Hand.kLeft);

    double xSpeed = rightTrigger-leftTrigger;

    m_driveTrain.arcadeDrive(xSpeed, zRotation);
    /*
     *double leftSpeed = -m_driver.getY(Hand.kLeft);
     *double rightSpeed = -m_driver.getY(Hand.kRight);
     *m_driveTrain.tankDrive(leftSpeed, rightSpeed);
     */

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
