// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherFiring;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

/**
 * Subsystem used to fire the note 
 */
public class LauncherFiringSubsystem extends SubsystemBase
{
    private static final CANSparkMax launchMotor1 =
            new CANSparkMax(OperatorConstants.LAUNCH_MOTOR_ID1, MotorType.kBrushless);
    private static final CANSparkMax launchMotor2 =
            new CANSparkMax(OperatorConstants.LAUNCH_MOTOR_ID2, MotorType.kBrushless);
    /** Creates a new Subsystem. */
    public LauncherFiringSubsystem()
    {
        setDefaultCommand(new FireCommand(this));
    }

    @Override
    public void periodic()
    {

    }

    public static void ControlLaunchMotor1(int power)
    {
        launchMotor1.set(power);
    }
    public static void ControlLaunchMotor2(int power2)
    {
        launchMotor2.set(power2);
    }
}
