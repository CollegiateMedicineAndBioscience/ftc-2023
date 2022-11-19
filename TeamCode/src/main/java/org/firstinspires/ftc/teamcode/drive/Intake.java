package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class Intake {
    // Declare all hardware map variables
    public CRServo arm = null;
    DigitalChannel intakeSwitch = null;

    public Intake(HardwareMap hardwareMap) {
        // Initialize installed hardware
        arm = hardwareMap.get(CRServo.class, "intakeServo");
        intakeSwitch = hardwareMap.get(DigitalChannel.class, "intakeLimit");
    }
}
