package org.firstinspires.ftc.teamcode.JackBurr.Motors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.sun.tools.javac.tree.DCTree;

@TeleOp
public class MotorTest extends OpMode {
    public DcMotor motor;
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        motor.setPower(1);
        telemetry.addLine("Motor Power: " + motor.getPower());
    }
}
