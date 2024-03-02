// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.lights;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

/** Add your docs here. */
public class LEDSubsytem 
{
    private PWMSparkMax ledController;

    public void LEDSubsystem(PWMSparkMax ledController) {
        this.ledController = ledController;
    }

    // value between -1 and 1
    public void setValue(double val) {
        ledController.set(val);
    }
}
