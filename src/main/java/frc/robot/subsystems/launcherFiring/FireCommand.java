// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherFiring;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.launcherFiring.LauncherFiringSubsystem.LaunchMotor;

/**
 * Command used to control firing the note based on input from controller
 */
public class FireCommand extends Command
{

    // controlling subsystem
    private LauncherFiringSubsystem launcherFiringSubsystem;
    private boolean launchInitiated = false;

    public FireCommand(LauncherFiringSubsystem subsystem)
    {
        launcherFiringSubsystem = subsystem;
        addRequirements(launcherFiringSubsystem);
    }

    public boolean Loaded() 
    {
        return !launcherFiringSubsystem.GetPhotoEyeSubsystem().GetPhotoEyeState();
    }

    public boolean LaunchRequested()
    {
        return RobotContainer.m_coDriverController.getR2Axis() > OperatorConstants.DEADZONE && 
               RobotContainer.m_coDriverController.getL2Axis() > OperatorConstants.DEADZONE;
    }

    @Override
    public void execute()
    // TODO: figure out timings to set an amount of time for motors to run once pressed
    {
        if (LaunchRequested())
        {
            if (Loaded())
            {
                if(!launchInitiated)
                {
                    // Motor button active, set motor power
                    launcherFiringSubsystem.ControlLaunchMotor(LaunchMotor.TOP, 1);
                    launcherFiringSubsystem.ControlLaunchMotor(LaunchMotor.BOTTOM, 0.55);
                    launcherFiringSubsystem.IntakeSubsystem().IntakeMotor().set(0.75);
                    //launchInitiated = true;
                }
            }
        }
        else
        {
            launcherFiringSubsystem.StopAllMotors();
           //launcherFiringSubsystem.IntakeSubsystem().IntakeMotor().stopMotor();
            launchInitiated = false;
        }
    }
}
