package frc.robot.autos;


import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Robot;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.*;


public class EncoderAuto extends SequentialCommandGroup{
    

    public EncoderAuto(DriveTrain m_driveTrain, DoubleSupplier Position){
        
        addCommands(
            new ParallelDeadlineGroup(
                
                 new DriveCommand(m_driveTrain, () -> 0.7, () -> 0)
                       
        )
    );


        
    }
    
}
