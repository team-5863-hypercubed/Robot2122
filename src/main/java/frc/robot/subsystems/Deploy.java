package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Deploy extends SubsystemBase {
    VictorSP deployMotor;

    public Deploy() {
        deployMotor = new VictorSP(Constants.Deployer.deployVictorSPPwm);
    }

    public void armDeploy(double speed) {
        deployMotor.set(speed);
    }

    @Override
    public void periodic() {

    }
}
