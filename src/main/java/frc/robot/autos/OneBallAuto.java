package frc.robot.autos;

import java.util.function.BooleanSupplier;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.commands.DeployControl;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeControl;
import frc.robot.commands.LimeDrive;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.limeMaster;
import frc.robot.subsystems.Deploy;

public class OneBallAuto extends SequentialCommandGroup {


    public OneBallAuto(DriveTrain m_driveTrain, limeMaster m_limelight, Shooter m_Shooter, Intake m_Intake, Deploy m_deploy){
      

        addCommands(

            new ParallelDeadlineGroup( //Prepare Deploy
                new WaitCommand(2.24),
                new DriveCommand(m_driveTrain, () -> 0, () -> 0),
                new DeployControl(m_deploy, -0.7)
            ),

            new ParallelDeadlineGroup(
                new WaitCommand(2),
                new LimeDrive(() -> -0.6, () -> 0, m_limelight, m_driveTrain),
                new IntakeControl(m_Intake, 0.55)
            ),

            new ParallelDeadlineGroup(
                new WaitCommand(5),
                new LimeDrive(() -> 0, () -> 0.5, m_limelight, m_driveTrain)
            ),

            new ParallelDeadlineGroup(
                new WaitCommand(8),
                new LimeDrive(() -> 0, () -> 0, m_limelight, m_driveTrain)
            ),

            new ParallelDeadlineGroup(
                new WaitCommand(0.1),
                new DriveCommand(m_driveTrain, () -> 0, () -> -0.6)
            ),

            new ParallelDeadlineGroup(
                new WaitCommand(3),
                new LimeDrive(() -> 0, () -> 0, m_limelight, m_driveTrain),
                new Shoot(m_Shooter, 0.98),
                new IntakeControl(m_Intake, 0.5)

            )



           /* new ParallelDeadlineGroup( //shoot!
                new WaitCommand(1),
                new Shoot(m_Shooter, 0.93),
                new LimeDrive(m_driveTrain, () -> 0, () -> 0)
            )*/

        );
    }
    
}




