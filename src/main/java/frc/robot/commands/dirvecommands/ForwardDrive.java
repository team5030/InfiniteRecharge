/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.dirvecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ForwardDrive extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final double m_rotations;
  /**
   * Creates a new ForwardDrive.
   */
  public ForwardDrive(DriveSubsystem driveSubsystem, double rotations) {
    m_driveSubsystem = driveSubsystem;
    m_rotations = rotations;
    addRequirements(m_driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveSubsystem.setEncoderPosition(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_driveSubsystem.getAveragePosition()<m_rotations*42){
      m_driveSubsystem.arcadeDrive(.5, 0);
    }
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
