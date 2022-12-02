package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ConeGate {
    // Declare all hardware map variables
    public Servo arm = null;

    // Declare all constant variables
    public final static double ARM_OPEN = 0.0;
    public final static double ARM_CLOSED = 1.0;

    public ConeGate(HardwareMap hardwareMap) {
        // Initialize installed servos
        arm = hardwareMap.get(Servo.class, "coneGateServo");
    }

    public void open() {
        arm.setPosition(ARM_OPEN);
    }

    public void close() {
        arm.setPosition(ARM_CLOSED);
    }
}
