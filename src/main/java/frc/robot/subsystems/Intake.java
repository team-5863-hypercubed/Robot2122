package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    public VictorSP intakeMotor;

    public Intake() {
        intakeMotor = new VictorSP(3);

    }

    public void setPower(double power) {
        intakeMotor.set(power);
    }

    @Override
    public void periodic() {

    }
}
