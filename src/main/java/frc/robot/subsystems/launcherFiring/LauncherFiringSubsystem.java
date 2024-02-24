// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherFiring;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.limitSwitchStateMonitor.SensorStateMonitorSubsystem;

/**
 * Subsystem used to fire the note 
 */
public class LauncherFiringSubsystem extends SubsystemBase
{

    private RelativeEncoder launchEncoder1, launchEncoder2;

    private final CANSparkMax[] launchMotors = new CANSparkMax[]
    {
        new CANSparkMax(OperatorConstants.LAUNCH_MOTOR_ID1, MotorType.kBrushless),
        new CANSparkMax(OperatorConstants.LAUNCH_MOTOR_ID2, MotorType.kBrushless)
    };

    private SensorStateMonitorSubsystem sensorSubsystem;

    public static enum LaunchMotor{
        BOTTOM,
        TOP
        
    }
    
    /** Creates a new Subsystem. */
    public LauncherFiringSubsystem(SensorStateMonitorSubsystem sensorSubsystem)
    {
        this.sensorSubsystem = sensorSubsystem;
        launchEncoder1 = launchMotors[0].getEncoder();
        launchEncoder2= launchMotors[1].getEncoder();
        launchEncoder1.setVelocityConversionFactor(1);
        
        launchEncoder2.setVelocityConversionFactor(1);
    }
    
    @Override
    public void periodic()
    {
        launchMotors[0].get();
        SmartDashboard.putNumber("Launch Encoder 1", getLaunchEncoder1());
        SmartDashboard.putNumber("Launch Encoder 2", getLaunchEncoder2());
        SmartDashboard.putBoolean("Launch isUpToSPeed", isUpToSpeed());
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

    public double getLaunchEncoder1()
    {
        return launchEncoder1.getVelocity();
    }

    public double getLaunchEncoder2()
    {
        return launchEncoder2.getVelocity();
    }

    public boolean isUpToSpeed()
    {
        return Math.abs(Constants.OperatorConstants.LAUNCH_1_SPEED-getLaunchEncoder1())<150 && Math.abs(Constants.OperatorConstants.LAUNCH_2_SPEED-getLaunchEncoder2())<150;
    }


}
