package org.firstinspires.ftc.teamcode.JackBurr.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.JackBurr.RoadRunner.MoveUsingDistance;

@TeleOp
public class SwitchBetweenRobotAndManualControl extends OpMode {
    public int position = 0;
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    enum MODE {
        DRIVER_CONTROL,
        ROBOT_CONTROL
    }

    public MODE mode;
    @Override
    public void init() {
        frontLeftMotor = hardwareMap.get(DcMotor.class, "fl");
        frontRightMotor = hardwareMap.get(DcMotor.class, "fr");
        backLeftMotor = hardwareMap.get(DcMotor.class, "bl");
        backRightMotor = hardwareMap.get(DcMotor.class, "br");
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mode = MODE.ROBOT_CONTROL;
    }

    @Override
    public void init_loop(){
        if (gamepad1.x){
            mode = switchMode(mode);
        }
        if (mode == MODE.DRIVER_CONTROL){
            //MecDrive
            drive();
        }
        else {
            //Robot in control
            position = move_other_way(position);
        }
    }

    public void drive(){
        double y = -gamepad1.left_stick_y; // Remember, this is reversed!
        double x = -gamepad1.left_stick_x; // Counteract imperfect strafing
        double rx = -gamepad1.right_stick_x; //This is reversed for our turning
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (-y + x + rx) / denominator;
        double backLeftPower = (-y - x + rx) / denominator;
        double frontRightPower = (y + x + rx) / denominator;
        double backRightPower = (y - x + rx) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }

    public int move_other_way(int lastPos){
        MoveUsingDistance distance = new MoveUsingDistance();
        if (lastPos == 0){
            distance.moveForward(10, hardwareMap);
            return 1;
        }
        else {
            distance.moveBackward(10, hardwareMap);
            return 0;
        }
    }

    @Override
    public void loop() {

    }

    public MODE switchMode(MODE previousMode){
        MODE newMode;
        if (previousMode == MODE.DRIVER_CONTROL){
            newMode = MODE.ROBOT_CONTROL;
            return newMode;
        }
        else {
            newMode = MODE.DRIVER_CONTROL;
            return newMode;
        }
    }
}
