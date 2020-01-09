import com.enigma.service.CommandService;
import com.enigma.service.FileService;

public class Main {
    private static final String FILE_NAME = "file_inputs.txt";
    public static void main(String[] args) {
        CommandService commandService = new CommandService();
        commandService.commandParse(FileService.parseFile(FILE_NAME));
    }
}
