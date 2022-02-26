package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Deploy extends SubsystemBase {
    Spark deployMotor;


    public Deploy() {
        deployMotor = new Spark(Constants.Deployer.deploySparkPwm);
    }

    public void armDeploy(double speed) {
        deployMotor.set(speed);

    }

    public void lowerDeploy(double speed) {
        deployMotor.set(-speed);

    }

    @Override
    public void periodic() {

        
    }
}
