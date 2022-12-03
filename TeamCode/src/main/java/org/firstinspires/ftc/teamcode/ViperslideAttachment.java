package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.Viperslide;


@TeleOp(name="Viperslide", group="Test")
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
            double leftY = -gamepad1.left_stick_y;


            if (gamepad1.left_bumper) {
                viperslide.sliderMotor.setPower(leftY / 2);
            } else {
                viperslide.sliderMotor.setPower(leftY);
            }

//            if (gamepad1.a) {
//                viperslide.sliderMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                viperslide.sliderMotor.setTargetPosition(viperslide.HIGH);
//                viperslide.sliderMotor.setPower(1);
//            }
//
//            if (gamepad1.b) {
//                viperslide.sliderMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                viperslide.sliderMotor.setTargetPosition(viperslide.MED);
//                viperslide.sliderMotor.setPower(1);
//            }
//
//            if (gamepad1.x) {
//                viperslide.sliderMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                viperslide.sliderMotor.setTargetPosition(viperslide.LOW);
//                viperslide.sliderMotor.setPower(1);
//            }
//
//            if (gamepad1.y) {
//                viperslide.sliderMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                viperslide.sliderMotor.setTargetPosition(viperslide.GROUND);
//                viperslide.sliderMotor.setPower(1);
//            }

            // Show the elapsed game time and update arm position.
            telemetry.addData("Runtime", runtime.toString());
            telemetry.addData("Height", viperslide.sliderMotor.getCurrentPosition());
            telemetry.update();
        }
    }}
