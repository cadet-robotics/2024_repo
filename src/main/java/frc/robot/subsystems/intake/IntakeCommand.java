// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.RobotContainer;

/**
 * Command used to control intake motor based on input from controller
 */
public class IntakeCommand extends Command
{
    // controlling subsytem
    private IntakeSubsystem intakeSubsystem;

    /** Creates a new Intake. */
    public IntakeCommand(IntakeSubsystem subsystem)
    {
        intakeSubsystem = subsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute()
    {
        // prioritizes intake control
        // checks for value of variable button input, assuming value exceeds deadzone threshold
        if (RobotContainer.m_driverController.getL2Axis() > OperatorConstants.DEADZONE)
        {
            // intake button active, set motor power
            intakeSubsystem.IntakeMotor().set(-RobotContainer.m_driverController.getL2Axis());
        }
        else if (RobotContainer.m_driverController.getR2Axis() > OperatorConstants.DEADZONE)
        {
            // intake button not active, but outake is, set motor power
            intakeSubsystem.IntakeMotor().set(RobotContainer.m_driverController.getR2Axis());
        }
        else
        {
            // no controller intput, set intake speed to 0
            intakeSubsystem.IntakeMotor().stopMotor();;
        }
    }
}
