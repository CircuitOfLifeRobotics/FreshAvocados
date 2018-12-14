/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.OpenGrabbers;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private Joystick xbox;
  private Joystick wheel;
  private Joystick stick;
  private JoystickButton grabber;
  private OI(){

    xbox = new Joystick(RobotMap.XBOX);
    wheel = new Joystick(RobotMap.WHEEL);
    stick = new Joystick(RobotMap.STICK);

    grabber = new JoystickButton(xbox, RobotMap.GRABBER_BUTTON);
    this.grabber.whenPressed(new OpenGrabbers());

  }

  private static OI instance;
  public static OI getInstance(){

    if(instance == null){
      instance = new OI();
  }
  return instance;
  
  }
  public double getWheel(){
    return wheel.getRawAxis(0);

  }
  public double getStick(){
    return stick.getRawAxis(0);
  }
}

