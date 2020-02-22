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
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;


public class DefaltDrive extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final XboxController m_driver;
  private double oldInput = 0;
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
    double zRotation = m_driver.getX(Hand.kLeft), input = m_driver.getTriggerAxis(Hand.kRight)-m_driver.getTriggerAxis(Hand.kLeft),
    DELTA_LIMIT=Constants.Drive.kDeltaMax, xSpeed = 0, capture_value=0;
    String mode=Constants.Drive.kRampNormal;

    //rate of change in joystick values.
    double delta = input - oldInput;

    //is joystick being moved too fast?
    if(delta >= DELTA_LIMIT) { 
	    mode=Constants.Drive.kRampUp; 
	    capture_value = input;
    }else if(delta <= -DELTA_LIMIT) { 
	    mode=Constants.Drive.kRampDown; 
	    capture_value = input;
    } 

    //output integration
    switch(mode){
	    case Constants.Drive.kRampUp: 
		  xSpeed += Constants.Drive.kRampRateUp;
		  if(xSpeed >= capture_value) { mode = Constants.Drive.kRampNormal; }
		    break;
		  case Constants.Drive.kRampDown:
		    xSpeed-= Constants.Drive.kRampRateDown;
		    if(xSpeed <= capture_value) { mode = Constants.Drive.kRampNormal; }
		    break;
	    case Constants.Drive.kRampNormal:
		    xSpeed = input;
		    break;
	    default: break;
    }
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
