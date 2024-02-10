package frc.robot.subsystems.climber;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.limitSwitchStateMonitor.SensorStateMonitorSubsystem;

/**
 * Subsystem used to control robot as it climbs on chain
 */
public class ClimberSubsystem extends SubsystemBase
{
    // motor that control in the disc intake
    private final CANSparkMax climberMotor =
            new CANSparkMax(OperatorConstants.CLIMBER_MOTOR_ID, MotorType.kBrushless);
    
    private SensorStateMonitorSubsystem limitSwitchSubsystem;

    /** Creates a new Subsystem. */
    public ClimberSubsystem(SensorStateMonitorSubsystem limitSwitchSubsystem)
    {        
        this.limitSwitchSubsystem = limitSwitchSubsystem;

        // set triangle button to trigger Ascend command
        RobotContainer.m_coDriverController.button(PS4Controller.Button.kTriangle.value).whileTrue(new ClimberAscendCommand(this));

        // set cross button to trigger Descend command
        RobotContainer.m_coDriverController.button(PS4Controller.Button.kCross.value).whileTrue(new ClimberDescendCommand(this));
    }

    @Override
    public void periodic()
    {

    }

    /**
     * Accessor for spark max motor controlling the climbing mechanism for the robot
     * 
     * @return climber motor
     */
    public CANSparkMax ClimberMotor()
    {
        return climberMotor;
    }

    /**
     * Accessor for the limitSwitchSubsystem 
     * @return the one limitSwitchSubsystem
     */
    public SensorStateMonitorSubsystem GetLimitSwitchSubsystem()
    {
        return limitSwitchSubsystem;
    }
}
