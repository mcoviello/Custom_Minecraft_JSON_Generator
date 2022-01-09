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
        try {
            System.out.println(parentFileDir + "\\block\\" + blockName + ".json");
            File newFile = new File(parentFileDir + "\\block\\" + blockName + ".json");
            FileWriter myWriter = new FileWriter(parentFileDir + "\\block\\" + blockName + ".json");

            String toWrite = "{\n" +
                    " \"parent\": \"minecraft:block/cube_all\",\n" +
                    " \"textures\": {\n" +
                    " \"all\":\"" + modName + ":block/" + blockName + "\"\n" +
                    " }\n" +
                    "}";

            if (newFile.createNewFile()) {
                //write
                myWriter.write(toWrite);
                myWriter.close();
            } else {
                //file already
                myWriter.write(toWrite);
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void GenerateItem(String itemName){
        try {
            File newFile = new File(parentFileDir + "\\item\\" + itemName + ".json");
            FileWriter myWriter = new FileWriter(parentFileDir + "\\block\\" + itemName + ".json");

            String toWrite = "{\n" +
                            " \"parent\": \"theancientglades:block/" + itemName + "\"\n" +
                            "}";

            if (newFile.createNewFile()) {
                //write
                myWriter.write(toWrite);
                myWriter.close();
            } else {
                //file already
                myWriter.write(toWrite);
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Generator gen = new Generator("theancientglades");
        gen.GenerateBlock("test_block");
        gen.GenerateItem("test_block");
    }
};
