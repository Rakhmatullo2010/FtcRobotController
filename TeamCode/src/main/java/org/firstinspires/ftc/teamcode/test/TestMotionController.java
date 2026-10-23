package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestMotionController {

    //----------

    private DcMotor rightFront, leftFront, rightBack, leftBack;
    private DcMotor[] motors;

    public void init(HardwareMap hardwareMap) {
        rightFront = hardwareMap.get(DcMotor.class, "Right Front");
        leftFront = hardwareMap.get(DcMotor.class, "Left Front");
        rightBack = hardwareMap.get(DcMotor.class, "Right Back");
        leftBack = hardwareMap.get(DcMotor.class, "Left Back");

        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        motors = new DcMotor[] {rightFront, leftFront, rightBack, leftBack};

        for (DcMotor motor : motors) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    public void drive(float x, float y, float z) {

        float rightFrontPower = - x + y - z;
        float leftFrontPower  = x + y + z;
        float rightBackPower  = x + y - z;
        float leftBackPower   = - x + y + z;

        float max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));

        if (max > 1.0f) {
            leftFrontPower  /= max;
            rightFrontPower /= max;
            leftBackPower   /= max;
            rightBackPower  /= max;
        }

        leftFront.setPower(leftFrontPower);
        rightFront.setPower(rightFrontPower);
        leftBack.setPower(leftBackPower);
        rightBack.setPower(rightBackPower);
    }

    public void stopMotor() {
        for (DcMotor motor : motors)
            motor.setPower(0);
    }
}
