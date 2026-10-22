package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TutorialOpMode")
public class TutorialTeleOp extends OpMode {

    //----------

    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private DcMotor leftBack;
    private DcMotor[] motors;
    private MotorController motorController;

    //----------

    @Override
    public void init() {

        rightFront = hardwareMap.get(DcMotor.class, "Right Front");
        leftFront = hardwareMap.get(DcMotor.class, "Left Front");
        rightBack = hardwareMap.get(DcMotor.class, "Right Back");
        leftBack = hardwareMap.get(DcMotor.class, "Left Back");

        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        motors = new DcMotor[] {
                rightFront,
                leftFront,
                rightBack,
                leftBack
        };

        for (DcMotor i : motors) {
            i.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            i.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        motorController = new MotorController(rightFront, leftFront, rightBack, leftBack);

        telemetry.addData("init()", "Initialization is sucess!");
        telemetry.update();
    }

    //----------

    @Override
    public void loop() {

        telemetry.addData("loop()", "Loop is running");
        telemetry.update();

        float x = gamepad1.left_stick_x;
        float y = -gamepad1.left_stick_y;
        float z = gamepad1.right_stick_x;

        if (Math.abs(y) > 0.2f) {
            if (y > 0) {
                motorController.forward(y);
            } else {
                motorController.backward(Math.abs(y));
            }
        } else if (Math.abs(x) > 0.2f) {
            if (x > 0) {
                motorController.strafeRight(x);
            } else {
                motorController.strafeLeft(Math.abs(x));
            }
        } else if (Math.abs(z) > 0.2f){
            if (z < 0) {
                motorController.turnRight(z);
            } else {
                motorController.turnLeft(Math.abs(z));
            }
        } else {
            motorController.stopMotor();
        }
    }
}