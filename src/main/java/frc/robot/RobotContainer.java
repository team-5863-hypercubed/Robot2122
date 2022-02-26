package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.autos.DownRedUpBlueAuto;
import frc.robot.autos.UpRedDownBlueAuto;
import frc.robot.commands.Climb;
import frc.robot.commands.TeleOPDrive;
import frc.robot.commands.Shoot;
import frc.robot.commands.DeployControl;
import frc.robot.subsystems.*;
import frc.robot.commands.IntakeControl;


public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final Joystick operator = new Joystick(1);

    /* Driver Controls */
    private final int drivetrainSpeed = XboxController.Axis.kLeftY.value;
    private final int drivetrainRotation = XboxController.Axis.kLeftX.value;

    /* Operator Controls */
    private final int climbSpeed = XboxController.Axis.kLeftY.value;
    private final JoystickButton intakeButton = new JoystickButton(operator, XboxController.Button.kB.value);
    private final JoystickButton shooterButton = new JoystickButton(operator, XboxController.Button.kA.value);
    private final int deploySpeed = XboxController.Axis.kRightY.value;

    /* Subsystems */
    private final DriveTrain m_driveTrain = new DriveTrain();
    private final ClimbMotor m_climber = new ClimbMotor();
    private final Intake m_Intake = new Intake();
    private final Shooter m_Shooter = new Shooter();
    private final Deploy m_deploy = new Deploy();


    /* Auto Chooser */
    SendableChooser<Command> autoChooser = new SendableChooser<>();
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        m_driveTrain.setDefaultCommand(
            new TeleOPDrive(
                m_driveTrain,
                () -> -driver.getRawAxis(drivetrainSpeed),
                () -> -driver.getRawAxis(drivetrainRotation)
            )
        );

        m_climber.setDefaultCommand(
            new Climb(
                m_climber,
                () -> operator.getRawAxis(climbSpeed)
            )
        );

        m_deploy.setDefaultCommand(
            new DeployControl(
                m_deploy,
                () -> operator.getRawAxis(deploySpeed)
            )
        );

        /* Configure autos in sendable chooser */
        autoChooser.setDefaultOption("DownRedUpBlue", new DownRedUpBlueAuto(m_driveTrain, m_Shooter, m_Intake));
        autoChooser.addOption("UpRedDownBlueAuto", new UpRedDownBlueAuto(m_driveTrain, m_Intake));
        SmartDashboard.putData(autoChooser);

        // Configure the button bindings
        configureButtonBindings();
    }
    
    private void configureButtonBindings() {
        intakeButton.whileHeld(new IntakeControl(m_Intake, 0.32));
        shooterButton.whileHeld(new Shoot(m_Shooter, 0.3));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}