package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj.Encoder;


public class TeleOPDrive extends CommandBase {
    private final DriveTrain m_driveTrain;

    private DoubleSupplier speed;
    private DoubleSupplier rotation;

     /**
   * Constructs a SwerveModule with a drive motor, turning motor, drive encoder and turning encoder.
   *
   * @param driveEncoderChannelA DIO input for the drive encoder channel A
   * @param driveEncoderChannelB DIO input for the drive encoder channel B
   * @param turningEncoderChannelA DIO input for the turning encoder channel A
   * @param turningEncoderChannelB DIO input for the turning encoder channel B
   */

    public TeleOPDrive(DriveTrain m_driveTrain, DoubleSupplier speed, DoubleSupplier rotation) {
        this.m_driveTrain = m_driveTrain;
        addRequirements(m_driveTrain);

        this.speed = speed;
        this.rotation = rotation;
        
    }




    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        SmartDashboard.putNumber("speed", speed.getAsDouble());
        SmartDashboard.putNumber("rotation", rotation.getAsDouble());
        m_driveTrain.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());


    }
}
