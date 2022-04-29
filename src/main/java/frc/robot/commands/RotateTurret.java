package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.limeMaster;

public class RotateTurret extends CommandBase{
    private final Turret m_turret;
    private final limeMaster m_limelight;
    DoubleSupplier turn;

    public RotateTurret(Turret m_turret, limeMaster m_limelight, DoubleSupplier turn){
        this.m_turret = m_turret;
        this.m_limelight = m_limelight;

        this.turn = turn;
  
        addRequirements(m_turret);
    }

    @Override
    public void execute(){
        m_turret.turret.set(ControlMode.PercentOutput, turn);
    

        double kp = .0256;
        double zrot = turn.getAsDouble();

        if (m_limelight.getIsTargetFound()){
            zrot = m_limelight.getdegRotationToTarget() * kp;
          }else{
            zrot = turn.getAsDouble();
          
      }
         
}

    @Override
    public void end(boolean interrupted){
        m_turret.turret.set(ControlMode.Position, 0);
    }

}
