package frc.robot.commands;
import frc.robot.subsystems.Deploy;


//import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DeployControl extends CommandBase {
    private final Deploy m_deploy;

    //DoubleSupplier deploySpeed;

    Double speed;
 
    public DeployControl(Deploy m_deploy, Double speed){    
        this.m_deploy = m_deploy;
        this.speed = speed;
        addRequirements(m_deploy); 
        //this.deploySpeed = deploySpeed;

     }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        //m_deploy.armDeploy(speed);

    
       if(Deploy.deployLimit.get() == true){
            m_deploy.armDeploy(speed);
            //Deploy.initializeCounter();
        }
        if(Deploy.deployLimit.get() == false){
            m_deploy.armDeploy(0);

            
            //Deploy.initializeCounter();
    }
        if(Deploy.deployLimit.get() == false) {
            m_deploy.armDeploy(0.5);
        }
}
    
        //m_deploy.armDeploy(deploySpeed.getAsDouble()); 

      /*  while(Deploy.deployLimit.get()) {
            m_deploy.armDeploy(0);
        }*/
        //SmartDashboard.putBoolean("DeployLimit", Deploy.deployLimit.get());




   /* @Override
    public boolean isFinished(){
        return Deploy.isSwitchSet();
    }*/


    @Override
    public void end(boolean interrupted){
    
        m_deploy.armDeploy(0);
        
    }
}
