// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherFiring;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.limitSwitchStateMonitor.SensorStateMonitorSubsystem;

/**
 * Subsystem used to fire the note 
 */
public class LauncherFiringSubsystem extends SubsystemBase
{
    private final CANSparkMax[] launchMotors = new CANSparkMax[]
    {
        new CANSparkMax(OperatorConstants.LAUNCH_MOTOR_ID1, MotorType.kBrushless),
        new CANSparkMax(OperatorConstants.LAUNCH_MOTOR_ID2, MotorType.kBrushless)
    };

    private SensorStateMonitorSubsystem sensorSubsystem;

    public static enum LaunchMotor{
        TOP,
        BOTTOM
    }
    
    /** Creates a new Subsystem. */
    public LauncherFiringSubsystem(SensorStateMonitorSubsystem sensorSubsystem)
    {
        this.sensorSubsystem = sensorSubsystem;
    }

    @Override
    public void periodic()
    {
        launchMotors[0].get();
    }

    public void ControlLaunchMotor(LaunchMotor motor, double power)
    {
        launchMotors[motor.ordinal()].set(power);
    }

    public void StopAllMotors()
    {
        for(int i = 0; i < launchMotors.length; ++i)
        {
            launchMotors[i].stopMotor();;
        }
    }

    public SensorStateMonitorSubsystem GetPhotoEyeSubsystem()
    {
        return sensorSubsystem;
    }
}
