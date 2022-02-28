package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DeployControl;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeControl;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Deploy;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class UpRedDownBlueAuto extends SequentialCommandGroup {

    public UpRedDownBlueAuto(DriveTrain m_driveTrain, Shooter m_Shooter, Intake m_Intake, Deploy m_deploy) {

        addCommands(
            new ParallelDeadlineGroup( //Shoot&Wait
              new WaitCommand(5.0),
              new Shoot(m_Shooter, 0.4)
            ),

            new ParallelDeadlineGroup( //Drive Backwards
                new WaitCommand(1.4),
                new IntakeControl(m_Intake, 0.4),
                new DeployControl(m_deploy, 0.3),
                new DriveCommand(m_driveTrain, 0.7, 0)
            ),

            new DriveCommand(m_driveTrain, 0, 0),

            new ParallelDeadlineGroup( // Rotate CCW
                new WaitCommand(0.65),
                new IntakeControl(m_Intake, 0.4),
                new DriveCommand(m_driveTrain, 0.0, -0.7)
            ),

            new DriveCommand(m_driveTrain, 0.0, 0.0),

            new ParallelDeadlineGroup( //Drive Forward
                new WaitCommand(0.85),
                new IntakeControl(m_Intake, 0.4),
                new DriveCommand(m_driveTrain, 0.7, 0)
            ),

            new DriveCommand(m_driveTrain, 0.0, 0.0),

            new ParallelDeadlineGroup( //Drive Backwards
                new WaitCommand(0.77),
                new IntakeControl(m_Intake, 0.4),
                new DriveCommand(m_driveTrain,0.7, 0.0)
            ),

            new DriveCommand(m_driveTrain, 0.0, 0.0),

            new ParallelDeadlineGroup( //Rotate CW
                new WaitCommand(0.65),
                new DriveCommand(m_driveTrain, 0.0, -0.7)
            ),

            new DriveCommand(m_driveTrain, 0.0, 0.0),

            new ParallelDeadlineGroup( //Drive Forward
                new WaitCommand(1.4),
                new DeployControl(m_deploy, -0.3),
                new DriveCommand(m_driveTrain,-0.7, 0)
            ),
            
            new DriveCommand(m_driveTrain, 0.0, 0.0),

            new ParallelDeadlineGroup( //Last Shoot
                new WaitCommand(5),
                new Shoot(m_Shooter, 0.4)
            )

        );
    }
    
}




