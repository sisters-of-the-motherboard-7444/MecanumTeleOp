package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "MecanumTeleOp")

public class MecanumTeleOp extends LinearOpMode {

    HardwarePowerPlay pp = new HardwarePowerPlay();

    @Override
    public void runOpMode() throws InterruptedException {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        System.out.println("Initialize Robot");
        Legacy.InitializeRobot(hardwareMap);
        System.out.println("Robot Initialized");

        telemetry.addData("Status", "Ready!");

        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            double fwdBack = gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            if (gamepad1.start) {

                pp.frontLeft.setPower((fwdBack - 1.5 * strafe - turn) * .25);
                pp.backLeft.setPower((fwdBack + 1.5 * strafe - turn) * .25);
                pp.frontRight.setPower((-fwdBack - 1.5 * strafe - turn) * .25);
                pp.backRight.setPower((-fwdBack + 1.5 * strafe - turn) * .25);

            } else { // drive robot normally at full speed

                pp.frontRight.setPower((fwdBack - strafe - turn));
                pp.backRight.setPower((fwdBack + strafe - turn));
                pp.frontRight.setPower((-fwdBack - strafe - turn));
                pp.backRight.setPower((-fwdBack + strafe - turn));

            }



        }


    }
}





