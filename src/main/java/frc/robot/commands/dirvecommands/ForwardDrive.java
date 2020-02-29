/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.dirvecommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ForwardDrive extends InstantCommand {
  private final DriveSubsystem m_driveSubsystem;
  private final double m_rotations;
  /**
   * Creates a new ForwardDrive.
   */
  public ForwardDrive(DriveSubsystem driveSubsystem, double rotations) {
    m_driveSubsystem = driveSubsystem;
    m_rotations = rotations;
    addRequirements(m_driveSubsystem);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveSubsystem.setEncodersPosition(0);
    if(m_rotations > 0){
      while(m_driveSubsystem.getLeftFrontEncoder() < m_rotations){
        m_driveSubsystem.arcadeDrive(.5, 0);
      }
    }else{
      while(m_driveSubsystem.getLeftFrontEncoder() > m_rotations){
        m_driveSubsystem.arcadeDrive(-.5, 0);
      }
    }
  }
}
