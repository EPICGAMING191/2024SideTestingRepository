# 2024SideTestingRepository
> [!NOTE]
> If you are looking for the FTC-issued README, you can find it [here](/FTC_README.md)

If you are reading this, you're probably interested in learing how to program in FTC Java. This README will help you get started.

# Prerequisites
1. **PC with Android Studio installed**
   - https://developer.android.com/studio
2. **FTC SDK**
   - https://github.com/FIRST-Tech-Challenge/FtcRobotController
3. **Learn Java For FTC PDF (Very useful book with only some unnecessary content, but not 100% necessary)**
   - https://raw.githubusercontent.com/alan412/LearnJavaForFTC/master/LearnJavaForFTC.pdf
**4. REV Control Hub**
   - https://www.revrobotics.com/rev-31-1595/
**5. REV Driver's Hub**
   - https://www.revrobotics.com/rev-31-1596/
**6. FTC-Legal Controller (I recommend PS4 Dualshock)**
   - https://www.playstation.com/en-us/accessories/dualshock-4-wireless-controller/

# Other Helpful Tools
Some other helpful resources are listed below:
##    1. RoadRunner Documentation
   - https://learnroadrunner.com/
  
# Getting Started
Now that you have all of these things, I would recommend reading the book along with this README and coding as you go. Java can be a frustrating language, so don't get discouraged.

# What is Java?
Java is a programming language commonly used for the Android operating system. When we finish programming our robot using Java, we are sending our code to the Control Hub, which then executes our code as a set of directions.

# Creating A New Project
If you want to start programming, you need to create a new project. This can be done by downloading a copy of the FTC SDK as mentioned above, opening it in Android Studio once Android Studio is installed. Once the FTC SDK is downloaded, locate its .zip file location on your computer and extract it. Once the file extracts, open Android Studio and go to File > New > Import Project. A box will pop open and you should locate the folder where you extracted the SDK to.

# Mecanum Drive
Below is the Mecanum Drive Code

    package org.firstinspires.ftc.teamcode.CenterStage2324.JackBurr.Drive;
    
    import com.qualcomm.robotcore.eventloop.opmode.OpMode;
    import com.qualcomm.robotcore.hardware.DcMotor;
    import com.qualcomm.robotcore.hardware.HardwareMap;

    @TeleOp
    public class MecDrive extends OpMode {
       private DcMotor frontLeftMotor;
       private DcMotor frontRightMotor;
       private DcMotor backLeftMotor;
       private DcMotor backRightMotor;
          
         
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
    }

    public void loop() {
        double y = -gamepad1.left_stick_y; // Remember, this is reversed!
        double x = gamepad1.left_stick_x; // Counteract imperfect strafing
        double rx = -gamepad1.right_stick_x; //This is reversed for our turning
        drive(y, x, rx);
    }


    public void drive(double y, double x, double rx) {
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
    }



