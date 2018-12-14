package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Arm extends Subsystem{

    public static enum GrabState{
        OPEN, CLOSED, UNKNOWN

    }

    private DoubleSolenoid rightGrab;
    private DoubleSolenoid rightSpring;
    private DoubleSolenoid leftGrab;
    private DoubleSolenoid leftSpring;
   

    private WPI_TalonSRX rightWheel;
    private WPI_TalonSRX leftWheel;
    
    private Arm(){
        rightGrab = new DoubleSolenoid(RobotMap.GRAB_SOLENOID_FORWARD, RobotMap.GRAB_SOLENOID_REVERSE);
        rightSpring = new DoubleSolenoid(RobotMap.SPRING_SOLENOID_FORWARD, RobotMap.SPRING_SOLENOID_REVERSE);
        leftGrab = new DoubleSolenoid(RobotMap.GRAB_SOLENOID_FORWARD, RobotMap.GRAB_SOLENOID_REVERSE);
        leftSpring = new DoubleSolenoid(RobotMap.SPRING_SOLENOID_FORWARD, RobotMap.SPRING_SOLENOID_REVERSE);
        
        rightWheel = new WPI_TalonSRX(RobotMap.RIGHT_WHEEL);
        leftWheel = new WPI_TalonSRX(RobotMap.LEFT_WHEEL);

        leftWheel.setInverted(true);
    }   

    private static Arm instance;
    public static Arm getInstance(){

    if(instance == null) {

        instance = new Arm(); 
    }
        return instance;
    }
    
    public void setGrabber(GrabState state){
        if(state != GrabState.UNKNOWN){
        switch(state){
            case OPEN:
            rightGrab.set(Value.kReverse);
            rightSpring.set(Value.kReverse);
            leftGrab.set(Value.kReverse);
            leftSpring.set(Value.kReverse);
            break;
            case CLOSED:
            rightGrab.set(Value.kForward);
            rightSpring.set(Value.kForward);
            leftGrab.set(Value.kForward);
            leftSpring.set(Value.kForward);
            break;
            default:
            rightGrab.set(Value.kForward);
            rightSpring.set(Value.kForward);
            leftGrab.set(Value.kForward);
            leftSpring.set(Value.kForward);
            break;
            }
        }
    }

    public void setFlywheels(double speed){
        leftWheel.set(ControlMode.PercentOutput, speed);
        rightWheel.set(ControlMode.PercentOutput, speed);
    }

    protected void initDefaultCommand() {

    }
    
}