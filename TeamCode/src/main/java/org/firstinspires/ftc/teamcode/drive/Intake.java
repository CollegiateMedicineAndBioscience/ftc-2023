package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class Intake {
    // Declare all hardware map variables
    public CRServo servo = null;
    public DigitalChannel limit = null;

    public Intake(HardwareMap hardwareMap) {
        // Initialize installed hardware
        servo = hardwareMap.get(CRServo.class, "intakeServo");
        limit = hardwareMap.get(DigitalChannel.class, "intakeLimit");

        servo.setDirection(CRServo.Direction.FORWARD);
    }
}
