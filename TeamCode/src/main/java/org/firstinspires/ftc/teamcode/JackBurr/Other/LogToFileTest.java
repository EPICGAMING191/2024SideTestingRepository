package org.firstinspires.ftc.teamcode.JackBurr.Other;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@TeleOp
public class LogToFileTest extends OpMode {
  
  public void createLog(String filename) {
    try {
      File new_file = new File(filename);
      if (new_file.createNewFile()) {
        telemetry.addLine("File created: " + new_file.getName());
      } else {
        telemetry.addLine("File already exists.");
      }
    } 
    catch (IOException e) {
      telemetry.addLine("An error occurred: " + e);
    }    
  }

  public void writeToFile(String file, String text) {
    try {
      FileWriter myWriter = new FileWriter(file);
      myWriter.write(text);
      myWriter.close();
      telemetry.addLine("Successfully wrote to the file.");
    }
    catch (IOException e) {
      telemetry.addData("An error occurred:", e);
    }
  }

  
createLog("hi.txt");
writeToFile("hi.txt", "hi");
  
}
