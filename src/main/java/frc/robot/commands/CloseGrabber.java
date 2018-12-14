package frc.robot.commands;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Arm.GrabState;
import frc.robot.OI;

import java.lang.Thread.State;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
public class CloseGrabber extends Command{
    Arm arm;
    
    protected void initialize(){
        arm = Arm.getInstance();
    }
    protected void execute() {
        arm.setGrabber(GrabState.CLOSED);
        arm.setFlywheels(-1);
        //Test4 blue
    }
    
    protected boolean isFinished() {
        return false;
    }
}