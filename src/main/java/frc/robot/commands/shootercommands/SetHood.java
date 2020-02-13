/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shootercommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.TurretSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class SetHood extends InstantCommand {
  private final TurretSubsystem m_TurretSubsystem;

  /**
   * Creates a new SetHoodLow.
   */
  public SetHood(TurretSubsystem turretSubsystem) {
    m_TurretSubsystem = turretSubsystem;
    addRequirements(m_TurretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(m_TurretSubsystem.isHoodHigh()){
      m_TurretSubsystem.setHoodLow();
    }else{
      m_TurretSubsystem.setHoodHigh();
    }
  }
}
