package frc.robot.subsystems.limitSwitchStateMonitor;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

/**
 * Template class to show design of generic design of subsystem implementation
 */
public class SensorStateMonitorSubsystem extends SubsystemBase
{
    // Initializes a DigitalInput on DIOs
    private DigitalInput[] limitSwitches = new DigitalInput[4];
    private String[] limitSwitchNames = new String[] 
    {
        "CLIMB_ASCEND_LS",
        "CLIMB_DESCEND_LS",
        "LAUNCH_ELEV_ASCEND_LS",
        "LAUNCH_ELEV_DESCEND_LS"
    };
    
    private DigitalInput photoEye = new DigitalInput(OperatorConstants.LAUNCH_FIRE_LIGHTS);
    
    /** Creates a new Subsystem. */
    public SensorStateMonitorSubsystem()
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
            SmartDashboard.putBoolean(limitSwitchNames[i], limitSwitches[i].get());
        }

        SmartDashboard.putBoolean("Photo Eye", photoEye.get());
    }

    public boolean GetLimitSwitchState(int index)
    {
        return limitSwitches[index].get();
    }

    public boolean GetPhotoEyeState()
    {
        return photoEye.get();
    }
}
