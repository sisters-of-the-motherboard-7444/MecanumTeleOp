package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

// DECLARE TO YOUR ROBOT'S MOTORS
public class FILE_NAME extends LinearOpMode {
  //new RobotCentricDrive DriveSystem;
  //new FieldCentricDrive DriveSystem;
  public Servo DECLARE YOUR SERVOS EX: SERVO_NAME;
  public DcMotorEx motor, DECLARE YOUR MOTORS EX: MOTOR_NAME;

  // TUNING YOUR PID CONTROLLER
  PIDCONTROLLER CONTROLLER_NAME = new PIDCONTROLLER (0.005, 0, 0.0001);

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
    if (isStopRequested()) return;
    
    // DECLARE YOUR PID POSITIONS
    int POSITION_NAME = 0;
    
    while (opModeIsActive()) {

      // GIVE ACTIONS TO YOUR GAMEPAD'S BUTTONS
      if (gamepad1.x) { // ground
        SERVO_NAME.setPosition(0.04);
        PID_POSITION = POSITION_NAME;
      }
      else if (gamepad1.a) { // low score
        armRight.setPosition(0.75);
        armLeft.setPosition(0.25);
        wristServo.setPosition(1);
        slidesPosition = LOW_POSITION;
      }

      // GET UPDATES ON YOUR PID TO THE DRIVER HUB
      telemetry.addData("Left Slides", slidesLeft.getCurrentPosition());
      telemetry.addData("Right Slides", slidesRight.getCurrentPosition());
      telemetry.addData("Target Position", slidesPosition);

      double leftPower = leftPID.update(slidesPosition, slidesLeft.getCurrentPosition());
      double rightPower = rightPID.update(slidesPosition, slidesRight.getCurrentPosition());

      telemetry.addData("Left Power", leftPower);
      telemetry.update(); 

      CONTROLLER_NAME.setPower(leftPower);  
      
    }
  }
}
