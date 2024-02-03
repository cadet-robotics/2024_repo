// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherFiring;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * Command used to control firing the note based on input from controller
 */
public class FireCommand extends Command
{
    // controlling subsystem
    private LauncherFiringSubsystem launcherFiringSubsystem;

    public FireCommand(LauncherFiringSubsystem subsystem)
    {
        launcherFiringSubsystem = subsystem;
        addRequirements(launcherFiringSubsystem);
    }

    @Override
    public void execute()
    {
    }
}
