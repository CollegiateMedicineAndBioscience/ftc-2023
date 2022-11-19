package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class Intake {
    // Declare all hardware map variables
    public CRServo rightServo = null;
    public CRServo leftServo = null;
    public DigitalChannel limit = null;

    public Intake(HardwareMap hardwareMap) {
        // Initialize installed hardware
        rightServo = hardwareMap.get(CRServo.class, "rightIntake");
        leftServo = hardwareMap.get(CRServo.class, "leftIntake");
        limit = hardwareMap.get(DigitalChannel.class, "intakeLimit");

        rightServo.setDirection(CRServo.Direction.FORWARD);
        leftServo.setDirection(CRServo.Direction.REVERSE);
    }
}
