package frc.robot.autos;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.*;


public class EncoderAuto extends SequentialCommandGroup{

    public EncoderAuto(DriveTrain m_driveTrain, Robot m_encoder){

        addCommands(
            new ParallelDeadlineGroup(
                new DriveCommand(m_driveTrain, () -> 0.7, () -> 0)
                
        )
    );


        
    }
    
}
