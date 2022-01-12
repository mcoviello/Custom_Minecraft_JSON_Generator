import java.util.HashMap;

public class Recipes {
    public enum CraftableItems{
        AXE, BOOTS, CHESTPLATE, DOOR, FENCE, FENCE_GATE, HELMET ,HOE, LEGGINGS, PICKAXE, PRESSURE_PLATE, SHOVEL,
        SLAB, STAIRS, STICK, STRIPPED_WOOD, SWORD, TRAPDOOR, WALL, WOOD,
    }
    private static final HashMap<CraftableItems, Character[]> ShapedRecipes = new HashMap<>();

    //Defining the recipes for some items, so they can be accessed quickly
    static{
        ShapedRecipes.put(CraftableItems.AXE,               new Character[] {'\0','X','X','\0','X','#','\0',' ','#'});
        ShapedRecipes.put(CraftableItems.BOOTS,             new Character[] {' ',' ',' ','X',' ','X','X',' ','X'});
        ShapedRecipes.put(CraftableItems.CHESTPLATE,        new Character[] {'X','\0','X','X','X','X','X','X','X'});
        ShapedRecipes.put(CraftableItems.DOOR,              new Character[] {'\0','#','#','\0','#','#','\0','#','#'});
        ShapedRecipes.put(CraftableItems.FENCE,             new Character[] {'W','#','W','W','#','W','\0','\0','\0'});
        ShapedRecipes.put(CraftableItems.FENCE_GATE,        new Character[] {'#','W','#','#','W','#','\0','\0','\0'});
        ShapedRecipes.put(CraftableItems.HELMET,            new Character[] {'X','X','X','X',' ','X',' ',' ',' '});
        ShapedRecipes.put(CraftableItems.HOE,               new Character[] {'\0','X','X','\0',' ','#','\0',' ','#'});
        ShapedRecipes.put(CraftableItems.LEGGINGS,          new Character[] {'X','X','X','X',' ','X','X',' ','X'});
        ShapedRecipes.put(CraftableItems.PICKAXE,           new Character[] {'X','X','X',' ','#',' ',' ','#',' '});
        ShapedRecipes.put(CraftableItems.PRESSURE_PLATE,    new Character[] {'\0','#','#','\0','\0','\0','\0','\0','\0'});
        ShapedRecipes.put(CraftableItems.SHOVEL,            new Character[] {'\0','X','\0','\0','#','\0','\0','#','\0'});
        ShapedRecipes.put(CraftableItems.SLAB,              new Character[] {'#','#','#','\0','\0','\0','\0','\0','\0'});
        ShapedRecipes.put(CraftableItems.STAIRS,            new Character[] {'#',' ',' ','#','#',' ','#','#','#'});
        ShapedRecipes.put(CraftableItems.STICK,             new Character[] {'#','\0','\0','#','\0','\0','\0','\0','\0'});
        ShapedRecipes.put(CraftableItems.STRIPPED_WOOD,     new Character[] {'#','#','\0','#','#','\0','\0','\0','\0'});
        ShapedRecipes.put(CraftableItems.SWORD,             new Character[] {'\0','X','\0','\0','X','\0','\0','#','\0'});
        ShapedRecipes.put(CraftableItems.TRAPDOOR,          new Character[] {'#','#','#','#','#','#','\0','\0','\0'});
        ShapedRecipes.put(CraftableItems.WALL,              new Character[] {'#','#','#','#','#','#','\0','\0','\0'});
        ShapedRecipes.put(CraftableItems.WOOD,              new Character[] {'\0','#','#','\0','#','#','\0','\0','\0'});
    }

    public static Character[] GetRecipe(CraftableItems item){
        return ShapedRecipes.get(item);
    }
}
