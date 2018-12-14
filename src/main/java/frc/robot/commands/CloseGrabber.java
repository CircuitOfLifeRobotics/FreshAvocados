package frc.robot.commands;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Arm.GrabState;
import edu.wpi.first.wpilibj.command.Command;
public class CloseGrabber extends Command{
    Arm arm;
    
    protected void initialize(){
        arm = Arm.getInstance();
    }
    protected void execute() {
        arm.setGrabber(GrabState.CLOSED);
        arm.setFlywheels(-1);
        //Test4 green
    }
    
    protected boolean isFinished() {
        return false;
    }
}