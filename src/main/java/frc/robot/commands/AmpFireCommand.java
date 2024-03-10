// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.launcherFiring.LauncherFiringSubsystem;

/**
 * Command used to control firing the note based on input from controller
 */
public class AmpFireCommand extends Command
{

    // controlling subsystem
    private LauncherFiringSubsystem launcherFiringSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private Timer time = new Timer();
    
    public AmpFireCommand(LauncherFiringSubsystem subsystem, IntakeSubsystem subsystem2)
    {
        launcherFiringSubsystem = subsystem;
        intakeSubsystem = subsystem2;
        addRequirements(launcherFiringSubsystem,intakeSubsystem);
    }

    public boolean Loaded() 
    {
        return !intakeSubsystem.GetPhotoEyeSubsystem().GetPhotoEyeState();
    }

    @Override
    public void initialize() {
        time.restart();
    }

    @Override
    public void execute()
    {
        launcherFiringSubsystem.setLauncher1Speed(Constants.OperatorConstants.AMP_LAUNCH_1_SPEED);
        launcherFiringSubsystem.setLauncher2Speed(Constants.OperatorConstants.AMP_LAUNCH_2_SPEED);
        if(time.hasElapsed(Constants.OperatorConstants.DELAY_FOR_SHOOT_START) || launcherFiringSubsystem.isUpToSpeed())
            intakeSubsystem.setIntake(1);
        
    
    }
    @Override
    public void end(boolean interrupted){
        launcherFiringSubsystem.StopAllMotors();
        intakeSubsystem.setIntake(0);
    }
    
    @Override
    public boolean isFinished(){
        return time.hasElapsed(Constants.OperatorConstants.DELAY_FOR_SHOOTING + Constants.OperatorConstants.DELAY_FOR_SHOOT_START);
    }
}
