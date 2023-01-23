package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.ConeGate;


@TeleOp(name="Claw", group="test")
@Disabled
public class ClawAttachment extends LinearOpMode {
    @Override
    public void runOpMode() {
        ElapsedTime runtime = new ElapsedTime();

        // Declare the bot class instance
        ConeGate coneGate = new ConeGate(hardwareMap);

        // Add ready status to telemetry
        telemetry.addData(">", "Press PLAY to start");
        telemetry.update();

        // Wait for game start, abort if canceled
        waitForStart();
        if (isStopRequested()) return;

        // Reset runtime timer to 0
        runtime.reset();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                coneGate.open();
            }
            if (gamepad1.b) {
                coneGate.close();
            }

            // Show the elapsed game time and update arm position.
            telemetry.addData("Runtime", runtime.toString());
            telemetry.addData("Arm", "%4.2f", coneGate.arm.getPosition());
            telemetry.update();
        }
    }}
