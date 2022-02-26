package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase{
    private Shooter s_ShooterMotor;
    private double power;

    public Shoot(Shooter s_ShooterMotor, double power){
        this.s_ShooterMotor = s_ShooterMotor;
        this.power = power;
    }

    @Override
    public void initialize(){
        addRequirements(s_ShooterMotor);
    }

    @Override
    public void execute(){
        s_ShooterMotor.setPower(power);
       
    }

    @Override
    public void end(boolean interrupted){
        s_ShooterMotor.setPower(0);
    }
 
}
