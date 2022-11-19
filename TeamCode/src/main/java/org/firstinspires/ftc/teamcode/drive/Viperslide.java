package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Viperslide {
    // Declare all hardware map variables
    public DcMotorEx sliderMotor = null;

    public final static int HIGH = 0;
    public final static int MED = 0;
    public final static int LOW = 0;
    public final static int GROUND = 0;

    public Viperslide(HardwareMap hardwareMap) {
        // Initialize installed motors
        sliderMotor = hardwareMap.get(DcMotorEx.class, "sliderMotor");

        // Configure slider motor
        sliderMotor.setDirection(DcMotorEx.Direction.FORWARD);
        sliderMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        sliderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
