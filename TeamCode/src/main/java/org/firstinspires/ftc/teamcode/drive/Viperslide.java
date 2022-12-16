package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Viperslide {
    // Declare all hardware map variables
    public DcMotor sliderMotor = null;

    public enum Checkpoint {
        HIGH(3920), MED(2770), LOW(1870), GROUND(0);

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
        sliderMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sliderMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sliderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void runToHeight(Checkpoint point) {
        sliderMotor.setTargetPosition(point.getValue());
        sliderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sliderMotor.setPower(1.0);
    }

    public void manualControl(double input) {
        sliderMotor.setTargetPosition((int) (sliderMotor.getCurrentPosition() + (input * 10)));
        sliderMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sliderMotor.setPower(1.0);
    }
}
