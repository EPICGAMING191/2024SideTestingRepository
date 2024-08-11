package org.firstinspires.ftc.teamcode.JackBurr.RoadRunner;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceRunner;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp
public class TurnUsingDegrees extends OpMode {
    HardwareMap hwMap;
    SampleMecanumDrive sampleMecanumDrive = new SampleMecanumDrive(hwMap);

    public TurnUsingDegrees(HardwareMap hardware_map){
      this.hwMap = hardware_map;
    }

    @Override
    public void init() {

    }

    public void loop() {

    }


    public void turnLeft(int angle){
      sampleMecanumDrive.turn(-Math.toRadians(angle));
    }
    public void turnRight(int angle){
      sampleMecanumDrive.turn(Math.toRadians(angle));
    }

}
