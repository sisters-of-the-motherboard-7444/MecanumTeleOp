package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

// DECLARE TO YOUR ROBOT'S MOTORS
public class FILE_NAME extends LinearOpMode {
  public Servo DECLARE YOUR SERVOS EX: SERVO_NAME;
  public DcMotorEx motor, DECLARE YOUR MOTORS EX: MOTOR_NAME;
  
  // CONNECT TO YOUR ROBOT'S MOTORS
  @Override
  public void runOpMode() throws InterruptedException {
    CONNECT YOUR SERVO EX: SERVO_NAME = hardwareMap.servo.get("SERVO_NAME");
    CONNECT YOUR MOTOR EX: MOTOR_NAME = hardwareMap.get(DcMotorEx.class, "MOTOR_NAME");

    // SET YOUR MOTORS DIRECTION
    MOTOR_NAME.setDirection(DcMotorEx.Direction.REVERSE_OR_FORWARD);
    // WHAT DO YOUR MOTORS DO WHEN THERE IS NO POWER?
    MOTOR_NAME.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    // ARE THEY USING AN INTERNAL SENSOR?
    MOTOR_NAME.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    
    waitForStart();
    
    while (opModeIsActive()) {
      if (gamepad1.a) {
        MOTOR_NAME.setPower(-0.5);
        MOTOR_NAME.setPower(-0.5);
      }
      else if (gamepad1.x) {
        SERVO_NAME.setPosition(0);
        SERVO_NAME.setPosition(1);
      }    
    }
  }
}
