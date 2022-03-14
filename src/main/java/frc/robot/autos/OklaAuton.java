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

public class OklaAuton extends SequentialCommandGroup {

    public OklaAuton(DriveTrain m_driveTrain, Shooter m_Shooter, Deploy m_deploy) {

        addCommands(
            new ParallelDeadlineGroup( //First Shoot
                new WaitCommand(1.5),
                new Shoot(m_Shooter, 0.62)
            ),

            new ParallelDeadlineGroup( //Drive Backwards
                new WaitCommand(1.6),
                new DriveCommand(m_driveTrain, () -> 0.7, () ->  0)
            ),
            
            new ParallelDeadlineGroup( //Prepare Deploy
                new WaitCommand(2.24),
                new DriveCommand(m_driveTrain, () -> 0, () -> 0),
                new DeployControl(m_deploy, 0.7)
            )
        );
    }
}