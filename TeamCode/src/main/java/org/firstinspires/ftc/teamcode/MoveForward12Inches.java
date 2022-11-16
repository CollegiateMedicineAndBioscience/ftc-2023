package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.botclasses.Athena;

@Autonomous
public class MoveForward12Inches extends LinearOpMode {
    // Declare the bot class instance
    Athena robot = new Athena(hardwareMap);

    @Override
    public void runOpMode() {
        // Add ready status to telemetry
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for game start, abort if canceled
        waitForStart();
        if (isStopRequested()) return;

        // Reset runtime timer to 0
        robot.runtime.reset();

        robot.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double rotationsNeeded = 12 / (3.14 * robot.WHEEL_DIAMETER);
        int encoderTarget = (int) (rotationsNeeded * robot.MOTOR_TICK_COUNTS);

        robot.leftBackDrive.setTargetPosition(encoderTarget);
        robot.leftFrontDrive.setTargetPosition(encoderTarget);
        robot.rightBackDrive.setTargetPosition(encoderTarget);
        robot.rightFrontDrive.setTargetPosition(encoderTarget);

        robot.leftBackDrive.setPower(0.5);
        robot.leftFrontDrive.setPower(0.5);
        robot.rightBackDrive.setPower(0.5);
        robot.rightFrontDrive.setPower(0.5);

        robot.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (robot.leftBackDrive.isBusy() || robot.leftFrontDrive.isBusy() || robot.rightFrontDrive.isBusy() || robot.rightBackDrive.isBusy()) {
            telemetry.addData("Path", "Driving 12 inches");
            telemetry.update();
        }

        robot.leftBackDrive.setPower(0);
        robot.leftFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        robot.rightFrontDrive.setPower(0);
    }
}
