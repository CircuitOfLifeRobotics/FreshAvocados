package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;

public class DriveManual extends Command{
    private Drivetrain drivetrain;
    OI oi;
    protected void initialize(){
        drivetrain = Drivetrain.getInstance();
        oi = OI.getInstance();
    }

    protected void execute(){
        drivetrain.drive(oi.getStick() + oi.getWheel(), oi.getStick() - oi.getWheel());
    }
    
    protected boolean isFinished() {
        return false;
    }
}