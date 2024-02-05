package frc.robot.subsystems.climber;

import java.util.Set;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants;
import frc.robot.RobotContainer;

/**
 * Command used to control robot as it climbs on chain  
 */
public class ClimberCommand extends Command
{
    // controlling subsystem
    private ClimberSubsystem climberSubsystem;

    public ClimberCommand(ClimberSubsystem subsystem)
    {
        climberSubsystem = subsystem;
        addRequirements(climberSubsystem);
    }

    @Override
    public void initialize()
    {
        climberSubsystem.ClimberMotor().set(OperatorConstants.CLIMB_ASCEND_SPEED);

    }

    @Override
    public void end(boolean interrupted)
    {
        climberSubsystem.ClimberMotor().set(0);
    }    
}
