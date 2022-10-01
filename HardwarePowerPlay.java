package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwarePowerPlay { //<crServo> {

    //Wheels
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor frontRight;
    public DcMotor backRight;


    int driveTime;


    //-------------------------------------Initialization----------------------

    public void InitializeRobot(HardwareMap hardwareMap) {
        HardwareMap HWMap = hardwareMap;

        //initialize motors

        leftFront = HWMap.dcMotor.get("frontLeft");
        leftBack = HWMap.dcMotor.get("backLeft");
        rightFront = HWMap.dcMotor.get("rightFront");
        rightBack = HWMap.dcMotor.get("rightBack");

    }


    //------------------------------------Basic Driving--------------------

    public void DriveStraight(double power, long totalSeconds, int Direction) throws InterruptedException {

        leftFront.setPower(power * Direction);
        leftBack.setPower(power * Direction);
        rightFront.setPower(power * -Direction);
        rightBack.setPower(power * -Direction);

        Thread.sleep(totalSeconds);

        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }

    public void DriveTurn(double power, long totalSeconds, int Direction) throws InterruptedException {
        leftFront.setPower(power * Direction);
        leftBack.setPower(power * Direction);
        rightFront.setPower(power * Direction);
        rightBack.setPower(power * Direction);

        Thread.sleep(totalSeconds);


        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }

    public void DriveSideways(double power, long totalSeconds,  int leftFrontDirection, int leftBackDirection, int rightFrontDirection, int rightBackDirection) throws InterruptedException {
        leftFront.setPower(power * leftFrontDirection);
        leftBack.setPower(power * leftBackDirection);
        rightFront.setPower(power * rightFrontDirection);
        rightBack.setPower(power * rightBackDirection);

        Thread.sleep(totalSeconds);
        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }

   // public void Outake(double power) {
    //    leftoutake.setPower(power);
    //    rightoutake.setPower(power);
    }




