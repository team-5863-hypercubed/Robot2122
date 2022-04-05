package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DeployControl;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeControl;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Deploy;
import frc.robot.subsystems.Intake;

public class BayouAuton extends SequentialCommandGroup {

    public BayouAuton(DriveTrain m_driveTrain, Shooter m_Shooter, Deploy m_deploy, Intake m_Intake) {

        addCommands(
            new ParallelDeadlineGroup( //First Shoot
                new WaitCommand(1.5),
                new Shoot(m_Shooter, 0.62)
            ),

            new ParallelDeadlineGroup( //Drive Backwards
                new WaitCommand(1.1),
                new DriveCommand(m_driveTrain, () -> 0.7, () ->  0)
            ),

            new ParallelDeadlineGroup( //Drive Backwards
                new WaitCommand(0.5),
                new DriveCommand(m_driveTrain, () -> 0, () ->  0)
            ),

            new ParallelDeadlineGroup( // Rotate CCW
                new WaitCommand(0.52),
                new DriveCommand(m_driveTrain, () -> 0.0, () -> 0.7)
            ),

          /*  new ParallelDeadlineGroup( //Prepare Deploy
                new WaitCommand(2.24),
                new DriveCommand(m_driveTrain, () -> 0, () -> 0),
                new DeployControl(m_deploy, 0.7)
            ),*/

            new ParallelDeadlineGroup( //Prepare Deploy
                new WaitCommand(2.24),
                new DriveCommand(m_driveTrain, () -> 0, () -> 0)
            ),

            new ParallelDeadlineGroup( // Intake and drive
                new WaitCommand(0.6),
                new DriveCommand(m_driveTrain, () -> -0.7,() ->  0)

            ),

            new ParallelDeadlineGroup( // Intake and drive
                new WaitCommand(2),
                new IntakeControl(m_Intake, -0.6),
                new DriveCommand(m_driveTrain, () -> -0.4,() ->  0)
            ),

            new ParallelDeadlineGroup( //Drive Backwards
                new WaitCommand(0.5),
                new DriveCommand(m_driveTrain, () -> 0, () ->  0)
        ),


            new ParallelDeadlineGroup( // Rotate CW
                new WaitCommand(0.66),
                new DriveCommand(m_driveTrain, () -> 0.0, () -> -0.7)
            ),

            new ParallelDeadlineGroup( //Drive Forward
                new WaitCommand(1.3),
                new DriveCommand(m_driveTrain, () -> -0.7,() ->  0)
            ),

            new ParallelDeadlineGroup( //First Shoot
                new WaitCommand(1.5),
                new DriveCommand(m_driveTrain, () -> 0,() ->  0),
                new Shoot(m_Shooter, 0.7)
            )

        );
    }
}