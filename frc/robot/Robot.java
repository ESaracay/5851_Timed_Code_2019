
package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;


import edu.wpi.first.wpilibj.Victor;


public class Robot extends TimedRobot {
    Joystick Danny = new Joystick(0); // port
    Joystick Simon = new Joystick(1);
// Drive System
    WPI_TalonSRX DRIVE_LF_MOTOR = new WPI_TalonSRX(13);
    WPI_TalonSRX DRIVE_LB_MOTOR = new WPI_TalonSRX(12);
    WPI_TalonSRX DRIVE_RF_MOTOR = new WPI_TalonSRX(10);
    WPI_TalonSRX DRIVE_RB_MOTOR = new WPI_TalonSRX(11);
    
    // Intake System
    Victor WRIST_MOTOR = new Victor(7);
    PWMVictorSPX Claw = new PWMVictorSPX(3);
    Victor Claw_Intake_Right = new Victor(2);
    Victor Claw_Intake_Left = new Victor(4);
// Lift System
    Victor Lift_FL_Motor = new Victor(0);
    Victor Lift_BL_Motor = new Victor(1);
    Victor Lift_FR_Motor = new Victor(5);
    Victor Lift_BR_Motor = new Victor(6);
    WPI_TalonSRX Lift_Sensor = new WPI_TalonSRX(14);


    @Override
    public void robotInit() {
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
      CameraServer.getInstance().startAutomaticCapture(camera);
      UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
      CameraServer.getInstance().startAutomaticCapture(camera2);
  // Initialize Feedback

  
   
    }

    @Override
    public void autonomousInit() {

    
    }

    @Override
    public void autonomousPeriodic() {
        double leftstick = Danny.getRawAxis(1);
        double rightstick = Danny.getRawAxis(5);
        double throttle = .75;
        double slow_throttle=.5;
       if(Danny.getRawButton(5)){
           DRIVE_LF_MOTOR.set(leftstick * slow_throttle);
           DRIVE_LB_MOTOR.set(leftstick * slow_throttle);
           DRIVE_RF_MOTOR.set(-rightstick * slow_throttle);
           DRIVE_RB_MOTOR.set(-rightstick * slow_throttle);
       }
       else {    
               DRIVE_LF_MOTOR.set(leftstick * throttle);
               DRIVE_LB_MOTOR.set(leftstick * throttle);
               DRIVE_RF_MOTOR.set(-rightstick * throttle);
               DRIVE_RB_MOTOR.set(-rightstick * throttle);
       }
       
               // Wrist
             double Wrist = Simon.getRawAxis(3);
               WRIST_MOTOR.set(-Wrist);
               //Claw Open and close
       
               if(Simon.getRawButton(8))
               {
                   Claw.setSpeed(-.5);
               }
               else
               {
                   if(Simon.getRawButton(7))
                   {
                       Claw.setSpeed(.5);
                   }
                   else
                   {
                       Claw.setSpeed(0);
                   }
               }
       
               // Claw Intakes
       
               if(Simon.getRawButton(6))
               {
                   Claw_Intake_Left.set(.75);
                   Claw_Intake_Right.set(-.75);
               }
               else
               {
                   if(Simon.getRawButton(5))
                   {
                       Claw_Intake_Left.set(-.75);
                       Claw_Intake_Right.set(.75);
                   }
                   else
                   {
                       Claw_Intake_Left.set(0);
                       Claw_Intake_Right.set(0);
                   }
               }
       
       
       
       
       
         if (Danny.getRawButton(2)) {
             Lift_FL_Motor.set(-.5);
             Lift_BL_Motor.set(-.5);
             Lift_FR_Motor.set(-.5);
             Lift_BR_Motor.set(-.5);
                  
               } else {
                   if (Danny.getRawButton(3)) {
                Lift_FL_Motor.set(.5);
               Lift_BL_Motor.set(.5);
               Lift_FR_Motor.set(.5);
               Lift_BR_Motor.set(.5);
            
             } 
                   else {
                       Lift_FL_Motor.set(0);
                       Lift_BL_Motor.set(0);
                       Lift_FR_Motor.set(0);
                       Lift_BR_Motor.set(0);
                   }
               }
       
           
    }

    

    @Override
    public void teleopPeriodic() {
 //double Lift_Pos= Lift_Sensor.getSelectedSensorPosition();
 double leftstick = Danny.getRawAxis(1);
 double rightstick = Danny.getRawAxis(5);
 double throttle = .75;
 double slow_throttle=.5;
if(Danny.getRawButton(5)){
    DRIVE_LF_MOTOR.set(leftstick * slow_throttle);
    DRIVE_LB_MOTOR.set(leftstick * slow_throttle);
    DRIVE_RF_MOTOR.set(-rightstick * slow_throttle);
    DRIVE_RB_MOTOR.set(-rightstick * slow_throttle);
}
else {    
        DRIVE_LF_MOTOR.set(leftstick * throttle);
        DRIVE_LB_MOTOR.set(leftstick * throttle);
        DRIVE_RF_MOTOR.set(-rightstick * throttle);
        DRIVE_RB_MOTOR.set(-rightstick * throttle);
}

        // Wrist
      double Wrist = Simon.getRawAxis(3);
        WRIST_MOTOR.set(-Wrist);
        //Claw Open and close

        if(Simon.getRawButton(8))
        {
            Claw.setSpeed(-.5);
        }
        else
        {
            if(Simon.getRawButton(7))
            {
                Claw.setSpeed(.5);
            }
            else
            {
                Claw.setSpeed(0);
            }
        }

        // Claw Intakes

        if(Simon.getRawButton(6))
        {
            Claw_Intake_Left.set(.75);
            Claw_Intake_Right.set(-.75);
        }
        else
        {
            if(Simon.getRawButton(5))
            {
                Claw_Intake_Left.set(-.75);
                Claw_Intake_Right.set(.75);
            }
            else
            {
                Claw_Intake_Left.set(0);
                Claw_Intake_Right.set(0);
            }
        }





  if (Danny.getRawButton(2)) {
      Lift_FL_Motor.set(-.5);
      Lift_BL_Motor.set(-.5);
      Lift_FR_Motor.set(-.5);
      Lift_BR_Motor.set(-.5);
           
        } else {
            if (Danny.getRawButton(3)) {
         Lift_FL_Motor.set(.5);
        Lift_BL_Motor.set(.5);
        Lift_FR_Motor.set(.5);
        Lift_BR_Motor.set(.5);
     
      } 
            else {
                Lift_FL_Motor.set(0);
                Lift_BL_Motor.set(0);
                Lift_FR_Motor.set(0);
                Lift_BR_Motor.set(0);
            }
        }

    }

    @Override
    public void testPeriodic() {
    }
}
