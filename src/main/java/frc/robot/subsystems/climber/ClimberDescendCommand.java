package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;

/**
 * Command used to control robot as it climbs on chain  
 */
public class ClimberDescendCommand extends Command
{
    // controlling subsystem
    private ClimberSubsystem climberSubsystem;

    public ClimberDescendCommand(ClimberSubsystem subsystem)
    {
        climberSubsystem = subsystem;
        addRequirements(climberSubsystem);
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {
        if (climberSubsystem.GetLimitSwitchSubsystem().GetLimitSwitchState(OperatorConstants.CLIMB_DESCEND_LS))
        {
            //limit switch for descend is true stop motor so nothing breaks
            climberSubsystem.ClimberMotor().set(0);
        }
        else
        {
            climberSubsystem.ClimberMotor().set(OperatorConstants.CLIMB_DESCEND_SPEED);
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        climberSubsystem.ClimberMotor().set(0);
    }   
    @Override
    public boolean isFinished(){
        return climberSubsystem.GetLimitSwitchSubsystem().GetLimitSwitchState(OperatorConstants.CLIMB_DESCEND_LS);
    } 
}
