// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherElevation;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.limitSwitchStateMonitor.SensorStateMonitorSubsystem;

/**
 * Subsystem used to set the proper angle for the firing system
 */
public class LauncherElevationSubsystem extends SubsystemBase
{
    private final CANSparkMax elevationMotor =
            new CANSparkMax(OperatorConstants.LAUNCH_ELEVATION_MOTOR_ID, MotorType.kBrushless);
    private SensorStateMonitorSubsystem sensorSubsystem;
    private RelativeEncoder elevationEncoder;
    private boolean hasBeenHomed = false;
    
    /** Creates a new Subsystem. */
    public LauncherElevationSubsystem(SensorStateMonitorSubsystem sensorSubsystem)
    {
        this.sensorSubsystem = sensorSubsystem;

        setDefaultCommand(new ElevationCommand(this));

        elevationEncoder = elevationMotor.getEncoder();
        elevationEncoder.setPositionConversionFactor(1);
    }

    @Override
    public void periodic()
    {
        SmartDashboard.putNumber("Lift Encoder", GetEncoder());
    }
    public void SetEncoder(double position)
    {
        elevationEncoder.setPosition(position);
    }
    public double GetEncoder()
    {
        return elevationEncoder.getPosition();
    }
     /**
     * Accessor for the limitSwitchSubsystem 
     * @return the one limitSwitchSubsystem
     */
    public void SetElevation(double power)
    {
        if (GetLimitSwitchSubsystem().GetLimitSwitchState(OperatorConstants.LAUNCH_ELEV_ASCEND_LS) && power>0.0)
        {
            elevationMotor.set(0.0);
        }
        else if (GetLimitSwitchSubsystem().GetLimitSwitchState(OperatorConstants.LAUNCH_ELEV_DESCEND_LS) && power < 0.0)
        {
            elevationMotor.set(0.0);
        } 
        else
        {
            elevationMotor.set(power);
        }
    }

    public SensorStateMonitorSubsystem GetLimitSwitchSubsystem()
    {
        return sensorSubsystem;
    }

    public void SetHasBeenHomed(boolean hasBeenHomed){
        this.hasBeenHomed = hasBeenHomed;
    }

    public boolean HasBeenHomed(){
        return hasBeenHomed;
    }
}
