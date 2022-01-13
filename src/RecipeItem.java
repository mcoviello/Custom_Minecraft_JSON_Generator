/***
 * RecipeItem
 *
 * This class is used to store recipe items for crafting recipes.
 * It stores the Symbol used in the crafting recipe to represent the material,
 * The Name of the item, the Count of the items required / returned, and
 * whether or not the item refers to a tag, or a specific item.
 *
 * This is mainly used for more readable code when defining crafting recipes.
 *
 * Authored by Michael Coviello, 2022
 */

public class RecipeItem {
    public Character symbol;
    public String name;
    public int count;
    private final String tag;

    RecipeItem(String name){
        this.name = name;
        symbol = ' ';
        count = 1;
        tag = "item";
    }
    RecipeItem(String name, int count){
        this.name = name;
        symbol = ' ';
        this.count = count;
        tag = "item";
    }
    RecipeItem(String name, boolean isTag){
        this.name = name;
        symbol = ' ';
        this.count = 1;
        tag = (isTag) ? "tag" : "item";
    }
    RecipeItem(String name, int count, boolean isTag){
        this.name = name;
        symbol = ' ';
        this.count = count;
        tag = (isTag) ? "tag" : "item";
    }
    RecipeItem(Character symbol, String name){
        this.symbol = symbol;
        this.name = name;
        tag = "item";
        count = 1;
    }
    RecipeItem(Character symbol, String name, int count){
        this.symbol = symbol;
        this.name = name;
        this.count = count;
        tag = "item";
    }
    RecipeItem(Character symbol, String name, boolean isTag){
        this.symbol = symbol;
        this.name = name;
        tag = (isTag) ? "tag" : "item";
        count = 1;
    }
    RecipeItem(Character symbol, String name, int count, boolean isTag){
        this.symbol = symbol;
        this.name = name;
        this.count = count;
        tag = (isTag) ? "tag" : "item";
    }

    public String GetTag(){
        return tag;
    }
}
