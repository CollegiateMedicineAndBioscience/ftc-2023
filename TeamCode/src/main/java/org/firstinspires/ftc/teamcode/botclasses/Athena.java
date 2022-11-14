package org.firstinspires.ftc.teamcode.botclasses;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Athena {
    // Declare all hardware map variables
    public DcMotor leftFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor rightBackDrive = null;
    public Servo arm = null;
    public BNO055IMU imu = null;

    // Declare all constant variables
    public final static double ARM_OPEN = 0.0;
    public final static double ARM_CLOSED = 1.0;

    // Declare bot runtime object
    public ElapsedTime runtime = new ElapsedTime();

    public Athena(HardwareMap hardwareMap) {
        // Initialize installed motors
        leftFrontDrive  = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        leftBackDrive  = hardwareMap.get(DcMotor.class, "leftBackDrive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "rightBackDrive");

        // Set the direction of the motors to all be counter clockwise
        // These should be changed so that all motors move forwards
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);

        // Retrieve the IMU from the hardware map
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        // Set the IMU to use radians for measurement
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        // Initialize the IMU for reading data
        imu.initialize(parameters);

        // Initialize installed servos
        arm = hardwareMap.get(Servo.class, "coneGateServo");
    }
}
