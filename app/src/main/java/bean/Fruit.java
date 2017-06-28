package bean;

/**
 * Created by TS-YFZX-CQE on 2017/6/22.
 */

public class Fruit {

    private String fruitName;
    private int fruitImageId;

    public Fruit(String fruitName, int fruitImageId) {
        this.fruitName = fruitName;
        this.fruitImageId = fruitImageId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitImageId() {
        return fruitImageId;
    }
}
