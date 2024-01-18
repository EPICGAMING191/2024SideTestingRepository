package org.firstinspires.ftc.teamcode.JackBurr.RoadRunner;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous
public class RoadRunnerTest01 extends OpMode {
    @Override
    public void init() {
        MoveUsingDistance distance = new MoveUsingDistance();
        distance.moveForward(24, hardwareMap);
        telemetry.addLine("Robot should have moved forward 24 inches.");
        telemetry.update();
    }

    @Override
    public void init_loop(){

    }

    @Override
    public void loop() {

    }
}
