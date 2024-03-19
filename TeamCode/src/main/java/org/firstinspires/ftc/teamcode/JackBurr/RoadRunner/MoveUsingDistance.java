package org.firstinspires.ftc.teamcode.JackBurr.RoadRunner;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class MoveUsingDistance extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
    public Trajectory getNewLeftTrajectory(double distance, HardwareMap hardMap){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardMap);
        Trajectory new_trajectory = drive.trajectoryBuilder(new Pose2d())
                .strafeLeft(distance)
                .build();
        return new_trajectory;
    }
    public Trajectory getNewRightTrajectory(double distance, HardwareMap hardMap){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardMap);
        Trajectory new_trajectory = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(distance)
                .build();
        return new_trajectory;
    }
    public Trajectory getNewForwardTrajectory(double distance, HardwareMap hardMap){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardMap);
        Trajectory new_trajectory = drive.trajectoryBuilder(new Pose2d())
                .forward(distance)
                .build();
        return new_trajectory;
    }
    public Trajectory getNewBackwardTrajectory(double distance, HardwareMap hardMap){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardMap);
        Trajectory new_trajectory = drive.trajectoryBuilder(new Pose2d())
                .back(distance)
                .build();
        return new_trajectory;
    }
    public void moveLeft(double distance, HardwareMap hardwareMap){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        drive.followTrajectory(getNewLeftTrajectory(distance, hardwareMap));
    }
    public void moveRight(double distance, HardwareMap hardwareMap){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        drive.followTrajectory(getNewRightTrajectory(distance, hardwareMap));
    }
    public void moveForward(double distance, HardwareMap hardwareMap){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        drive.followTrajectory(getNewForwardTrajectory(distance, hardwareMap));
    }
    public void moveBackward(double distance, HardwareMap hardwareMap){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        drive.followTrajectory(getNewBackwardTrajectory(distance, hardwareMap));
    }


}
