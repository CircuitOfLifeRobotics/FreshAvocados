package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.utils.CTREControllerFactory;
import frc.robot.RobotMap;

public class Drivetrain extends Subsystem{
    public WPI_TalonSRX leftMaster;
    public WPI_TalonSRX leftSlaveA;
    public WPI_TalonSRX leftSlaveB;
    public WPI_TalonSRX rightMaster;
    public WPI_TalonSRX rightSlaveA;
    public WPI_TalonSRX rightSlaveB;

    private Drivetrain() {
        leftMaster = CTREControllerFactory.createDefaultTalon(RobotMap.LEFT_MASTER);
        leftSlaveA = CTREControllerFactory.createPermanentSlaveTalon(RobotMap.LEFT_SLAVE_A, leftMaster);
        leftSlaveB = CTREControllerFactory.createPermanentSlaveTalon(RobotMap.LEFT_SLAVE_B, leftMaster);
        rightMaster = CTREControllerFactory.createDefaultTalon(RobotMap.RIGHT_MASTER);
        rightSlaveA = CTREControllerFactory.createPermanentSlaveTalon(RobotMap.RIGHT_SLAVE_A, rightMaster);
        rightSlaveB = CTREControllerFactory.createPermanentSlaveTalon(RobotMap.RIGHT_SLAVE_B, rightMaster);

        leftMaster.setInverted(true);
    } 
    private static Drivetrain instance;
    public static Drivetrain getInstance(){
        if(instance == null){
            instance = new Drivetrain();
        }
        return instance;
    }
    public void drive(double lSpeed, double rSpeed) {
        leftMaster.set(ControlMode.PercentOutput, lSpeed);
        rightMaster.set(ControlMode.PercentOutput, rSpeed);
    }

    protected void initDefaultCommand() {

	}
}
