package frc.robot.commands;
import frc.robot.subsystems.Deploy;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DeployControl extends CommandBase {
    private final Deploy m_deploy;

    DoubleSupplier deploySpeed;
 
    public DeployControl(Deploy m_deploy, DoubleSupplier deploySpeed){    
        this.m_deploy = m_deploy;
        addRequirements(m_deploy);

        this.deploySpeed = deploySpeed;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_deploy.armDeploy(deploySpeed.getAsDouble());        
    }
}
