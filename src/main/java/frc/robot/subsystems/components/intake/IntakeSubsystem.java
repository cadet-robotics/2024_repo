// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.components.intake;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.OperatorConstants;

/** Add your docs here. */
public class IntakeSubsystem extends SubsystemBase
{
    private final CANSparkMax m_intake = new CANSparkMax(OperatorConstants.kIntakeMotorCanId , MotorType.kBrushless);
    /** Creates a new DriveSubsystem. */
    public IntakeSubsystem()
    {
        
    }

    @Override
    public void periodic()
    {

    }

    public void ControlIntake(double power)
    {
        m_intake.set(power);
    }

}
