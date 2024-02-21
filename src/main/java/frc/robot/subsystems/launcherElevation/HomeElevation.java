// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherElevation;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;

public class HomeElevation extends Command 
{
    private LauncherElevationSubsystem launcherElevationSubsystem;

    public HomeElevation(LauncherElevationSubsystem subsystem)
    {
        launcherElevationSubsystem = subsystem;

        addRequirements(launcherElevationSubsystem);
    }
    // Called when the command is initially scheduled.
    @Override
    public void initialize() 
    {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
        if (!launcherElevationSubsystem.GetLimitSwitchSubsystem().GetLimitSwitchState(OperatorConstants.LAUNCH_ELEV_DESCEND_LS))
        {
            launcherElevationSubsystem.SetElevation(-0.5);
        }
        else
        {
            launcherElevationSubsystem.SetElevation(0);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) 
    {
        launcherElevationSubsystem.SetElevation(0);
        if (!interrupted)
        {
            launcherElevationSubsystem.SetEncoder(0);
            launcherElevationSubsystem.SetHasBeenHomed(true);
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return launcherElevationSubsystem.GetLimitSwitchSubsystem().GetLimitSwitchState(OperatorConstants.LAUNCH_ELEV_DESCEND_LS);
    }
}
