package frc.robot.subsystems.template;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * Template class to show design of generic design of command implementation
 */
public class TemplateCommand extends Command
{
    // controlling subsystem
    private TemplateSubsystem templateSubsystem;

    public TemplateCommand(TemplateSubsystem subsystem)
    {
        templateSubsystem = subsystem;
        addRequirements(templateSubsystem);
    }

    @Override
    public void initialize()
    {
    }

    @Override
    public void execute()
    {

    }

    @Override
    public void end(boolean interrupted)
    {
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}
