/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Turret;



public class Shooter extends CommandBase {
  private Turret m_turret; 
  private XboxController m_operator;
  private NetworkTable m_limelight;
  private double tx;
  private double ty;
  public Shooter(Turret turret,XboxController operator,NetworkTable limelight) {
    m_turret = turret;
    m_operator = operator;
    m_limelight = limelight;
    addRequirements(turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    tx = m_limelight.getEntry("tx").getDouble(0);
    ty = m_limelight.getEntry("ty").getDouble(0);
    if(/*toggle botten*/){
      //speed math
      double ySpeed=Math.sqrt(Math.pow(tx, 2)+Math.pow(ty, 2));
      
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
