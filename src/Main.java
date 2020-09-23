import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File defaultXmlFile = new File("default.xml");
        File removedProjects = new File("removed_projects.xml");
        removedProjects.createNewFile();
        FileWriter writer= new FileWriter("removed_projects.xml");
        Scanner scanner = new Scanner(defaultXmlFile);
        writer.write(scanner.nextLine() + "\n");
        writer.write("<manifest>\n");
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if(str.contains("<project")) {
                for(String string: str.split(" ")) {
                    //System.out.println(string);
                    if(string.contains("name")) {
                        writer.write("\t<remove-project " + string + " />\n");
                    }
                }
            }
        }
        writer.write("</manifest>");
        System.out.println("File created successfully!\nNote,it overrides any existing file with smae name!");
        writer.close();
    }
}
