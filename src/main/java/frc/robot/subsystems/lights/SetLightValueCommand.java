// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.lights;

import edu.wpi.first.wpilibj2.command.Command;

public class SetLightValueCommand extends Command {

    private double value;
    private LEDSubsytem ledSubsytem;
    public SetLightValueCommand(LEDSubsytem ledSubsystem, double value) 
    {
        this.value = value;
        this.ledSubsytem = ledSubsystem;
    }

    @Override
    public void initialize() 
    {
        ledSubsytem.setValue(value);
    }
    @Override
    public boolean isFinished() 
    {
        return true;
    }
}
