package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.*;


public class DriveCommand extends CommandBase {
    private final DriveTrain m_driveTrain;

    private DoubleSupplier speed;
    private DoubleSupplier rotation;

    public DriveCommand(DriveTrain m_driveTrain, DoubleSupplier speed, DoubleSupplier rotation) {
        this.m_driveTrain = m_driveTrain;
        addRequirements(m_driveTrain);

        this.speed = speed;
        this.rotation = rotation;
    }

    @Override
    public void execute() {
        m_driveTrain.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    }
}
