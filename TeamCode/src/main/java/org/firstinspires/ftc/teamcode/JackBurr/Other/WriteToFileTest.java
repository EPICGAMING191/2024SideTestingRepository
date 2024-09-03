import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class WriteToFileTest extends OpMode {

    @Override
    public void init() {
        try {
            // Get the external storage directory
            File externalDir = Environment.getExternalStorageDirectory();

            // Create a subdirectory for our team's files
            File teamDir = new File(externalDir, "FTC_TeamFiles");
            teamDir.mkdirs();

            // Create a new file
            File outputFile = new File(teamDir, "example.txt");

            // Write to the file
            FileOutputStream fos = new FileOutputStream(outputFile);
            String content = "Hello, FTC!";
            fos.write(content.getBytes());
            fos.close();

            telemetry.addData("Status", "File written successfully!");
        } catch (IOException e) {
            telemetry.addData("Error", "Failed to write file: " + e.getMessage());
        }
    }

    @Override
    public void loop() {
        // Empty loop
    }
}
