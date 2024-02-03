// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherElevation;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Subsystem used to set the proper angle for the firing system
 */
public class LauncherElevationSubsystem extends SubsystemBase
{
    /** Creates a new Subsystem. */
    public LauncherElevationSubsystem()
    {
        setDefaultCommand(new ElevationCommand(this));
    }

    @Override
    public void periodic()
    {

    }
}
