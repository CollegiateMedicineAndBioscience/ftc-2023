package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.Viperslide;


@TeleOp(name="Viperslide", group="test")
@Disabled
public class ViperslideAttachment extends LinearOpMode {
    @Override
    public void runOpMode() {
        ElapsedTime runtime = new ElapsedTime();

        // Declare the bot class instance
        Viperslide viperslide = new Viperslide(hardwareMap);

        // Add ready status to telemetry
        telemetry.addData(">", "Press PLAY to start");
        telemetry.update();

        // Wait for game start, abort if canceled
        waitForStart();
        if (isStopRequested()) return;

        // Reset runtime timer to 0
        runtime.reset();
        while (opModeIsActive()) {
            if (gamepad1.left_stick_y != 0) {
                viperslide.manualControl(-gamepad1.left_stick_y);
            }

            if (gamepad1.a) {
                viperslide.runToHeight(Viperslide.Checkpoint.LOW);
            }

            if (gamepad1.x) {
                viperslide.runToHeight(Viperslide.Checkpoint.MED);
            }

            if (gamepad1.y) {
                viperslide.runToHeight(Viperslide.Checkpoint.HIGH);
            }

            if (gamepad1.b) {
                viperslide.runToHeight(Viperslide.Checkpoint.GROUND);
            }

            // Show the elapsed game time and update arm position.
            telemetry.addData("Runtime", runtime.toString());
            telemetry.addData("Height", viperslide.sliderMotor.getCurrentPosition());
            telemetry.addData("Target Position", viperslide.sliderMotor.getTargetPosition());
            telemetry.update();
        }
    }}
