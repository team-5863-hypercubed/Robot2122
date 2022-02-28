package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.*;

//import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class DriveTrain extends SubsystemBase {

    WPI_TalonSRX leftFrontMotor, rightFrontMotor;
    Spark leftBackMotor, rightBackMotor;
    DifferentialDrive drive;
    TalonSRX Talon;
    public  DriveTrain() {
        //Creates motor objects for robot movement.
        leftFrontMotor = new WPI_TalonSRX(Constants.Drivetrain.leftTaloniD);
        rightFrontMotor = new WPI_TalonSRX(Constants.Drivetrain.rightTaloniD);
        leftBackMotor = new Spark(Constants.Drivetrain.leftSparkPwm);
        rightBackMotor = new Spark(Constants.Drivetrain.rightSparkPwm);
        rightFrontMotor.setInverted(true);
        rightBackMotor.setInverted(true);
    
       // rightFrontMotor.setNeutralMode(NeutralMode.Brake);
       // leftFrontMotor.setNeutralMode(NeutralMode.Brake);
        //Creates objects containing movement motors. Here, the motors are grouped by the side of the robot they occupy.
        MotorControllerGroup leftSide = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
        MotorControllerGroup rightSide = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
        drive = new DifferentialDrive(leftSide, rightSide);
        drive.setSafetyEnabled(false);
        
        
        

    }

    /*public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }*/

    public  void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    @Override
    public void periodic() {

    }
}
