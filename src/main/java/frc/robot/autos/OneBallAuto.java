package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DeployControl;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeControl;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Deploy;

public class OneBallAuto extends SequentialCommandGroup {

    public OneBallAuto(DriveTrain m_driveTrain, Shooter m_Shooter, Intake m_Intake, Deploy m_deploy) {

        addCommands(
            new ParallelDeadlineGroup( 
                new WaitCommand(1),
                new DriveCommand(m_driveTrain, ()-> 0, ()-> 0.7)
            )

               
        );
    }
    
}




