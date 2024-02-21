// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherElevation;

import edu.wpi.first.wpilibj2.command.Command;

public class ElevateToPosition extends Command 
{
    private LauncherElevationSubsystem launcherElevationSubsystem;
    private double position;
    /** Creates a new ElevateToPosition. 
     * Max value is 153.5 min is zero
    */
    public ElevateToPosition(LauncherElevationSubsystem subsystem, double position) 
    {
        launcherElevationSubsystem = subsystem;

        addRequirements(launcherElevationSubsystem);

        this.position = position;
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
        double error = position - launcherElevationSubsystem.GetEncoder();
        if (Math.abs(error) < 1)
        {
            launcherElevationSubsystem.SetElevation(0);
        }
        else if(error > 0)
        {
            launcherElevationSubsystem.SetElevation(0.25);
        }
        else if(error < 0)
        {
            launcherElevationSubsystem.SetElevation(-0.25);
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
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() 
    {
        return !launcherElevationSubsystem.HasBeenHomed() || Math.abs(position - launcherElevationSubsystem.GetEncoder()) < 1;
    }
}
