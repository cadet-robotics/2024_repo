// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.launcherElevation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.utilities.Utilities;
import frc.robot.RobotContainer;

/**
 * Command used to control elevation fo launcher based on input from controller
 */
public class ElevationCommand extends Command
{
    // controlling subsystem
    private LauncherElevationSubsystem launcherElevationSubsystem;

    public ElevationCommand(LauncherElevationSubsystem subsystem)
    {
        launcherElevationSubsystem = subsystem;

        addRequirements(launcherElevationSubsystem);
    }

    @Override
    public void execute()
    {
        double powerToSet = 0;
        double joystickPower = RobotContainer.m_coDriverController.getRightY();
        
        if (launcherElevationSubsystem.GetLimitSwitchSubsystem().GetLimitSwitchState(OperatorConstants.LAUNCH_ELEV_ASCEND_LS))
        {
            if (joystickPower < -OperatorConstants.DEADZONE)
            {
                powerToSet = joystickPower;
            }
        }
        else if (launcherElevationSubsystem.GetLimitSwitchSubsystem().GetLimitSwitchState(OperatorConstants.LAUNCH_ELEV_DESCEND_LS))
        {
            if (joystickPower > OperatorConstants.DEADZONE)
            {
                powerToSet = joystickPower;
            }
        }
        else
        {
            powerToSet = Utilities.applyDeadzone(joystickPower);
        }

        launcherElevationSubsystem.ElevationMotor().set(powerToSet);
    }
}
