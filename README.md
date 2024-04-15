# 2024SideTestingRepository
> [!NOTE]
> If you are looking for the FTC-issued README, you can find it [here.](/FTC_README.md)

**If you are reading this, you're probably interested in learing how to program in FTC Java. This README will help you get started.**

## Prerequisites
1.  **PC with Android Studio installed**
    - https://developer.android.com/studio
2.  **FTC SDK**
    - https://github.com/FIRST-Tech-Challenge/FtcRobotController
3.  **Learn Java For FTC PDF (Very useful book with only some unnecessary content. This one isn't 100% necessary, but it's 100% free)**
    - https://raw.githubusercontent.com/alan412/LearnJavaForFTC/master/LearnJavaForFTC.pdf
4.  **REV Control Hub**
    - https://www.revrobotics.com/rev-31-1595/
5.  **REV Driver's Hub**
    - https://www.revrobotics.com/rev-31-1596/
6.  **FTC-Legal Controller (I recommend PS4 Dualshock)**
    - https://www.playstation.com/en-us/accessories/dualshock-4-wireless-controller/
7.  **REV Batteries**
    - https://www.revrobotics.com/rev-31-1302/
8.  **REV Battery Chargers (Used to charge the batteries)**
    - https://www.revrobotics.com/rev-31-1299/
9.  **REV Hardware Client (Free software from REV that allows you to update and detect your Driver's Hub and Control Hub)**
    - https://docs.revrobotics.com/rev-hardware-client

## Robot Parts
If you are planning to program a robot, you are going to need robot parts. Most FIRST teams have parts from one of these two brands:
1.  **REV Robotics**
2.  **GoBilda (My team uses GoBilda because GoBilda parts are more durable)**

Some of the parts you will probably need are listed below.
1. A chassis (Preferrably with mecanum wheels)
   - https://www.gobilda.com/strafer-chassis-kit-96mm-mecanum-wheels/
2. Motors (A great starting place)
   - https://www.gobilda.com/yellow-jacket-planetary-gear-motors#series_5203
3. Servos (A great place to go after motors)
   - https://www.gobilda.com/servos

## Other Helpful Tools
Some other helpful resources are listed below:
###    1. RoadRunner Documentation
   - https://learnroadrunner.com/
  
# Getting Started
Now that you have all of these things, I would recommend reading the book along with this README and coding as you go. Java can be a frustrating language, so don't get discouraged.

## What is Java?
Java is a programming language commonly used for the Android operating system. When we finish programming our robot using Java, we are sending our code to the Control Hub, which then executes our code as a set of directions.

## What is Android Studio?
Android Studio is an IDE (Integrated Development Environment). IDEs are better to use than plain text editors (such as Notepad) because IDEs provide sytntax highlighting, which allows programmers to better understand code. IDEs also can provide code suggestions and detect code errors without having to run code. In our case, Android Studio allows us to send the code to our robot. We then use our controller and Driver's Hub to control our robot.

## Setup
Every time you go to program and test your robot, make sure to power on your Driver's Hub and Control Hub.

## Creating A New Project
If you want to start programming, you need to create a new project. This can be done by downloading a copy of the FTC SDK as mentioned above, opening it in Android Studio once Android Studio is installed. Once the FTC SDK is downloaded, locate its .zip file location on your computer and extract it. Once the file extracts, open Android Studio and go to File > New > Import Project. A box will pop open and you should locate the folder where you extracted the SDK to. If you did everything right then your project will open. A FTC tutorial for this can be found [here.](https://ftc-docs.firstinspires.org/en/latest/programming_resources/tutorial_specific/android_studio/downloading_as_project_folder/Downloading-the-Android-Studio-Project-Folder.html)

## Pushing Code
Once our code is written, we need to push the code to the Control Hub. Feel free to come back to this at any time. Here are some directions to follow each time you start your setup:
1. Plug a REV 12V battery into your Control Hub.
2. Wait for the Control Hub to create a WiFi network.
3. Connect to the WiFi network using your computer.
4. Power on the Driver's Hub using the power button. (The Driver's Hub should automatically connect to the Control Hub WiFi network) 
5. Press the green play button at the top to push the code to the Control Hub. (The button icon is different the next time, but it's the same button)
When you make changes to your code, make sure your

## Driver's Hub Config

## Basic Functions

## Mecanum Drive
Below is the Mecanum Drive code. The Mecanum Drive code is the easiest way to drive a robot that uses Mecanum Wheels with a controller.

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



