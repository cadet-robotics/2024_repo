package frc.robot.subsystems.template;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Template class to show design of generic design of subsystem implementation
 */
public class TemplateSubsystem extends SubsystemBase
{

    /** Creates a new Subsystem. */
    public TemplateSubsystem()
    {
        setDefaultCommand(new TemplateCommand(this));
    }

    @Override
    public void periodic()
    {

    }
}
