package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.botclasses.Athena;


@TeleOp(name="Claw", group="Test")
public class ClawAttachment extends LinearOpMode {
    // Declare the bot class instance
    Athena robot = new Athena(hardwareMap);

    // Extract constant variables from bot class
    final double ARM_OPEN = robot.ARM_OPEN;
    final double ARM_CLOSED = robot.ARM_CLOSED;

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
            // Detect whether the A button is being pressed
            if (gamepad1.a) {
                // Toggle whether the arm is open or closed
                if (robot.arm.getPosition() == ARM_CLOSED) {
                    robot.arm.setPosition(ARM_OPEN);
                } else {
                    robot.arm.setPosition(ARM_CLOSED);
                }
            }

            // Show the elapsed game time and update arm position.
            telemetry.addData("Runtime", robot.runtime.toString());
            telemetry.addData("Arm", "%4.2f", robot.arm.getPosition());
            telemetry.update();
        }
    }}
