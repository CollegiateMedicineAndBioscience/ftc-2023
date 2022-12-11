package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Viperslide {
    // Declare all hardware map variables
    public DcMotor sliderMotor = null;

    public enum Checkpoint {
        HIGH(4000), MED(3000), LOW(2000), GROUND(1000);

        private int height;

        Checkpoint(int height) {
            this.height = height;
        }

        public int getValue() {
            return height;
        }
    }

    public Viperslide(HardwareMap hardwareMap) {
        // Initialize installed hardware
        sliderMotor = hardwareMap.get(DcMotor.class, "sliderMotor");

        // Configure slider motor
        sliderMotor.setDirection(DcMotor.Direction.FORWARD);
        sliderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        sliderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sliderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void runToHeight(Checkpoint point) {
        sliderMotor.setTargetPosition(point.getValue());
        sliderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sliderMotor.setPower(1.0);
    }

    public void manualControl(double input) {
        sliderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        sliderMotor.setPower(input);
    }
}
