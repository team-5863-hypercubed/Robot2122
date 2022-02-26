package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeControl extends CommandBase{
    private Intake s_Intake;
    private double power;

    public IntakeControl(Intake s_Intake, double power){
        this.s_Intake = s_Intake;
        this.power = power;
    }

    @Override
    public void initialize(){
        addRequirements(s_Intake);
    }

    @Override
    public void execute(){
        s_Intake.setPower(power);
    }

    @Override
    public void end(boolean interrupted){
        s_Intake.setPower(0);
    }
 
}
