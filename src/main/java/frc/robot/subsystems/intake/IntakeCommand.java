// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;

public class IntakeCommand extends Command {
    
    private IntakeSubsystem intakeSubsystem;
    /** Creates a new OuttakeCommand. */
    public IntakeCommand(IntakeSubsystem subsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        intakeSubsystem = subsystem;
        addRequirements(intakeSubsystem);
    }
    
    public boolean Loaded() 
    {
        return !intakeSubsystem.GetPhotoEyeSubsystem().GetPhotoEyeState();
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        intakeSubsystem.setIntake(OperatorConstants.INTAKE_SPEED);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.setIntake(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return Loaded();
    }
}
