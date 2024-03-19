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
    enum CurrentRobotOrientation {
        FORWARD,
        BACKWARD,
        LEFT,
        RIGHT
    }

    MoveUsingDistance moveUsingDistance;
    CurrentRobotOrientation currentRobotOrientation;
    int currentSquare;

    @Override
    public void init() {
        moveUsingDistance = new MoveUsingDistance();
        currentRobotOrientation = CurrentRobotOrientation.FORWARD;
        currentSquare = 31;
    }

    @Override 
    public void init_loop(){
        //Add adjustments using controller here
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
        int target_column;
        int current_column;

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

        if (target_square == 1 || target_square == 7 || target_square == 13 || target_square == 19 || target_square == 25 || target_square == 31){
            target_column = 1;
        }
        else if (target_square == 2 || target_square == 8 || target_square == 14 || target_square == 20 || target_square == 26 || target_square == 32){
            target_column = 2;
        }
        else if (target_square == 3 || target_square == 9 || target_square == 15 || target_square == 21 || target_square == 27 || target_square == 33){
            target_column = 3;
        }
        else if (target_square == 4 || target_square == 10 || target_square == 16 || target_square == 22 || target_square == 28 || target_square == 34){
            target_column = 4;
        }
        else if (target_square == 5 || target_square == 11 || target_square == 17 || target_square == 23 || target_square == 29 || target_square == 35){
            target_column = 5;
        }
        else if (target_square == 6 || target_square == 12 || target_square == 18 || target_square == 24 || target_square == 30 || target_square == 36){
            target_column = 6;
        }
        else {
            telemetry.addLine("Invalid current square.");
            requestOpModeStop();
        }

        if (currentSquare == 1 || currentSquare == 7 || currentSquare == 13 || currentSquare == 19 || currentSquare == 25 || currentSquare == 31){
            current_column = 1;
        }
        else if (currentSquare == 2 || currentSquare == 8 || currentSquare == 14 || currentSquare == 20 || currentSquare == 26 || currentSquare == 32){
            current_column = 2;
        }
        else if (currentSquare == 3 || currentSquare == 9 || currentSquare == 15 || currentSquare == 21 || currentSquare == 27 || currentSquare == 33){
            current_column = 3;
        }
        else if (currentSquare == 4 || currentSquare == 10 || currentSquare == 16 || currentSquare == 22 || currentSquare == 28 || currentSquare == 34){
            current_column = 4;
        }
        else if (currentSquare == 5 || currentSquare == 11 || currentSquare == 17 || currentSquare == 23 || currentSquare == 29 || currentSquare == 35){
            current_column = 5;
        }
        else if (currentSquare == 6 || currentSquare == 12 || currentSquare == 18 || currentSquare == 24 || currentSquare == 30 || currentSquare == 36){
            current_column = 6;
        }
        else {
            telemetry.addLine("Invalid target square.");
            requestOpModeStop();
        }

        if (currentRobotOrientation = CurrentRobotOrientation.FORWARD){
            move_forward_by_squares(current_row - target_row);
            move_right_by_squares(target_column - current_column);
        }
        else if(currentRobotOrientation = CurrentRobotOrientation.BACKWARD){
            move_back_by_squares(current_row - target_row);
            move_left_by_squares(target_column - current_column);
        }
        else if(currentRobotOrientation = CurrentRobotOrientation.LEFT){
            move_right_by_squares(current_row - target_row);
            move_back_by_squares(target_column - current_row);
        }
        else {
            move_left_by_squares(current_row - target_row);
            move_forward_by_squares(target_column - current_row);
        }
        currentSquare = target_square;
    }




}
