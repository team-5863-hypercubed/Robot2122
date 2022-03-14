package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Deploy extends SubsystemBase {
    Spark deployMotor;

    public static DigitalInput deployLimit = new DigitalInput(0);
   // public static Counter counter = new Counter(deployLimit);


    public Deploy() {
        deployMotor = new Spark(Constants.Deployer.deploySparkPwm);
    }

    //public static boolean isSwitchSet(){
        //return counter.get() > 0;
     //}

     public static void initializeCounter() {
         //counter.reset();
     }

    public void armDeploy(double speed) {
        deployMotor.set(speed);

    }
    

    @Override
    public void periodic() {

        
    }
}
