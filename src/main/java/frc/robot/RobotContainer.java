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
import frc.robot.commands.intakecommands.*;
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
                 m_operator = new XboxController(Constants.OI.kOperatorControllerPort);

  // Subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final TurretSubsystem m_turretSubsystem = new TurretSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  
  // Drive Commands
  private final DefaltDrive m_defaltDrive = new DefaltDrive(m_robotDrive, m_driver);
  private final DefaultTurret m_defaltTurret = new DefaultTurret(m_turretSubsystem,m_operator);
  
  // Shooter Commands
  private final SetHood m_setHood = new SetHood(m_turretSubsystem);
  private final VisionTracking m_visionTracking = new VisionTracking(m_turretSubsystem,m_operator);
  private final Shooter m_Shooter = new Shooter(m_turretSubsystem);
  
  // Intake Commands
  private final RunIntakeOut m_runIntakeOut = new RunIntakeOut(m_intake);
  private final RunIntakeIn m_runIntakeIn = new RunIntakeIn(m_intake);
  private final SetIntake m_setIntake = new SetIntake(m_intake);
  private final Kicker m_kicker = new Kicker(m_intake);

  // Air Compressor
  private final Compressor m_compressor = new Compressor(Constants.CAN.kPCM);

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // Default Commands
    m_robotDrive.setDefaultCommand(m_defaltDrive);
    m_turretSubsystem.setDefaultCommand(m_defaltTurret);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    // Operator Button Bindings
    new JoystickButton(m_operator, Constants.XboxControllerMap.kA).whenPressed(m_setHood);
    new JoystickButton(m_operator, Constants.XboxControllerMap.kLB).whenHeld(m_kicker);
    new JoystickButton(m_operator, Constants.XboxControllerMap.kRB).whenHeld(m_Shooter);

    // Driver Button Bindings
    new JoystickButton(m_driver, Constants.XboxControllerMap.kA).whenPressed(m_runIntakeIn);
    new JoystickButton(m_driver, Constants.XboxControllerMap.kB).whenPressed(m_runIntakeOut);
    new JoystickButton(m_driver, Constants.XboxControllerMap.kRB).whenPressed(m_setIntake);
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
