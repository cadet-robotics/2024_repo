// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherElevation;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.limitSwitchStateMonitor.LimitSwitchStateMonitorSubsystem;

/**
 * Subsystem used to set the proper angle for the firing system
 */
public class LauncherElevationSubsystem extends SubsystemBase
{
    private final CANSparkMax elevationMotor =
            new CANSparkMax(OperatorConstants.LAUNCH_ELEVATION_MOTOR_ID, MotorType.kBrushless);
    private LimitSwitchStateMonitorSubsystem limitSwitchSubsystem;
    /** Creates a new Subsystem. */
    public LauncherElevationSubsystem(LimitSwitchStateMonitorSubsystem limitSwitchSubsystem)
    {
        this.limitSwitchSubsystem = limitSwitchSubsystem;

        setDefaultCommand(new ElevationCommand(this));
    }

    @Override
    public void periodic()
    {

    }
     /**
     * Accessor for the limitSwitchSubsystem 
     * @return the one limitSwitchSubsystem
     */
    public CANSparkMax ElevationMotor()
    {
        return elevationMotor;
    }

    public LimitSwitchStateMonitorSubsystem GetLimitSwitchSubsystem()
    {
        return limitSwitchSubsystem;
    }
}
