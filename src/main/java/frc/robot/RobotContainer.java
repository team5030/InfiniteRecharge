/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.dirvecommands.*;
import frc.robot.commands.shootercommands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // Controllers
  XboxController m_driver = new XboxController(Constants.OI.kDriverControllerPort),
                 m_operator = new XboxController(Constants.OI.kDriverControllerPort);

  // Subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final TurretSubsystem m_turretContol = new TurretSubsystem();
  
  // Commands
  private final DefaltDrive m_defaltDrive = new DefaltDrive(m_robotDrive, m_driver);
  private final DefaultTurret m_defaltTurret = new DefaultTurret(m_turretContol,m_operator);
  private final SetHood m_setHood = new SetHood(m_turretContol);
  private final VisionTracking m_visionTracking = new VisionTracking(m_turretContol,m_operator);

  // Air Compressor
  Compressor m_compressor = new Compressor(Constants.CAN.kPCM);

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_robotDrive.setDefaultCommand(m_defaltDrive);
    m_turretContol.setDefaultCommand(m_defaltTurret);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    new JoystickButton(m_operator, Constants.XboxControllerMap.kA).whenPressed(m_setHood);
    new JoystickButton(m_operator, Constants.XboxControllerMap.kRB).whenHeld(m_visionTracking);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  // An ExampleCommand will run in autonomous
  // return m_autoCommand;
  // }
}
