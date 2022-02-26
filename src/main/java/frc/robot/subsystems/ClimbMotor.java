package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbMotor extends SubsystemBase {
    Spark armMotor;

    public ClimbMotor() {
        armMotor = new Spark(Constants.Climber.climberSparkPwm);
    }

    public void armRaise(double speed) {
        armMotor.set(speed);
    }

    @Override
    public void periodic() {

    }
}
