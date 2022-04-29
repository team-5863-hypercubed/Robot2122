package frc.robot.subsystems;

import javax.swing.text.Position;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.OrientateFieldTurret;
import frc.robot.RobotContainer;

public class Turret extends SubsystemBase {


  public static double targetValid; // Whether the limelight has any valid targets (0 or 1)
  public static double targetX; // HorizontalDR Offset From Crosshair To Target (-27 degrees to 27 degrees
  public static double targetY; // Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
  public static double targetArea; // Target Area (0% of image to 100% of image)



  public TalonSRX turret = new TalonSRX(4);

  public MedianFilter mFilter = new MedianFilter(5);

  public static boolean isAtTargetPosition;

  /** Creates a new Turret. */
  public Turret() {
    turret.setSelectedSensorPosition(0);
    turret.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    turret.setNeutralMode(NeutralMode.Coast);

    turret.configForwardSoftLimitThreshold(degreesToTicks(30));
    turret.configReverseSoftLimitThreshold(degreesToTicks(-30));

    turret.configForwardSoftLimitEnable(true);
    turret.configReverseSoftLimitEnable(true);

    turret.config_kP(0, 1.2);
    turret.config_kI(0, 0);
    turret.config_kD(0, 3.5);
    
    turret.config_kP(1, 0);
    turret.config_kI(1, 0);
    turret.config_kD(1, 0);
 
    turret.selectProfileSlot(0, 0);

    // turret.setStatusFramePeriod(StatusFrame.Status_1_General, 10);
  }


  public void trackTarget() {
    setTurretPosition(getCurrentAngle() - targetX);
  }

  // Assuming 0 is facing the opposite of the intake .
  // Start match turret facing backwards; 180 is facing the intake.

  // rotate turret to specified angle
  public void setTurretPosition(double targetAngle) {
    turret.set(ControlMode.Position, degreesToTicks(targetAngle));
  }

  public void stop() {
    turret.set(ControlMode.PercentOutput, 0);
  }

  public double degreesToTicks(double theta) {
    return theta * (22320 / 360.0);
  }

  public double getCurrentAngle() {
    return (turret.getSelectedSensorPosition() / 22320) * 360;
  }


  /*public double turretpos(double targetAngle) {
    targetAngle = turret.getSelectedSensorPosition();
    turret.set(ControlMode.Position, targetAngle);
    return targetAngle;
    
}*/

  public void manualturn(double rotation){
    turret.set(ControlMode.PercentOutput, rotation);
  }

    
  public void resetEncoder() {
    turret.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    // SmartDashboard.putNumber("TurretEncoder", turret.getSelectedSensorPosition());
    // SmartDashboard.putNumber("Desired Value", degreesToTicks(90));

    SmartDashboard.putNumber("Current Angle", getCurrentAngle());
    SmartDashboard.putNumber("TargetX", targetX);
    // RobotContainer.limelight.getAngleToTarget().getAsDouble());

    SmartDashboard.putBoolean("Is At Target Position", isAtTargetPosition);

    targetValid = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    targetX = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    targetY = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    targetArea = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);


   
  }
}