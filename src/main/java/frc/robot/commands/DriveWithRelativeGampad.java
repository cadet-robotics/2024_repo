// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drive.swerve.DriveSubsystem;

public class DriveWithRelativeGampad extends Command {
  DriveSubsystem m_drive;
  /** Creates a new DriveWithGampad. */
  public DriveWithRelativeGampad(DriveSubsystem drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double ySpeed = 0, xSpeed = 0, rotSpeed = 0;
    if (RobotContainer.m_driverController.getLeftY() > 0.1 || RobotContainer.m_driverController.getLeftY() < -0.1) {
        ySpeed = RobotContainer.m_driverController.getLeftY();
    }
    if (RobotContainer.m_driverController.getLeftX() > 0.1 || RobotContainer.m_driverController.getLeftX() < -0.1) {
        xSpeed = RobotContainer.m_driverController.getLeftX();
    }
    if (RobotContainer.m_driverController.getRightX() > 0.1 || RobotContainer.m_driverController.getRightX() < -0.1) {
        rotSpeed = RobotContainer.m_driverController.getRightX();
    }
    m_drive.drive(-ySpeed,-xSpeed,0,false,true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
