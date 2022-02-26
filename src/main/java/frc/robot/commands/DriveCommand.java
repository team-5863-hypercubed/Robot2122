package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase{
    private DriveTrain s_DriveTrain;
    private double speed;
    private double rotation;

    public DriveCommand(DriveTrain s_DriveTrain, double speed, double rotation){
        this.s_DriveTrain = s_DriveTrain;
        this.speed = speed;
        this.rotation = rotation;
    }

    @Override
    public void initialize(){
        addRequirements(s_DriveTrain);
    }

    @Override
    public void execute(){
        s_DriveTrain.arcadeDrive(speed, rotation);
    }

    @Override
    public void end(boolean interrupted){
        s_DriveTrain.arcadeDrive(0.0, 0.0);
    }
 
}
