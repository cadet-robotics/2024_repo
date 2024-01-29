// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.components.intake;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

/** Add your docs here. */
public class IntakeSubsystem extends SubsystemBase
{
    private final Spark m_intake = new Spark(11);
    /** Creates a new DriveSubsystem. */
    public IntakeSubsystem()
    {
        
    }

    @Override
    public void periodic()
    {
        SmartDashboard.putNumber("Intake Power", m_intake.get());
    }

    public void ControlIntake(double power)
    {
        m_intake.set(power);
    }

}
