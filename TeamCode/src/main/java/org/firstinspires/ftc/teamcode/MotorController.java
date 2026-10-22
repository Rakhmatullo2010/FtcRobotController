package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MotorController {

    //----------

    private final DcMotor rightFront;
    private final DcMotor leftFront;
    private final DcMotor rightBack;
    private final DcMotor leftBack;

    //----------

    public MotorController(DcMotor rightFront, DcMotor leftFront, DcMotor rightBack, DcMotor leftBack) {
        this.rightFront = rightFront;
        this.leftFront = leftFront;
        this.rightBack = rightBack;
        this.leftBack = leftBack;
    }

    //----------

    public void stopMotor() {
        rightFront.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        leftBack.setPower(0);
    }

    public void forward(float power) {
        rightFront.setPower(power);
        leftFront.setPower(power);
        rightBack.setPower(power);
        leftBack.setPower(power);
    }

    public void backward(float power) {
        rightFront.setPower(-power);
        leftFront.setPower(-power);
        rightBack.setPower(-power);
        leftBack.setPower(-power);
    }

    public void turnRight(float power) {
        rightFront.setPower(-power);
        leftFront.setPower(power);
        rightBack.setPower(-power);
        leftBack.setPower(power);
    }

    public void turnLeft(float power) {
        rightFront.setPower(power);
        leftFront.setPower(-power);
        rightBack.setPower(power);
        leftBack.setPower(-power);
    }

    public void strafeRight(float power) {
        rightFront.setPower(-power);
        leftFront.setPower(power);
        rightBack.setPower(power);
        leftBack.setPower(-power);
    }

    public void strafeLeft(float power) {
        rightFront.setPower(power);
        leftFront.setPower(-power);
        rightBack.setPower(-power);
        leftBack.setPower(power);
    }

}
