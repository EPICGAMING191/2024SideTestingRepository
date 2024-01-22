package org.firstinspires.ftc.teamcode.JackBurr.SystemStates;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class SystemStatesExample extends OpMode {
    enum RobotState{
        START,
        ACTION_1
    }
    public RobotState last = RobotState.START;
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        last = actBasedOnState(last);
    }

    public RobotState actBasedOnState(RobotState lastState){
        RobotState state;
        switch (lastState){
            case START:
                state = RobotState.ACTION_1;
                break;
            default:
                state = RobotState.START;
                break;
        }
        return state;
    }
}
