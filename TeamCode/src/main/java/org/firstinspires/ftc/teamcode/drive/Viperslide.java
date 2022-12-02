package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Viperslide {
    // Declare all hardware map variables
    public DcMotor sliderMotor = null;

    public final static int HIGH = 0;
    public final static int MED = 0;
    public final static int LOW = 0;
    public final static int GROUND = 0;

    public Viperslide(HardwareMap hardwareMap) {
        // Initialize installed hardware
        sliderMotor = hardwareMap.get(DcMotor.class, "sliderMotor");

        // Configure slider motor
        sliderMotor.setDirection(DcMotor.Direction.FORWARD);
        sliderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sliderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
