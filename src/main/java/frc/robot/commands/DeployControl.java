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
        //m_deploy.armDeploy(deploySpeed.getAsDouble()); 
        
        m_deploy.armDeploy(speed);

        m_deploy.lowerDeploy(-speed);
    }

    @Override
    public void end(boolean interrupted){
        m_deploy.armDeploy(0);
        m_deploy.lowerDeploy(0);
    }
}
