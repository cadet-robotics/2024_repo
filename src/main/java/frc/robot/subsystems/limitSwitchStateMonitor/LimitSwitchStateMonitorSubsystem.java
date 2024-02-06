package frc.robot.subsystems.limitSwitchStateMonitor;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Template class to show design of generic design of subsystem implementation
 */
public class LimitSwitchStateMonitorSubsystem extends SubsystemBase
{
    // Initializes a DigitalInput on DIOs
    DigitalInput[] limitSwitches = new DigitalInput[4];
    
    /** Creates a new Subsystem. */
    public LimitSwitchStateMonitorSubsystem()
    {
        for(int i = 0; i < 4; ++i)
        {
            limitSwitches[i] = new DigitalInput(i);
        }
    }

    @Override
    public void periodic()
    {
        for(int i = 0; i < 4; ++i)
        {
            SmartDashboard.putBoolean("LimitSwitch " + (i + 1), limitSwitches[i].get());
        }
    }

    public boolean GetLimitSwitchState(int index)
    {
        return limitSwitches[index].get();
    }
}
