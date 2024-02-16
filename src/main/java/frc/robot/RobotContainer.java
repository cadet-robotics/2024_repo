// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.climber.ClimberSubsystem;
import frc.robot.subsystems.drive.swerve.DriveSubsystem;
import frc.robot.subsystems.drive.swerve.SwerveDriveCommand;
import frc.robot.subsystems.intake.IntakeCommand;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.launcherElevation.LauncherElevationSubsystem;
import frc.robot.subsystems.launcherFiring.LauncherFiringSubsystem;
import frc.robot.subsystems.limitSwitchStateMonitor.SensorStateMonitorSubsystem;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
    private final DriveSubsystem drive;
    private final IntakeSubsystem intake;
    private final LauncherFiringSubsystem launcher;
    private final LauncherElevationSubsystem elevation;
    private final ClimberSubsystem climber;
    private final SensorStateMonitorSubsystem sensorStateMonitor;
    
    // Replace with CommandPS4Controller or CommandJoystick if needed
    public static final CommandPS4Controller m_driverController =
            new CommandPS4Controller(OperatorConstants.kDriverControllerPort);

    
    public static final CommandPS4Controller m_coDriverController =
            new CommandPS4Controller(OperatorConstants.kCoDriverControllerPort);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {
        // create subsystems
        drive = new DriveSubsystem();
        sensorStateMonitor = new SensorStateMonitorSubsystem();
        intake = new IntakeSubsystem(sensorStateMonitor);
        climber = new ClimberSubsystem(sensorStateMonitor);
        elevation = new LauncherElevationSubsystem(sensorStateMonitor);
        launcher = new LauncherFiringSubsystem(sensorStateMonitor, intake);

        // Configure the trigger bindings
        configureBindings();

        // init cam server
        CameraServer.startAutomaticCapture();
    }

    /**
     * Use this method to define your trigger->command mappings. Triggers can be created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
     * predicate, or via the named factories in
     * {@link edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
     * {@link CommandXboxController
     * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller PS4} controllers or
     * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight joysticks}.
     */
    private void configureBindings()
    {
        // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
       //new Trigger(m_exampleSubsystem::exampleCondition)
         //       .onTrue(new ExampleCommand(m_exampleSubsystem));

        // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
        // cancelling on release.
       // m_driverController.button(1).whileTrue(m_exampleSubsystem.exampleMethodCommand());
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An example command will be run in autonomous
        return Autos.exampleAuto(m_exampleSubsystem);
    }
}
