package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.autos.OneBallAuto;
//import frc.robot.autos.EncoderAuto;
import frc.robot.autos.OklaAuton;
import frc.robot.autos.BayouAuton;
import frc.robot.autos.TwoBallAuto;
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
    private final JoystickButton intakeButton = new JoystickButton(operator, XboxController.Button.kA.value);
    private final JoystickButton reverseshooterButton = new JoystickButton(operator, XboxController.Button.kRightBumper.value);
    private final JoystickButton shooterButton2 = new JoystickButton(operator, XboxController.Button.kB.value);
    private final JoystickButton reverseintakeButton = new JoystickButton(operator, XboxController.Button.kLeftBumper.value);
    private final JoystickButton deployButton = new JoystickButton(operator, XboxController.Button.kX.value);
    private final JoystickButton deployButton2 = new JoystickButton(operator, XboxController.Button.kY.value);
    //private final int deploySpeed = XboxController.Axis.kRightY.value;

    /* Subsystems */
    public static DriveTrain m_driveTrain = new DriveTrain();
    private final DriveTrain m_autodriveTrain = new DriveTrain();
    private final ClimbMotor m_climber = new ClimbMotor();
    private final Intake m_Intake = new Intake();
    private final Shooter m_Shooter = new Shooter();
    private final Deploy m_deploy = new Deploy();
    //private final Encoders m_encoders = new Encoders();

    /* Auto Chooser */
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    /* Camera */
   // public static CameraInput m_cameraInput;

   /* Misc */

    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        m_driveTrain.setDefaultCommand(
            new TeleOPDrive(
                m_driveTrain,
                () -> driver.getRawAxis(drivetrainSpeed),
                () -> driver.getRawAxis(drivetrainRotation)
            )
        );

        m_climber.setDefaultCommand(
            new Climb(
                m_climber,
                () -> operator.getRawAxis(climbSpeed)
            )
        );
        
        /*m_deploy.setDefaultCommand(
            new DeployControl(
                m_deploy,
                () -> operator.getRawAxis(deploySpeed)
            )
        );*/

        /* Configure autos in sendable chooser */
        autoChooser.setDefaultOption("OneBallAuto", new OneBallAuto(m_driveTrain, m_Shooter, m_Intake, m_deploy));
        autoChooser.addOption("TwoBallAuto", new TwoBallAuto(m_driveTrain, m_Shooter, m_Intake, m_deploy));
        autoChooser.addOption("BayouAuto", new BayouAuton(m_driveTrain, m_Shooter, m_deploy, m_Intake));
        autoChooser.addOption("OklaAuton", new OklaAuton(m_driveTrain, m_Shooter, m_deploy));
      //  autoChooser.addOption("EncoderAuto", new EncoderAuto(m_driveTrain));
        SmartDashboard.putData(autoChooser);

        // Configure the button bindings
        configureButtonBindings();
    }
    
    private void configureButtonBindings() {
        intakeButton.whileHeld(new IntakeControl(m_Intake, 0.55));
        reverseshooterButton.whileHeld(new Shoot(m_Shooter, -0.75));
        shooterButton2.whileHeld(new Shoot(m_Shooter, 0.95));
        deployButton.whileHeld(new DeployControl(m_deploy, -0.7));
        deployButton2.whileHeld(new DeployControl(m_deploy, 0.85));
        reverseintakeButton.whileHeld(new IntakeControl(m_Intake, 0.55));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the coimmand to run in autonomous
     */
    public Command getAutonomousCommand() {
       return autoChooser.getSelected();
    }
}
