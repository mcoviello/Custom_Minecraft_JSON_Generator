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
