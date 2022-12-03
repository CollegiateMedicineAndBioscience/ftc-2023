package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.util.SleeveDetection;
import org.firstinspires.ftc.teamcode.util.SleeveDetection.ParkingPosition;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous(name="Color Detect Left")
public class ColorDetectLeft extends LinearOpMode {
    @Override
    public void runOpMode() {
        ElapsedTime runtime = new ElapsedTime();

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "front-cam"), cameraMonitorViewId);
        SleeveDetection sleeveDetection = new SleeveDetection();
        camera.setPipeline(sleeveDetection);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(320,240, OpenCvCameraRotation.SIDEWAYS_LEFT);
            }

            @Override
            public void onError(int errorCode) {}
        });

        ParkingPosition parkingPosition = sleeveDetection.getPosition();

        Pose2d startPose = new Pose2d(-34.5, -64, Math.toRadians(90));
        drive.setPoseEstimate(startPose);

        TrajectorySequence leftTraj = drive.trajectorySequenceBuilder(startPose)
                .forward(52)
                .strafeLeft(22)
                .build();

        TrajectorySequence centerTraj = drive.trajectorySequenceBuilder(new Pose2d(34.5, -64, Math.toRadians(90)))
                .forward(52)
                .build();

        TrajectorySequence rightTraj = drive.trajectorySequenceBuilder(new Pose2d(34.5, -64, Math.toRadians(90)))
                .forward(52)
                .strafeRight(22)
                .build();

        while (!isStarted()) {
            parkingPosition = sleeveDetection.getPosition();
            telemetry.addData("Parking Position ", parkingPosition);
            telemetry.addData("> ", "Press PLAY to start");
            telemetry.update();
        }

        // Wait for game start, abort if canceled
        waitForStart();
        if (isStopRequested()) return;

        // Reset runtime timer to 0
        runtime.reset();

        switch (parkingPosition) {
            case LEFT:
                drive.followTrajectorySequence(leftTraj);
                break;
            case RIGHT:
                drive.followTrajectorySequence(rightTraj);
                break;
            default:
                drive.followTrajectorySequence(centerTraj);
                break;
        }
    }
}