package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "TestTeleOp")
public class TestTeleOp extends OpMode {

    TestMotionController testMoveController = new TestMotionController();

    @Override
    public void init() {

        testMoveController.init(hardwareMap);

        telemetry.addData("init()", "Initialization is success!");
        telemetry.update();
    }

    @Override
    public void loop() {

        telemetry.addData("loop()", "Loop is running");

        float x = gamepad1.left_stick_x;
        float y = -gamepad1.left_stick_y;
        float z = gamepad1.right_stick_x;

        testMoveController.drive(x, y, z);

        telemetry.addData("x", x);
        telemetry.addData("y", y);
        telemetry.addData("z", z);
        telemetry.update();
    }

    @Override
    public void stop() {
        testMoveController.stopMotor();
    }
}
