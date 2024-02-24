// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.launcherFiring.LauncherFiringSubsystem;
import frc.robot.subsystems.launcherFiring.LauncherFiringSubsystem.LaunchMotor;

public class SpinUpCommand extends Command 
{
    // controlling subsystem
    private LauncherFiringSubsystem launcherFiringSubsystem;
    public SpinUpCommand(LauncherFiringSubsystem subsystem)
    {
        launcherFiringSubsystem = subsystem;
        addRequirements(launcherFiringSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute()
    {
        // launcherFiringSubsystem.ControlLaunchMotor(LaunchMotor.TOP, Constants.OperatorConstants.LAUNCHER_TOP_OUTPUT);
        // launcherFiringSubsystem.ControlLaunchMotor(LaunchMotor.BOTTOM, Constants.OperatorConstants.LAUNCHER_BOTTOM_OUTPUT);
        launcherFiringSubsystem.setLauncher1Speed(Constants.OperatorConstants.LAUNCH_1_SPEED);
        launcherFiringSubsystem.setLauncher2Speed(Constants.OperatorConstants.LAUNCH_2_SPEED);
    }

    @Override
    public void end(boolean interrupted)
    {

    }
    
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
