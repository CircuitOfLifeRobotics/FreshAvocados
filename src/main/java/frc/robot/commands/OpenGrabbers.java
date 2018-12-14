package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Arm.GrabState;


public class OpenGrabbers extends Command{
    Arm arm;
    protected void initialize(){
        arm = Arm.getInstance();
    }
    protected void execute(){
        arm.setGrabber(GrabState.OPEN);
        arm.setFlywheels(-.25);
    }

    protected boolean isFinished() {
        return true;
    }
}