package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.drive.ConeGate;
import org.firstinspires.ftc.teamcode.util.PoseStorage;

@TeleOp(name="DC Mecanum Drive Claw", group="driver centric")
public class DCMecanumDriveClaw extends LinearOpMode {
    @Override
    public void runOpMode() {
        ElapsedTime runtime = new ElapsedTime();

        // Initialize the hardware
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        ConeGate intake = new ConeGate(hardwareMap);

        // Turn off velocity control for teleop
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Load pose from autonomous
        drive.setPoseEstimate(drive.getPoseEstimate());

        // Add ready status to telemetry
        telemetry.addData(">", "Press PLAY to start");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        runtime.reset();
        while (opModeIsActive() && !isStopRequested()) {
            float xInput = -gamepad1.left_stick_x;
            float yInput = -gamepad1.left_stick_y;
            float rotInput = -gamepad1.right_stick_x;

            if (gamepad1.right_bumper || gamepad1.left_bumper) {
                xInput /= 2;
                yInput /= 2;
                rotInput /= 2;
            }

            Pose2d poseEstimate = drive.getPoseEstimate();

            Vector2d input = new Vector2d(
                    yInput,
                    xInput
            ).rotated(-poseEstimate.getHeading());

            drive.setWeightedDrivePower(
                    new Pose2d(
                            input.getX(),
                            input.getY(),
                            rotInput
                    )
            );

            // Update drive parameters
            drive.update();

            if (gamepad1.a) {
                intake.open();
            }

            if (gamepad1.b) {
                intake.close();
            }

            // Print pose to telemetry
            telemetry.addData("Runtime", runtime.toString());
            telemetry.addData("X", poseEstimate.getX());
            telemetry.addData("Y", poseEstimate.getY());
            telemetry.addData("Heading", poseEstimate.getHeading());
            telemetry.addData("Intake", "4.2f", intake.arm.getPosition());
            telemetry.update();
        }
    }
}
