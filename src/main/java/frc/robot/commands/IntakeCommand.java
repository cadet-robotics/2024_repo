// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.components.intake.IntakeSubsystem;
import frc.robot.RobotContainer;

public class IntakeCommand extends Command {
    IntakeSubsystem m_intake;

    /** Creates a new Intake. */
    public IntakeCommand(IntakeSubsystem intake) {
        m_intake = intake;
        addRequirements(m_intake);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
    }
    
    // If the left trigger is above the deadzone then the outtake runs.
    // If the right trigger is above the deadzone then the intake runs.
    // Sets power to 0
    @Override
    public void execute()
    {
        // prioritizes L2Axis (intake) over outtake
        if (RobotContainer.m_driverController.getL2Axis() > OperatorConstants.DEADZONE)
        {
            m_intake.ControlIntake(-RobotContainer.m_driverController.getL2Axis());
        }
        else if (RobotContainer.m_driverController.getR2Axis() > OperatorConstants.DEADZONE)
        {
            m_intake.ControlIntake(RobotContainer.m_driverController.getR2Axis());
        }
        else
        {
            m_intake.ControlIntake(0);
        }
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
