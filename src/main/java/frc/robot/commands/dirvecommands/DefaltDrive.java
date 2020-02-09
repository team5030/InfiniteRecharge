/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.dirvecommands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;


public class DefaltDrive extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final XboxController m_driver;
  
  public DefaltDrive(DriveSubsystem driveSubsystem, XboxController driver) {
    m_driveSubsystem = driveSubsystem;
    m_driver = driver;
    addRequirements(m_driveSubsystem);

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

    m_driveSubsystem.arcadeDrive(xSpeed, zRotation);
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
