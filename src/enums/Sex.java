package enums;

/**
 * @author Hoong
 */

public enum Sex {
    MALE(1,"男"),FEMALE(2,"女");
    private int id;
    private String name;
    Sex(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static Sex getSex(int id){
        if (id==1){
            return MALE;
        }else if (id==2){
            return FEMALE;
        }
        return null;
    }
}
