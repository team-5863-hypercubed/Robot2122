package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    public VictorSP shootMotor;
    public VictorSP shootMotor2;


    public Shooter() {
        shootMotor = new VictorSP(5);
        shootMotor2 = new VictorSP(6);
    }

    public void setPower(double power) {
        shootMotor.set(power); //theoretically clockwise
        shootMotor2.set(-power);//theoretically counterclockwise
    }

    @Override
    public void periodic() {

    }
}
