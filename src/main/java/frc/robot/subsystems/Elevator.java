package frc.robot.subsystems;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.utils.CTREControllerFactory;
import frc.robot.RobotMap;






public class Elevator extends Subsystem{

    private WPI_TalonSRX rightElevatorMaster;
    private WPI_TalonSRX rightElevatorSlave;
    private WPI_TalonSRX leftElevatorMaster;
    
    public enum ElevatorState{
        BOTTOM, SWITCH, BOTTOM_SCALE, SCALE, TOP_SCALE, TOP, UNKNOWN
    }
    
    private Elevator(){
        rightElevatorMaster = new WPI_TalonSRX(RobotMap.RIGHT_ELEVATOR_MASTER);
        leftElevatorMaster =new WPI_TalonSRX(RobotMap.LEFT_ELEVATOR_MASTER);
    }

    public void setSpeed(int lspeed, int rspeed){
        rightElevatorMaster.set(ControlMode.PercentOutput,rspeed);
        leftElevatorMaster.set(ControlMode.PercentOutput,lspeed);
    }

    public void setState( ElevatorState state){
        if(state != state.UNKNOWN){
            case BOTTOM:
            rightElevatorMaster.set(1);
            leftElevatorMaster.set(1);
            break
            case SWITCH:
            rightElevatorMaster.set(1);
            leftElevatorMaster.set(1);
            break
            case BOTTOM_SCALE:
            rightElevatorMaster.set(1);
            leftElevatorMaster.set(1);
            break
            case SCALE:
            rightElevatorMaster.set(1);
            leftElevatorMaster.set(1);
            break
            case TOP_SCALE:
            rightElevatorMaster.set(1);
            leftElevatorMaster.set(1);
            break
            case BOTTOM:
            rightElevatorMaster.set(1);
            leftElevatorMaster.set(1);
            break
        }else{
            System.out.println("Elevator state is unknown");
        }
    }




    protected void initDefaultCommand() {

    }

}