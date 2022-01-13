import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/***
*Generator
*    This class is used to generate the various JSON files for minecraft items.
*    It generates Recipes, Models, LootTables and Blockstates.
*
*    It provides some standard methods for generating sets of items, or you can
*    use the generic methods to generate your own, for completely custom items.
*
*    Authored by Michael Coviello, 2022
 */

public class Generator {
    private final String modName;
    private final String parentFileDir;

    private final char noChar = Character.MIN_VALUE;
    public Generator(String modName){
        this.modName = modName;
        parentFileDir = System.getenv("PATH");
    }

    private void WriteToFile(File destFile, String textToWrite){
        try{
            if(destFile.createNewFile()) {
                FileWriter writer = new FileWriter(destFile);
                writer.write(textToWrite);
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("IO error writing to file " + destFile.getName() + ".\n");
            e.printStackTrace();
        }
    }

    //- Generic Block Model File-//
    public void GenerateBlock(String blockName) {
        File newFile = new File(parentFileDir + modName + "\\models\\block\\" + blockName + ".json");
        String toWrite = "{\n" +
                " \"parent\": \"minecraft:block/cube_all\",\n" +
                " \"textures\": {\n" +
                " \"all\":\"" + modName + ":block/" + blockName + "\"\n" +
                " }\n" +
                "}";

        WriteToFile(newFile, toWrite);
    }

    //- Item Model Files -//
    public void GenerateBlockItem(String itemName){
        File newFile = new File(parentFileDir + modName + "\\models\\item\\" + itemName + ".json");
        String toWrite = "{\n" +
                        " \"parent\": \"" + modName + ":block/" + itemName + "\"\n" +
                        "}";
        WriteToFile(newFile, toWrite);
    }
    public void GenerateItem(String parent, String itemName){
        //Parent refers to minecraft::item/{parent}
        //e.g. handheld
        File newFile = new File(parentFileDir + modName + "\\models\\item\\" + itemName + ".json");
        String toWrite = "{\n" +
                " \"parent\": \"item/" + parent +"\",\n" +
                " \"textures\": {\n" +
                "  \"layer0\": \"" + modName + ":"+ itemName + "\"\n" +
                " }\n" +
                "}";
        WriteToFile(newFile, toWrite);
    }

    //- Blockstate Files-//
    public void GenerateCubeBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + ".json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"\": { \"models\": \"" + modName + ":block/" + blockName + "\" }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GenerateButtonBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_button.json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"face=floor,facing=east,powered=false\":  { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"y\": 90 },\n" +
                "    \"face=floor,facing=west,powered=false\":  { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"y\": 270 },\n" +
                "    \"face=floor,facing=south,powered=false\": { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"y\": 180 },\n" +
                "    \"face=floor,facing=north,powered=false\": { \"models\": \"" + modName + ":block/" + blockName + "_button\" },\n" +
                "    \"face=wall,facing=east,powered=false\":  { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"uvlock\": true, \"x\": 90, \"y\": 90 },\n" +
                "    \"face=wall,facing=west,powered=false\":  { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"uvlock\": true, \"x\": 90, \"y\": 270 },\n" +
                "    \"face=wall,facing=south,powered=false\": { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"uvlock\": true, \"x\": 90, \"y\": 180 },\n" +
                "    \"face=wall,facing=north,powered=false\": { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"uvlock\": true, \"x\": 90 },\n" +
                "    \"face=ceiling,facing=east,powered=false\":  { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"x\": 180, \"y\": 270 },\n" +
                "    \"face=ceiling,facing=west,powered=false\":  { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"x\": 180, \"y\": 90 },\n" +
                "    \"face=ceiling,facing=south,powered=false\": { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"x\": 180 },\n" +
                "    \"face=ceiling,facing=north,powered=false\": { \"models\": \"" + modName + ":block/" + blockName + "_button\", \"x\": 180, \"y\": 180 },\n" +
                "    \"face=floor,facing=east,powered=true\":  { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"y\": 90 },\n" +
                "    \"face=floor,facing=west,powered=true\":  { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"y\": 270 },\n" +
                "    \"face=floor,facing=south,powered=true\": { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"y\": 180 },\n" +
                "    \"face=floor,facing=north,powered=true\": { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\" },\n" +
                "    \"face=wall,facing=east,powered=true\":  { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"uvlock\": true, \"x\": 90, \"y\": 90 },\n" +
                "    \"face=wall,facing=west,powered=true\":  { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"uvlock\": true, \"x\": 90, \"y\": 270 },\n" +
                "    \"face=wall,facing=south,powered=true\": { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"uvlock\": true, \"x\": 90, \"y\": 180 },\n" +
                "    \"face=wall,facing=north,powered=true\": { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"uvlock\": true, \"x\": 90 },\n" +
                "    \"face=ceiling,facing=east,powered=true\":  { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"x\": 180, \"y\": 270 },\n" +
                "    \"face=ceiling,facing=west,powered=true\":  { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"x\": 180, \"y\": 90 },\n" +
                "    \"face=ceiling,facing=south,powered=true\": { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"x\": 180 },\n" +
                "    \"face=ceiling,facing=north,powered=true\": { \"models\": \"" + modName + ":block/" + blockName + "_button_pressed\", \"x\": 180, \"y\": 180 }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GenerateDoorBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_door.json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"facing=east,half=lower,hinge=left,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom\"\n" +
                "    },\n" +
                "    \"facing=east,half=lower,hinge=left,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom_hinge\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=east,half=lower,hinge=right,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom_hinge\"\n" +
                "    },\n" +
                "    \"facing=east,half=lower,hinge=right,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=east,half=upper,hinge=left,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top\"\n" +
                "    },\n" +
                "    \"facing=east,half=upper,hinge=left,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top_hinge\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=east,half=upper,hinge=right,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top_hinge\"\n" +
                "    },\n" +
                "    \"facing=east,half=upper,hinge=right,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=north,half=lower,hinge=left,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=north,half=lower,hinge=left,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom_hinge\"\n" +
                "    },\n" +
                "    \"facing=north,half=lower,hinge=right,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom_hinge\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=north,half=lower,hinge=right,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=north,half=upper,hinge=left,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=north,half=upper,hinge=left,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top_hinge\"\n" +
                "    },\n" +
                "    \"facing=north,half=upper,hinge=right,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top_hinge\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=north,half=upper,hinge=right,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=south,half=lower,hinge=left,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=south,half=lower,hinge=left,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom_hinge\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=south,half=lower,hinge=right,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom_hinge\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=south,half=lower,hinge=right,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom\"\n" +
                "    },\n" +
                "    \"facing=south,half=upper,hinge=left,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=south,half=upper,hinge=left,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top_hinge\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=south,half=upper,hinge=right,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top_hinge\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=south,half=upper,hinge=right,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top\"\n" +
                "    },\n" +
                "    \"facing=west,half=lower,hinge=left,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=west,half=lower,hinge=left,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom_hinge\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=west,half=lower,hinge=right,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom_hinge\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=west,half=lower,hinge=right,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_bottom\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=west,half=upper,hinge=left,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=west,half=upper,hinge=left,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top_hinge\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=west,half=upper,hinge=right,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top_hinge\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=west,half=upper,hinge=right,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_door_top\",\n" +
                "      \"y\": 90\n" +
                "    }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GenerateFenceBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_fence.json");
        String toWrite = "{\n" +
                "  \"multipart\": [\n" +
                "    {\n" +
                "      \"apply\": {\n" +
                "        \"models\": \"" + modName + ":block/" + blockName + "_fence_post\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"when\": {\n" +
                "        \"north\": \"true\"\n" +
                "      },\n" +
                "      \"apply\": {\n" +
                "        \"models\": \"" + modName + ":block/" + blockName + "_fence_side\",\n" +
                "        \"uvlock\": true\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"when\": {\n" +
                "        \"east\": \"true\"\n" +
                "      },\n" +
                "      \"apply\": {\n" +
                "        \"models\": \"" + modName + ":block/" + blockName + "_fence_side\",\n" +
                "        \"y\": 90,\n" +
                "        \"uvlock\": true\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"when\": {\n" +
                "        \"south\": \"true\"\n" +
                "      },\n" +
                "      \"apply\": {\n" +
                "        \"models\": \"" + modName + ":block/" + blockName + "_fence_side\",\n" +
                "        \"y\": 180,\n" +
                "        \"uvlock\": true\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"when\": {\n" +
                "        \"west\": \"true\"\n" +
                "      },\n" +
                "      \"apply\": {\n" +
                "        \"models\": \"" + modName + ":block/" + blockName + "_fence_side\",\n" +
                "        \"y\": 270,\n" +
                "        \"uvlock\": true\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GenerateGateBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_fence_gate.json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"facing=east,in_wall=false,open=false\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 270,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate\"\n" +
                "    },\n" +
                "    \"facing=east,in_wall=false,open=true\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 270,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_open\"\n" +
                "    },\n" +
                "    \"facing=east,in_wall=true,open=false\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 270,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_wall\"\n" +
                "    },\n" +
                "    \"facing=east,in_wall=true,open=true\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 270,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_wall_open\"\n" +
                "    },\n" +
                "    \"facing=north,in_wall=false,open=false\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 180,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate\"\n" +
                "    },\n" +
                "    \"facing=north,in_wall=false,open=true\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 180,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_open\"\n" +
                "    },\n" +
                "    \"facing=north,in_wall=true,open=false\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 180,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_wall\"\n" +
                "    },\n" +
                "    \"facing=north,in_wall=true,open=true\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 180,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_wall_open\"\n" +
                "    },\n" +
                "    \"facing=south,in_wall=false,open=false\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate\"\n" +
                "    },\n" +
                "    \"facing=south,in_wall=false,open=true\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_open\"\n" +
                "    },\n" +
                "    \"facing=south,in_wall=true,open=false\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_wall\"\n" +
                "    },\n" +
                "    \"facing=south,in_wall=true,open=true\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_wall_open\"\n" +
                "    },\n" +
                "    \"facing=west,in_wall=false,open=false\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 90,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate\"\n" +
                "    },\n" +
                "    \"facing=west,in_wall=false,open=true\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 90,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_open\"\n" +
                "    },\n" +
                "    \"facing=west,in_wall=true,open=false\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 90,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_wall\"\n" +
                "    },\n" +
                "    \"facing=west,in_wall=true,open=true\": {\n" +
                "      \"uvlock\": true,\n" +
                "      \"y\": 90,\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_fence_gate_wall_open\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GenerateLogBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_log.json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"axis=x\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_log_horizontal\",\n" +
                "      \"x\": 90,\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"axis=y\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_log\"\n" +
                "    },\n" +
                "    \"axis=z\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_log_horizontal\",\n" +
                "      \"x\": 90\n" +
                "    }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GeneratePressurePlateBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_pressure_plate.json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"powered=false\": { \"models\": \"" + modName + ":block/" + blockName + "_pressure_plate\" },\n" +
                "    \"powered=true\": { \"models\": \"" + modName + ":block/" + blockName + "_pressure_plate_down\" }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GenerateSlabBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_slab.json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"type=bottom\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_slab\"\n" +
                "    },\n" +
                "    \"type=double\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "    },\n" +
                "    \"type=top\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_slab_top\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GenerateStairsBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_stairs.json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"facing=east,half=bottom,shape=inner_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,shape=inner_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\"\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,shape=outer_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,shape=outer_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\"\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,shape=straight\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs\"\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=inner_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=inner_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=outer_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=outer_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=straight\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=inner_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=inner_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=outer_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=outer_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=straight\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=inner_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=inner_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=outer_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=outer_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=straight\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=inner_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\"\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=inner_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=outer_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\"\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=outer_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=straight\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=inner_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=inner_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=outer_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=outer_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=straight\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=inner_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=inner_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=outer_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=outer_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=straight\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=inner_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=inner_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=outer_left\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=outer_right\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=straight\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_stairs\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }
    public void GenerateTrapdoorBlockstate(String blockName){
        File blockstate = new File(parentFileDir + modName + "\\blockstates\\" + blockName + "_trapdoor.json");
        String toWrite = "{\n" +
                "  \"variants\": {\n" +
                "    \"facing=east,half=bottom,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_bottom\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_open\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=east,half=top,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_top\",\n" +
                "      \"y\": 90\n" +
                "    },\n" +
                "    \"facing=east,half=top,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_open\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_bottom\"\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_open\"\n" +
                "    },\n" +
                "    \"facing=north,half=top,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_top\"\n" +
                "    },\n" +
                "    \"facing=north,half=top,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_open\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_bottom\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_open\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=south,half=top,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_top\",\n" +
                "      \"y\": 180\n" +
                "    },\n" +
                "    \"facing=south,half=top,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_open\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 0\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_bottom\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_open\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=west,half=top,open=false\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_top\",\n" +
                "      \"y\": 270\n" +
                "    },\n" +
                "    \"facing=west,half=top,open=true\": {\n" +
                "      \"models\": \"" + modName + ":block/" + blockName + "_trapdoor_open\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90\n" +
                "    }\n" +
                "  }\n" +
                "}";
        WriteToFile(blockstate, toWrite);
    }

    //- Generic Loot Table File -//
    public void GenerateLootTable(String fullName){
        File ltFile = new File(parentFileDir + "..\\data\\" + modName + "\\loot_tables\\blocks\\" + fullName + ".json");
        String toWrite = "{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": 1,\n" +
                "      \"entries\": [\n" +
                "        {\n" +
                "          \"type\": \"minecraft:item\",\n" +
                "          \"name\": \"" + modName + ":" + fullName +"\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"conditions\": [\n" +
                "        {\n" +
                "          \"condition\": \"minecraft:survives_explosion\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        WriteToFile(ltFile, toWrite);
    }

    //-- Methods to generate the different parts of a building set --//
    public void GenerateBuildingSet(String blockName){
        GenerateButton(blockName);
        GenerateDoor(blockName);
        GenerateFence(blockName);
        GenerateGate(blockName);
        GenerateLeaves(blockName);
        GenerateLog(blockName);
        GeneratePlanks(blockName);
        GeneratePressurePlate(blockName);
        GenerateSapling(blockName);
        GenerateSlab(blockName);
        GenerateStairs(blockName);
        GenerateItem("handheld", blockName + "_stick");
        GenerateStrippedLog(blockName);
        GenerateStrippedWood(blockName);
        GenerateTrapdoor(blockName);
        GenerateWood(blockName);
    }
    public void GenerateButton(String blockName){
        String fullName = blockName + "_button";
        File newFile = new File(parentFileDir + modName + "\\models\\block\\" + fullName + ".json");
        String toWrite = "{\n" +
                "  \"parent\": \"block/button\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }";
        WriteToFile(newFile, toWrite);
        GenerateBlockItem(blockName + "_inventory");
        GenerateButtonBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateDoor(String blockName){
        String fullName = blockName + "_door";
        File doorTop = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_top.json");
        File doorTopHinge = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_top_hinge.json");
        File doorBottom = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_bottom.json");
        File doorBottomHinge = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_bottom_hinge.json");
        String toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/door_top\",\n" +
                "  \"textures\": {\n" +
                "    \"top\": \"" + modName + ":block/" + fullName + "_top\",\n" +
                "    \"bottom\": \"" + modName + ":block/" + fullName + "_bottom\"\n" +
                "  }\n" +
                "}";
        WriteToFile(doorTop, toWrite);
        toWrite ="{\n" +
                "  \"parent\": \"minecraft:block/door_top_rh\",\n" +
                "  \"textures\": {\n" +
                "    \"top\": \"" + modName + ":block/"+ fullName +"_top\",\n" +
                "    \"bottom\": \"" + modName + ":block/"+ fullName +"_bottom\"\n" +
                "  }\n" +
                "}";
        WriteToFile(doorTopHinge, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/door_bottom\",\n" +
                "  \"textures\": {\n" +
                "    \"top\": \"" + modName + ":block/" + fullName + "_top\",\n" +
                "    \"bottom\": \"" + modName + ":block/" + fullName + "_bottom\"\n" +
                "  }\n" +
                "}";
        WriteToFile(doorBottom, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/door_bottom_rh\",\n" +
                "  \"textures\": {\n" +
                "    \"top\": \"" + modName + ":block/" + fullName + "_top\",\n" +
                "    \"bottom\": \"" + modName + ":block/" + fullName + "_bottom\"\n" +
                "  }\n" +
                "}";
        WriteToFile(doorBottomHinge, toWrite);
        GenerateItem("generated", fullName);
        GenerateDoorBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateFence(String blockName){
        String fullName = blockName + "_fence";
        File post = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_post.json");
        File side = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_side.json");
        File inv = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_inventory.json");
        String toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/fence_post\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(post, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/fence_side\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(side, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/fence_inventory\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(inv, toWrite);
        GenerateBlockItem(fullName);
        GenerateFenceBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateGate(String blockName){
        String fullName = blockName + "_fence_gate";
        File gate = new File(parentFileDir + modName + "\\models\\block\\" + fullName + ".json");
        File open = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_open.json");
        String toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/template_fence_gate\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(gate, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/template_fence_gate_open\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(open, toWrite);
        GenerateBlockItem(fullName);
        GenerateGateBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateLeaves(String blockName){
        String fullName = blockName + "_leaves";
        GenerateBlock(fullName);
        GenerateBlockItem(fullName);
        GenerateCubeBlockstate(blockName + "_leaves");
        GenerateLootTable(fullName);
    }
    public void GenerateLog(String blockName){
        String fullName = blockName + "_log";
        File newFile = new File(parentFileDir + modName + "\\models\\block\\" + fullName + ".json");
        String toWrite = "{\n" +
                "\"parent\": \"minecraft:block/cube_column\",\n" +
                "  \"textures\": {\n" +
                "    \"end\": \"" + modName + ":block/" + fullName + "_top\",\n" +
                "    \"side\": \"" + modName + ":block/" + fullName + "\"\n" +
                " }\n" +
                "}";
        WriteToFile(newFile, toWrite);
        GenerateBlockItem(fullName);
        GenerateLogBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GeneratePlanks(String blockName){
        String fullName = blockName + "_planks";
        GenerateBlock(fullName);
        GenerateBlockItem(fullName);
        GenerateCubeBlockstate(fullName);
        GenerateLootTable(fullName);
    }
    public void GeneratePressurePlate(String blockName){
        String fullName = blockName + "_pressure_plate";
        File plateUp = new File(parentFileDir + modName + "\\models\\block\\" + fullName + ".json");
        File plateDown = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_down.json");
        String toWrite = "{\n" +
                "  \"parent\": \"block/pressure_plate_up\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(plateUp, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"block/pressure_plate_down\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(plateDown, toWrite);
        GenerateBlockItem(fullName);
        GeneratePressurePlateBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateSapling(String blockName){
        String fullName = blockName + "_sapling";
        File newFile = new File(parentFileDir + modName + "\\models\\block\\" + fullName + ".json");
        String toWrite = "";
        WriteToFile(newFile, toWrite);
    }
    public void GenerateSlab(String blockName){
        String fullName = blockName + "_slab";
        File newFile = new File(parentFileDir + modName + "\\models\\block\\" + fullName + ".json");
        String toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/slab\",\n" +
                "  \"textures\": {\n" +
                "    \"bottom\": \"" + modName + ":block/" + blockName + "_planks\",\n" +
                "    \"top\": \"" + modName + ":block/" + blockName + "_planks\",\n" +
                "    \"side\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(newFile, toWrite);
        GenerateBlockItem(fullName);
        GenerateSlabBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateStairs(String blockName){
        String fullName = blockName + "_stairs";
        File stairs = new File(parentFileDir + modName + "\\models\\block\\" + fullName + ".json");
        File inner = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_inner.json");
        File outer = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_outer.json");
        String toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/stairs\",\n" +
                "  \"textures\": {\n" +
                "    \"bottom\": \"" + modName + ":block/" + blockName + "_planks\",\n" +
                "    \"top\": \"" + modName + ":block/" + blockName + "_planks\",\n" +
                "    \"side\": \"" + modName + ":block/" + blockName + "_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(stairs, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/inner_stairs\",\n" +
                "  \"textures\": {\n" +
                "    \"bottom\": \"" + modName + ":block/" + blockName + "_planks\",\n" +
                "    \"top\": \"" + modName + ":block/" + blockName +"_planks\",\n" +
                "    \"side\": \"" + modName + ":block/" + blockName +"_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(inner, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/outer_stairs\",\n" +
                "  \"textures\": {\n" +
                "    \"bottom\": \"" + modName + ":block/" + blockName +"_planks\",\n" +
                "    \"top\": \"" + modName + ":block/" + blockName +"_planks\",\n" +
                "    \"side\": \"" + modName + ":block/" + blockName +"_planks\"\n" +
                "  }\n" +
                "}";
        WriteToFile(outer, toWrite);
        GenerateBlockItem(fullName);
        GenerateStairsBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateStrippedLog(String blockName){
        String fullName = "stripped_" + blockName + "_log";
        File newFile = new File(parentFileDir + modName + "\\models\\block\\" + fullName + ".json");
        String toWrite = "{\n" +
                "\"parent\": \"minecraft:block/cube_column\",\n" +
                "  \"textures\": {\n" +
                "    \"end\": \"" + modName + ":block/" + fullName + "_top\",\n" +
                "    \"side\": \"" + modName + ":block/" + fullName + "\"\n" +
                " }\n" +
                "}";
        WriteToFile(newFile, toWrite);
        GenerateBlockItem(fullName);
        GenerateLogBlockstate("stripped_" + blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateStrippedWood(String blockName){
        String fullName = "stripped_" + blockName + "_wood";
        GenerateBlock(fullName);
        GenerateBlockItem(fullName);
        GenerateCubeBlockstate(fullName);
        GenerateLootTable(fullName);
    }
    public void GenerateTrapdoor(String blockName){
        String fullName = blockName + "_trapdoor";
        File bottom = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_bottom.json");
        File top = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_open.json");
        File open = new File(parentFileDir + modName + "\\models\\block\\" + fullName + "_top.json");
        String toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/template_trapdoor_bottom\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + fullName + "\"\n" +
                "  }\n" +
                "}";
        WriteToFile(bottom, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/template_trapdoor_top\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + fullName + "\"\n" +
                "  }\n" +
                "}";
        WriteToFile(top, toWrite);
        toWrite = "{\n" +
                "  \"parent\": \"minecraft:block/template_trapdoor_open\",\n" +
                "  \"textures\": {\n" +
                "    \"texture\": \"" + modName + ":block/" + fullName + "\"\n" +
                "  }\n" +
                "}";
        WriteToFile(open, toWrite);
        GenerateBlockItem(fullName);
        GenerateTrapdoorBlockstate(blockName);
        GenerateLootTable(fullName);
    }
    public void GenerateWood(String blockName){
        String fullName = blockName + "_wood";
        GenerateBlock(fullName);
        GenerateBlockItem(fullName);
        GenerateCubeBlockstate(fullName);
        GenerateLootTable(fullName);
    }

    //- Method to generate the different parts of an Item Set-//
    public void GenerateToolSet(String blockName){
        GenerateItem("handheld", blockName + "_axe");
        GenerateItem("handheld", blockName + "_hoe");
        GenerateItem("handheld", blockName + "_pickaxe");
        GenerateItem("handheld", blockName + "_shovel");
        GenerateItem("handheld", blockName + "_sword");
    }

    //- Method to generate an Armour Set -//
    public void GenerateArmourSet(String blockName){
        GenerateItem("generated", blockName + "_boots");
        GenerateItem("generated", blockName + "_chestplate");
        GenerateItem("generated", blockName + "_helmet");
        GenerateItem("generated", blockName + "_leggings");
    }

    //- Crafting recipe generation methods-//
    public void GenerateShapelessCraftingRecipe(RecipeItem ingredient, RecipeItem result){
        File newFile = new File(parentFileDir + "..\\data\\" + modName + "\\recipes\\" + result.name + ".json");
        String toWrite = "{\n" +
                "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                "  \"ingredients\": [\n" +
                "    {\n" +
                "      \"" + ingredient.GetTag() + "\":\"" + modName + ":" + ingredient.name + "\",\n" +
                "      \"count\": " + ingredient.count + "\n" +
                "    }\n" +
                "  ],\n" +
                "  \"result\": {\n" +
                "    \"" + result.GetTag() + "\": \"" + modName + ":" + result.name +"\",\n" +
                "    \"count\": " + result.count +
                "  }\n" +
                "}";
        WriteToFile(newFile, toWrite);
    }
    public void GenerateShapelessCraftingRecipe(RecipeItem ingredient, RecipeItem result, String group){
        File newFile = new File(parentFileDir + "..\\data\\" + modName + "\\recipes\\" + result.name + ".json");
        String toWrite = "{\n" +
                "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                "  \"group\": \"" + group + "\",\n" +
                "  \"ingredients\": [\n" +
                "    {\n" +
                "      \"" + ingredient.GetTag()  + "\":\""+ modName + ":" + ingredient.name + "\",\n" +
                "      \"count\": " + ingredient.count + "\n" +
                "    }\n" +
                "  ],\n" +
                "  \"result\": {\n" +
                "    \"" + result.GetTag() + "\": \"" + modName + ":" + result.name +"\",\n" +
                "    \"count\": " + result.count +
                "  }\n" +
                "}";
        WriteToFile(newFile, toWrite);
    }

    public void GenerateShapedCraftingRecipe(RecipeItem[] ingredients, RecipeItem result, Character[] recipe){
        File newFile = new File(parentFileDir + "..\\data\\" + modName + "\\recipes\\" + result.name + ".json");

        String toWrite = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"pattern\": [\n";
        for (int i = 0; i < 3; ++i){
            if(recipe[i * 3] == '\0' && recipe[(i * 3) + 1] == '\0' && recipe[(i * 3) + 2] == '\0')
                continue;
            if(i != 0){
                toWrite += ",\n";
            }
            toWrite += "    \"";
            for(int j = i * 3; j < (i*3) + 3; ++j){
                if(recipe[j] == '\0')
                    continue;
                toWrite += recipe[j];
            }
            toWrite += ("\"");
        }
        toWrite +=
                "\n  ],\n" +
                        "  \"key\": {\n";
        int count = 0;
        for (int i = 0; i < ingredients.length; i++) {
            //Add all of the ingredients to the keys
            toWrite +=
                    "    \"" + ingredients[i].symbol + "\": {\n" +
                            "      \"" + ingredients[i].GetTag() +"\": \"" + modName + ":" + ingredients[i].name + "\"\n" +
                            ((i < ingredients.length-1) ? ("    },\n") : ("    }\n"));
        }
        //Add the resulting item, and count;
        toWrite +=
                "  },\n" +
                        "  \"result\": {\n" +
                        "    \"item\": \"" + modName + ":" + result.name + "\",\n" +
                        "    \"count\": " + result.count + "\n" +
                        "  }\n" +
                        "}";
        WriteToFile(newFile, toWrite);
    }
    public void GenerateShapedCraftingRecipe(RecipeItem[] ingredients, RecipeItem result, Character[] recipe, String groupName) {
        File newFile = new File(parentFileDir + "..\\data\\" + modName + "\\recipes\\" + result.name + ".json");
        String toWrite = "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "\"group\": \"" + groupName + "\",\n" +
                "  \"pattern\": [\n";
                for (int i = 0; i < 3; ++i){
                    if(recipe[i * 3] == '\0' && recipe[(i * 3) + 1] == '\0' && recipe[(i * 3) + 2] == '\0')
                        continue;
                    if(i != 0){
                        toWrite += ",\n";
                    }
                    toWrite += "    \"";
                    for(int j = i * 3; j < (i*3) + 3; ++j){
                        if(recipe[j] == '\0')
                            continue;
                        toWrite += recipe[j];
                    }
                    toWrite += ("\"");
                }
                toWrite +=
                    "\n  ],\n" +
                    "  \"key\": {\n";
        for (int i = 0; i < ingredients.length; i++) {
            //Add all of the ingredients to the keys
            toWrite +=
                    "    \"" + ingredients[i].symbol + "\": {\n" +
                    "      \"" + ingredients[i].GetTag() +"\": \"" + modName + ":" + ingredients[i].name + "\"\n" +
                    ((i < ingredients.length-1) ? ("    },\n") : ("    }\n"));
        }
        //Add the resulting item, and count;
        toWrite +=
                "  },\n" +
                        "  \"result\": {\n" +
                        "    \"item\": \"" + modName + ":" + result.name + "\",\n" +
                        "    \"count\": " + result.count + "\n" +
                        "  }\n" +
                        "}";
        WriteToFile(newFile, toWrite);
    }

    public void GenerateBuildingSetRecipes(String woodName){
        //Shapeless Crafting Recipes
        GenerateShapelessCraftingRecipe(new RecipeItem(woodName + "_planks"), new RecipeItem(woodName + "_button"));
        GenerateShapelessCraftingRecipe(new RecipeItem(woodName + "_logs", true), new RecipeItem(woodName + "_planks", 4));

        //- Generate all of the Shaped BuildingSet Recipes-//
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('#', woodName + "_planks")}
                , new RecipeItem(woodName+ "_door", 3), Recipes.GetRecipe(Recipes.CraftableItems.DOOR));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_stick"), new RecipeItem('W', woodName + "_planks")}
                , new RecipeItem(woodName+ "_fence", 3), Recipes.GetRecipe(Recipes.CraftableItems.FENCE));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_stick"), new RecipeItem('W', woodName + "_planks")}
                , new RecipeItem(woodName+ "_fence_gate"), Recipes.GetRecipe(Recipes.CraftableItems.FENCE_GATE));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_planks")}
                , new RecipeItem(woodName+ "_pressure_plate"), Recipes.GetRecipe(Recipes.CraftableItems.PRESSURE_PLATE));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_planks")}
                , new RecipeItem(woodName+ "_slab", 6), Recipes.GetRecipe(Recipes.CraftableItems.SLAB));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_planks")}
                , new RecipeItem(woodName+ "_stairs", 4), Recipes.GetRecipe(Recipes.CraftableItems.STAIRS));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_planks")}
                , new RecipeItem(woodName+ "_stick", 2), Recipes.GetRecipe(Recipes.CraftableItems.STICK));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', "stripped_" + woodName + "_log")}
                , new RecipeItem("stripped_" + woodName + "_wood", 3), Recipes.GetRecipe(Recipes.CraftableItems.STRIPPED_WOOD));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_planks")}
                , new RecipeItem(woodName+ "_trapdoor", 2), Recipes.GetRecipe(Recipes.CraftableItems.TRAPDOOR));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_log")}
                , new RecipeItem(woodName+ "_wall", 6), Recipes.GetRecipe(Recipes.CraftableItems.WALL));
        GenerateShapedCraftingRecipe(new RecipeItem[] {new RecipeItem('#', woodName + "_log")}
                , new RecipeItem(woodName+ "_wood", 3), Recipes.GetRecipe(Recipes.CraftableItems.WOOD));
    }
    public void GenerateArmourSetRecipes(String blockName){
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName)}
                , new RecipeItem(blockName+ "_boots"), Recipes.GetRecipe(Recipes.CraftableItems.BOOTS));
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName)}
                , new RecipeItem(blockName+ "_chestplate"), Recipes.GetRecipe(Recipes.CraftableItems.CHESTPLATE));
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName)}
                , new RecipeItem(blockName+ "_helmet"), Recipes.GetRecipe(Recipes.CraftableItems.HELMET));
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName)}
                , new RecipeItem(blockName+ "_leggings"), Recipes.GetRecipe(Recipes.CraftableItems.LEGGINGS));
    }
    public void GenerateToolSetRecipes(String blockName){
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName), new RecipeItem('#', blockName +"_stick")}
                , new RecipeItem(blockName+ "_axe", 3), Recipes.GetRecipe(Recipes.CraftableItems.AXE));
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName), new RecipeItem('#', blockName + "_stick")}
                , new RecipeItem(blockName+ "_hoe", 3), Recipes.GetRecipe(Recipes.CraftableItems.HOE));
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName), new RecipeItem('#', blockName + "_stick")}
                , new RecipeItem(blockName+ "_pickaxe", 3), Recipes.GetRecipe(Recipes.CraftableItems.PICKAXE));
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName), new RecipeItem('#', blockName + "_stick")}
                , new RecipeItem(blockName+ "_shovel", 3), Recipes.GetRecipe(Recipes.CraftableItems.SHOVEL));
        GenerateShapedCraftingRecipe(new RecipeItem[]{new RecipeItem('X', blockName), new RecipeItem('#', blockName + "_stick")}
                , new RecipeItem(blockName+ "_sword", 3), Recipes.GetRecipe(Recipes.CraftableItems.SWORD));
    }
    
    //- Generate Recipes -//
    public static void main(String[] args) {
        Generator gen = new Generator("theancientglades");
        gen.GenerateBuildingSet("test");
        gen.GenerateArmourSet("test");
        //gen.GenerateToolSet("test");
        gen.GenerateBuildingSetRecipes("test");
        gen.GenerateArmourSetRecipes("test");
        //gen.GenerateToolSetRecipes("test");
    }
}
