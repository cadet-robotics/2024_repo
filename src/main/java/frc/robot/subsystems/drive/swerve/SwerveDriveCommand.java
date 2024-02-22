// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive.swerve;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.utilities.Utilities;

public class SwerveDriveCommand extends Command
{
    DriveSubsystem m_drive;

    /** Creates a new DriveWithGampad. */
    public SwerveDriveCommand(DriveSubsystem drive)
    {
        // Use addRequirements() here to declare subsystem dependencies.
        m_drive = drive;
        addRequirements(m_drive);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
    }

    // Called every time the scheduler runs while the command is scheduled.
    // Sets up drive motors to ingore deadzone inputs.
    // Allows drive to run.
    @Override
    public void execute()
    {

        m_drive.drive(-.5*Utilities.applyDeadzone(RobotContainer.m_driverController.getLeftY()), // x
                                                                                              // speed
                -.5*Utilities.applyDeadzone(RobotContainer.m_driverController.getLeftX()), // y speed
                -.5*Utilities.applyDeadzone(RobotContainer.m_driverController.getRightX()), // rot
                                                                                         // speed
                true, true);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted)
    {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
