package frc.robot.commands;
import frc.robot.subsystems.ClimbMotor;

import java.util.function.DoubleSupplier;

//import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Climb extends CommandBase {
    private final ClimbMotor m_climber;

    DoubleSupplier speed;
 
    public Climb(ClimbMotor m_climber, DoubleSupplier climbSpeed){    
        this.m_climber = m_climber;
        addRequirements(m_climber);

        this.speed = climbSpeed;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_climber.armRaise(speed.getAsDouble());
    }
}
