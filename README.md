# 2024SideTestingRepository
> [!NOTE]
> If you are looking for the FTC-issued **README**, you can find it [here.](/FTC_README.md)

# Introduction
**If you are reading this, you're probably interested in learing how to program in FTC Java. This README will help you get started.**

> [!WARNING]
> I am using Windows, so if you use any other operating system some of these things may not work for you.

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
6.  **REV Expansion Hub (You will need this if you are going to use more motors than just the drive motors)** 
    - https://www.revrobotics.com/rev-31-1153/
7.  **FTC-Legal Controller (I recommend PS4 Dualshock)**
    - https://www.playstation.com/en-us/accessories/dualshock-4-wireless-controller/
8.  **REV Batteries**
    - https://www.revrobotics.com/rev-31-1302/
9.  **REV Battery Chargers (Used to charge the batteries)**
    - https://www.revrobotics.com/rev-31-1299/
10.  **REV Hardware Client (Free software from REV that allows you to update and detect your Driver's Hub and Control Hub/Expansion Hub)**
    - https://docs.revrobotics.com/rev-hardware-client

## Robot Parts
If you are planning to program a robot, you are going to need robot parts. Most FIRST teams have parts from one of these two brands:
1.  **REV Robotics**
2.  **GoBilda (My team uses GoBilda because GoBilda parts are more durable)**

Some of the parts you will probably need are listed below.
> [!NOTE]
> If you are only doing Camera Vision then you do not **necessarily** need the below equipment, but it would be good to have.

1. **A chassis (Preferrably with mecanum wheels)**
   - https://www.gobilda.com/strafer-chassis-kit-96mm-mecanum-wheels/
2. **Motors (A great starting place)**
   - https://www.gobilda.com/yellow-jacket-planetary-gear-motors#series_5203
3. **Servos (A great place to go after motors)**
   - https://www.gobilda.com/servos

## Other Helpful Tools
Some other helpful resources are listed below:

   **1. RoadRunner Documentation**
   - https://learnroadrunner.com/
  
# Getting Started
Now that you have all of these things, I would recommend reading the book along with this README and coding as you go. Java can be a frustrating language, so don't get discouraged.

## What is Java?
Java is a programming language commonly used for the Android operating system. When we finish programming our robot using Java, we are sending our code to the Control Hub, which then executes our code as a set of directions.

## What is Android Studio?
Android Studio is an IDE (Integrated Development Environment). IDEs are better to use than plain text editors (such as Notepad) because IDEs provide sytntax highlighting, which allows programmers to better understand code. IDEs also can provide code suggestions and detect code errors without having to run code. In our case, Android Studio allows us to send the code to our robot. We then use our controller and Driver's Hub to control our robot. 

## Creating A New Android Studio Project
If you want to start programming, you need to create a new project. This can be done by downloading a copy of the FTC SDK as mentioned above, opening it in Android Studio once Android Studio is installed. Once the FTC SDK is downloaded, locate its .zip file location on your computer and extract it. Once the file extracts, open Android Studio and go to File > New > Import Project. A box will pop open and you should locate the folder where you extracted the SDK to. If you did everything right then your project will open. A FTC tutorial for this can be found [here.](https://ftc-docs.firstinspires.org/en/latest/programming_resources/tutorial_specific/android_studio/downloading_as_project_folder/Downloading-the-Android-Studio-Project-Folder.html)

## Pushing Code
Once our code is written, we need to push the code to the Control Hub. Feel free to come back to this at any time. Here are some directions to follow each time you start your setup:
1. **Plug a REV 12V battery into your Control Hub.** (The light should eventually blink blue and then turn green)
2. **Wait for the Control Hub to create a WiFi network.**
3. **Connect to the WiFi network using your computer.** (Note: You may need to buy a [USB WiFi adapter](https://www.target.com/p/tp-link-ac1300-wifi-5-wireless-usb-adapter-archer-t4u/-/A-86783001) because the first time you go to push, Android Studio will need to access the internet while still accessing the Control Hub. You do not need this if your computer uses LAN. I have linked the one that my team uses.)
4. **Power on the Driver's Hub using the power button.** (The Driver's Hub should automatically connect to the Control Hub WiFi network) 
5. Press the green play button at the top to push the code to the Control Hub. (The button icon is different the next time, but it's the same button)
When you make changes to your code, make sure your computer is still connected to the Control Hub and repeat step 5. This updates the code on the Control Hub.

## Java Comments
In a program, it might be hard to understand the program and/or your program might be having errors. Comments can fix both of these problems. The computer ignores comments and keeps moving through your program when it is run. This means that whever you write on comment lines will be ignored and will not affect the result of your program.
Comments are a commonly used to do one of two things and can be declared in two different ways:
1. Explain code
   - Example: __# This is a comment__
   - Example 2: __/* This is a comment */__
2. Stop certain lines of code from running to try to fix an error in the program
   
The difference between the two ways to declare comments is simple. The comment in Example 2 can span multiple lines and keeps going from the "/* "until the "*/", at which the comment ends. The comment in Example 1, however, ends at the end of the line and does not need anything to end it.

## Java Syntax
In Java, all lines except for comments must end with a semicolon, ';'. This tells the computer that the line is over and to move to the next line. If semicolons are not included on the necessary lines, an error will occur and the program will not run until the error is fixed.

## Variables
In any programming language, a variable is a way to store a number or value. Some variable examples in Java are listed below:
1. **Integer:** Can be set to any number
   - Example:
     ```Java
     int example_int = 1;
     ```
2. **Boolean:** Can be set to either true or false
   - Example:
     ```Java
     boolean hello = true;
     ```
     
3. **String:** Used to store text values.
   - Example:
     ```Java
     String hello_world = "Hello World";
     ```

4. **Double:** A non-whole number.
   - Example:
     ```Java
     double example_double = 0.4;
     ```
     
You can also declare variables at the start of a class without setting their value. These variables can be accessed after this point throughout the program.

```Java
public class VariableExample {
    public int integer_example;
    public String string_example;
    public boolean boolean_example;

    @Override
    public void init(){
        integer_example = 5;
        string_example = "I am an example string.";
        boolean_example = true;
    }
}
```

Hardware works mostly the same way:
```Java
public class HardwareExample {
    public DcMotor motor_example;

    @Override
    public void init(){

    }
}
```



## Public vs. Private
At the beginning of the above class you can see that it is declared a **"public class"**. You may wonder what this means.  When we declare something public, it is able to be accessed by other classes and other files inside your project. When something is private, however, it can only be accessed from the current class and an error will occur if you try to access it from another class or file. 

## Basic Functions
A function is a way to run code multiple times in a program without copying the same code over and over again. You can also pass numbers and other things into functions. These are called parameters. Here is an example:

```Java

public int add(int n1, int n2){
    return n1 + n2;
}
# Result = 5
int result = add(1, 4);

```

The above function can add two numbers and return them. Inside the parentheses we are declaring what parameters we need for this function. The "**int**" declares that the parameter is an integer. The "**return**" tells the function to return the value of n1 + n2, therefore the integer **result** is set to 5. The function will not run on its own, so we need to run it. That's what the last line is for. Changing the two numbers will change what the function returns, which will change the result of the program. We declare the function as **public int** because the function returns an integer (int). You can declare functions in many different ways, such as **"public String"**, **"public boolean"**, or **""public double""**.

## Imports
In able for our program to work, we need to import FTC-made libraries that can interact with our hardware and our robot. To do this we use import statements. To import the motor library, for example, one would use: **import com.qualcomm.robotcore.hardware.DcMotor;**

## What are OpModes?
OpModes are programs that we use to operate our robot. OpModes are required to have at least the following two functions: **init()** and **loop()**. Here are is the list of OpModes:
1. **init()**
   - Runs once when the driver presses the **INIT** button.
2. **init_loop()**
   - Runs repeatedly from the moment the driver presses **INIT** to the moment when the driver presses **PLAY**.
3. **start()**
   - Runs once when the driver presses the **PLAY** button.
4. **loop()**
   - Runs repeatedly from when the driver presses **PLAY** until the driver presses **STOP**.
5. **stop()**
   - Runs once when the driver presses **STOP**.


## Telemetry
Telemetry is the way that we can show text on our Driver's Hub. Examples of using Telemetry are included below.
```Java
    @TeleOp
    public class TelemetryTest extends OpMode {
        @Override
        public void init(){
            telemetry.addLine("Hello World");
            telemetry.addData("Hello", "World");
        }
    }
```

This code allows us to print "Hello World" to the telemetry in two different ways. The **addData** method has two parameters. The first parameter is called **caption**, which must be a string. The second parameter is called value, which can be pretty much anything. The FTC Dashboard, which I will talk about later, can graph the values of some of the numbers that are displayed to the telemetry through **addData**.

## @Autonomous vs @TeleOp
At the beginning of the file (above the start of the class), we should have one of two things: **@Autonomous** or **@TeleOp**. Changing which one you use will change its column on the Driver's Hub. **@Autonomous** is used when creating Autonomous programs, where the robot moves by itself using camera and sensor inputs and pre-programmed instructions. **@TeleOp** is used when creating TeleOp programs, where the driver controls the robot using the gamepad. My team uses RoadRunner with OpenCV and/or TensorFlow in autonomous. We will get to those later because they are pretty advanced concepts.

# Hardware
This section will explain how to use hardware with our code.

## Driver's Hub Config
The Driver's Hub configuration allows our Driver's Hub to know which Control Hub/Expansion Hub port our specific hardware devices are connected to
To access your configuration on your Driver's Hub, click the three dots in the top right and click Configure Robot. This will open a new page. Then click New. There will be a list of the connected devices. Click on the device that you want.

## HardwareMap
In our code, we use HardwareMap to tell the Control Hub which hardware device to access.

## Motors
So now let's explain how to get our first motor running.


## Mecanum Drive
Below is the Mecanum Drive code. The Mecanum Drive code is the easiest way to drive a robot that uses Mecanum Wheels with a controller.

```Java

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

    @Override
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
```

## What is the FTC Dashboard?
The FTC Dashboard is a way that we can track and map variables in our programs and see live camera feed in camera vision programs, along with many other things. 

## What Is RoadRunner?
RoadRunner is a motion library that most teams use for autonomous movement.


