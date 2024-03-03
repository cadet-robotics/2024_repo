// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.lights;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
public class LEDSubsytem extends SubsystemBase
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
