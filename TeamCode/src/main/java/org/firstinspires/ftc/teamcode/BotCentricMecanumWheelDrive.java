package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.botclasses.Athena;

@TeleOp(name="Mecanum Drive", group="Bot Centric")
public class BotCentricMecanumWheelDrive extends LinearOpMode {
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


        while (opModeIsActive()) {
            // Gather sample game pad input data
            double y = Math.pow(-gamepad1.left_stick_y, 3);
            double x = Math.pow(gamepad1.left_stick_x, 3) * 1.1; // Multiplied by 1.1 to counter imperfect strafing
            double yaw = Math.pow(gamepad1.right_stick_x, 3);

            // Normalize the values so no wheel power exceeds 100%
            // This also ensures that the power ratios are preserved
            double max = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(yaw), 1);
            double leftFrontPower  = (y + x + yaw) / max;
            double rightFrontPower = (y - x - yaw) / max;
            double leftBackPower   = (y - x + yaw) / max;
            double rightBackPower  = (y + x - yaw) / max;

            // Set the wheel power to calculated values
            robot.leftFrontDrive.setPower(leftFrontPower);
            robot.rightFrontDrive.setPower(rightFrontPower);
            robot.leftBackDrive.setPower(leftBackPower);
            robot.rightBackDrive.setPower(rightBackPower);

            // Show the elapsed game time and wheel power in telemetry
            telemetry.addData("Runtime", robot.runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.update();
        }
    }
}
