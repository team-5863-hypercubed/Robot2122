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
            new ParallelDeadlineGroup( //First Shoot
                new WaitCommand(1.5),
                new Shoot(m_Shooter, 0.65)
            ),

            new ParallelDeadlineGroup( //Drive Backwards
                new WaitCommand(1.2),
                new DriveCommand(m_driveTrain, () -> 0.7, () ->  0)
            ),

            new ParallelDeadlineGroup( // Rotate CCW
                new WaitCommand(0.635),
                new DriveCommand(m_driveTrain, () -> 0.0, () -> -0.7)
            ),

            new ParallelDeadlineGroup( //Stops for Robot's safety
                new WaitCommand(2.24),
                new DriveCommand(m_driveTrain, () -> 0, () -> 0),
                new DeployControl(m_deploy, -0.7)
            ),

            new ParallelDeadlineGroup( //Drive Forward
                new WaitCommand(1.2),
                new IntakeControl(m_Intake, -0.55),
                new DriveCommand(m_driveTrain, () -> -0.7,() ->  0)
            ),

            new ParallelDeadlineGroup( // Rotate CW
                new WaitCommand(1),
                new DriveCommand(m_driveTrain, () -> 0.0, () -> 0.7),
                new IntakeControl(m_Intake, -0.55),
                new Shoot(m_Shooter, 0.28)
            ),


            new ParallelDeadlineGroup( 
                new WaitCommand(1),
                new DriveCommand(m_driveTrain, () -> -0, () ->  0)
            ),

            new ParallelDeadlineGroup( 
                new WaitCommand(1),
                new DriveCommand(m_driveTrain, () -> -0.7, () ->  0)
            ),


            new ParallelDeadlineGroup(
                new WaitCommand(1.5),
                new Shoot(m_Shooter, 0.8),
                new DriveCommand(m_driveTrain, () -> -0, () ->  0)

            )
            
        );
    }
    
}




