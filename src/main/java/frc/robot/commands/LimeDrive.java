// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.limeMaster;

public class LimeDrive extends CommandBase {
  private final DriveTrain m_driveTrain;
  private DoubleSupplier speed;
  private DoubleSupplier rotation;
  private limeMaster m_limelight;

  /** Creates a new Drive_LimeLight_Targeting. */
  public LimeDrive(DoubleSupplier speed, DoubleSupplier rotation ,limeMaster m_limelight ,DriveTrain m_driveTrain) {
    this.speed = speed;
    this.rotation = rotation;
    this.m_limelight = m_limelight;
    this.m_driveTrain = m_driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double kp = .0256;
    double xSpeed = speed.getAsDouble();

    double zRotation;
    if (m_limelight.getIsTargetFound()){
      zRotation = m_limelight.getdegRotationToTarget() * kp;
    }else{
      zRotation = rotation.getAsDouble();
    }
    m_driveTrain.arcadeDrive(xSpeed, zRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.arcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}