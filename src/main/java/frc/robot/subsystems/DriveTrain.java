package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.Drivetrain;

public class DriveTrain extends SubsystemBase {

    
    WPI_TalonSRX leftBackMotor, rightBackMotor;
    WPI_TalonSRX leftFrontMotor, rightFrontMotor;
    DifferentialDrive drive;
    //Encoder leftEncoder;
    Double position;
    public PigeonIMU gyro;
    
    //public static TalonSRX leftFrontEncMotor = new TalonSRX(1);
   public static TalonSRX rightBackEncMotor = new TalonSRX(3);
    public static double kDriveTick2Feet = 1.0 / 4096 * 6 * Math.PI / 12;
    
    
    public  DriveTrain() {
        //Creates motor objects for robot movement.
        /*leftFrontEncMotor = new WPI_TalonSRX(Constants.Drivetrain.leftTaloniD);
        rightBackEncMotor = new WPI_TalonSRX(Constants.Drivetrain.rightTaloniD);*/
        leftFrontMotor = new WPI_TalonSRX(Constants.Drivetrain.leftFrontTaloniD);
        leftBackMotor = new WPI_TalonSRX(Constants.Drivetrain.leftBackTaloniD);
        rightFrontMotor = new WPI_TalonSRX(Constants.Drivetrain.rightFrontTaloniD);
        rightBackMotor = new WPI_TalonSRX(Constants.Drivetrain.rightBackTaloniD);
        //rightFrontMotor.setInverted(true);
        //rightBackMotor.setInverted(true);
        //leftBackMotor.setInverted(true);
        //leftFrontMotor.setInverted(true);

        //
    
       //rightFrontMotor.setNeutralMode(NeutralMode.Brake);
        //leftFrontMotor.setNeutralMode(NeutralMode.Brake);
        //rightBackMotor.setNeutralMode(NeutralMode.Brake);
        //leftBackMotor.setNeutralMode(NeutralMode.Brake);

        //Creates objects containing movement motors. Here, the motors are grouped by the side of the robot they occupy.
        MotorControllerGroup leftSide = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
        MotorControllerGroup rightSide = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
        drive = new DifferentialDrive(leftSide, rightSide);
        drive.setSafetyEnabled(false);
    
    }
     
    
    /*public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }*/

    public void arcadeDrive(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    

    @Override
    public void periodic() {

        
    }

  /*  public static void enableMotors(boolean on) {
        NeutralMode mode;
        if (on) {
          mode = NeutralMode.Brake;
        }else {
          mode = NeutralMode.Coast;
        }
        
        leftFrontEncMotor.setNeutralMode(mode);
        rightFrontEncMotor.setNeutralMode(mode);
        leftBackMotor.setNeutralMode(mode);
        rightBackMotor.setNeutralMode(mode);
      }*/
}