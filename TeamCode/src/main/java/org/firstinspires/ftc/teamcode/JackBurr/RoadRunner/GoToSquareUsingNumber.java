package org.firstinspires.ftc.teamcode.JackBurr.RoadRunner;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.JackBurr.RoadRunner.MoveUsingDistance;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class GoToSquareUsingNumber extends OpMode {
    //Tiles are 2 ft x 2 ft
    //Board is 6 tiles by 6 tiles
    MoveUsingDistance moveUsingDistance;
    int currentSquare;
    @Override
    public void init() {
        moveUsingDistance = new MoveUsingDistance();
        currentSquare = 31;
    }

    @Override
    public void loop() {

    }

    public void move_left_by_squares(int squares){
        int inches = 24 * squares;
        moveUsingDistance.moveLeft(inches);
    }

    public void move_right_by_squares(int squares){
        int inches = 24 * squares;
        moveUsingDistance.moveRight(inches);
    }

    public void move_forward_by_squares(int squares){
        int inches = 24 * squares;
        moveUsingDistance.moveForward(inches);
    }

    public void move_back_by_squares(int squares){
        int inches = 24 * squares;
        moveUsingDistance.moveBackward(inches);
    }

    public void move_to_square(int target_square){
        int target_row;
        int current_row;
        if (target_square >= 1 && target_square <= 6){
            target_row = 1;
        }
        else if (target_square >= 7 && target_square <= 12){
            target_row = 2;
        }
        else if(target_square >= 13 && target_square <= 18){
            target_row = 3;
        }
        else if(target_square >= 19 && target_square <= 24){
            target_row = 4;
        }
        else if(target_square > 25 && target_square <= 30){
            target_row = 5;
        }
        else if(target_square > 31 && target_square <= 36){
            target_row = 6;
        }
        else {
            telemetry.addLine("Invalid target square.");
            requestOpModeStop();
        }

        if (currentSquare >= 1 && currentSquare <= 6){
            current_row = 1;
        }
        else if (currentSquare >= 7 && currentSquare <= 12){
            current_row = 2;
        }
        else if(currentSquare >= 13 && currentSquare <= 18){
            current_row = 3;
        }
        else if(currentSquare >= 19 && currentSquare <= 24){
            current_row = 4;
        }
        else if(currentSquare > 25 && currentSquare <= 30){
            current_row = 5;
        }
        else if(currentSquare > 31 && currentSquare <= 36){
            target_row = 6;
        }
        else {
            telemetry.addLine("Invalid current square.");
            requestOpModeStop();
        }
        move_forward_by_squares(current_row - target_row);
        currentSquare = target_square;
    }




}
