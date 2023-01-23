package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.Intake;


@TeleOp(name="Intake", group="test")
@Disabled
public class IntakeAttachment extends LinearOpMode {
    @Override
    public void runOpMode() {
        ElapsedTime runtime = new ElapsedTime();

        // Declare the bot class instance
        Intake intake = new Intake(hardwareMap);

        // Add ready status to telemetry
        telemetry.addData(">", "Press PLAY to start");
        telemetry.update();

        // Wait for game start, abort if canceled
        waitForStart();
        if (isStopRequested()) return;

        // Reset runtime timer to 0
        runtime.reset();

        while (opModeIsActive()) {
            if (gamepad1.left_trigger > 0) {
                intake.intake();
            } else if (gamepad1.right_trigger > 0) {
                intake.outtake();
            } else {
                intake.off();
            }

            // Show the elapsed game time and update arm position.
            telemetry.addData("Runtime", runtime.toString());
            telemetry.addData("Intake", intake.servo.getPower());
            telemetry.update();
        }
    }}
