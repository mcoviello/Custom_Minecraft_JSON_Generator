import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
    String modName;
    String parentFileDir;

    public Generator(String modName){
        this.modName = modName;
        parentFileDir = System.getenv("PATH");
    }
    public void GenerateBlock(String blockName) {
        File newFile = new File(parentFileDir + "\\block\\" + blockName + ".json");
        String toWrite = "{\n" +
                " \"parent\": \"minecraft:block/cube_all\",\n" +
                " \"textures\": {\n" +
                " \"all\":\"" + modName + ":block/" + blockName + "\"\n" +
                " }\n" +
                "}";

        WriteToFile(newFile, toWrite);
    }

    public void GenerateBlockItem(String itemName){
        File newFile = new File(parentFileDir + "\\item\\" + itemName + ".json");
        String toWrite = "{\n" +
                        " \"parent\": \"theancientglades:block/" + itemName + "\"\n" +
                        "}";
        WriteToFile(newFile, toWrite);
    }

    public void GenerateBuildingSet(){}

    private void WriteToFile(File destFile, String textToWrite){
        try{
            FileWriter writer = new FileWriter(destFile);
            writer.write(textToWrite);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Generator gen = new Generator("theancientglades");
    }
}
