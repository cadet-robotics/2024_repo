// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.limitSwitchStateMonitor.SensorStateMonitorSubsystem;


/**
 * Subsystem used to control the intake for feeding note into the robot
 */
public class IntakeSubsystem extends SubsystemBase
{
    // motor that control in the disc intake
    private final CANSparkMax intakeMotor =
            new CANSparkMax(OperatorConstants.INTAKE_MOTOR_ID, MotorType.kBrushless);

    private SensorStateMonitorSubsystem sensorSubsystem;

    /** Creates a new IntakeSubsystem. */
    public IntakeSubsystem(SensorStateMonitorSubsystem sensorSubsystem)
    {
        this.sensorSubsystem = sensorSubsystem;
    }

    @Override
    public void periodic()
    {

    }

    public void setIntake(double speed){
        intakeMotor.set(speed);
    }

    public SensorStateMonitorSubsystem GetPhotoEyeSubsystem()
    {
        return sensorSubsystem;
    }
}
