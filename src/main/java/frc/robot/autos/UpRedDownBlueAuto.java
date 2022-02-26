// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class UpRedDownBlueAuto extends CommandBase {
  private final DriveTrain m_driveTrain;

  double myStartTime;
  double myTime;
  boolean myAutonFinished = false;

  private Intake s_Intake;
  double power;

  /** Creates a new DownRedUpBlueAuto. */
  public UpRedDownBlueAuto(DriveTrain m_driveTrain, Intake s_Intake){
    this.m_driveTrain = m_driveTrain;
    

    this.s_Intake = s_Intake;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    addRequirements(s_Intake);
    addRequirements(m_driveTrain);

    myStartTime = System.currentTimeMillis();
    System.out.println("MyStartTime" +myStartTime);
    myTime = 0.0;
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  myTime = (System.currentTimeMillis() -myStartTime)/1000;

  while (myTime<= 5) { 
      
 m_driveTrain.arcadeDrive(0, 0);

}


  while (myTime<= 6.4) { 

  s_Intake.setPower(0.4);
  
 m_driveTrain.arcadeDrive(0.7, 0);

}

  m_driveTrain.arcadeDrive(0,0);


while (myTime<= 7.05) { 
  
 m_driveTrain.arcadeDrive(0, 0.7);


}

  while (myTime<= 7.9) { 


  m_driveTrain.arcadeDrive(-0.7, 0);

}

  m_driveTrain.arcadeDrive(0,0);


while (myTime<= 8.67) { 
  


 m_driveTrain.arcadeDrive(0.7, 0);

}

while (myTime<= 9.42) { 

  s_Intake.setPower(0);
  
 m_driveTrain.arcadeDrive(0, -0.7);

}

while (myTime<= 10.82) { 
  
 m_driveTrain.arcadeDrive(-0.7, 0);

}

while (myTime<= 15) { 
  
 m_driveTrain.arcadeDrive(0, 0);

}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
