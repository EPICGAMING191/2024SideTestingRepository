package org.firstinspires.ftc.teamcode.JackBurr.RoadRunner;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceRunner;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class MoveUsingDistance extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }

    public void turnAsync(double angle) {
        trajectorySequenceRunner.followTrajectorySequenceAsync(
                trajectorySequenceBuilder(getPoseEstimate())
                        .turn(angle)
                        .build()
        );
    }
  
    public void turnLeft(double angle){
      turnAsync(-angle);
      waitForIdle();
    }

}
