package marketQueues;

public class Customer {
    private static int idCount;
    public int id;
    private int goodsCount;

    public Customer(int goodsCount) {
        this.id = ++idCount;
        this.goodsCount = goodsCount;
    }

    public int getGoodsCount() {
        return this.goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "[Id: " + id + "; " + goodsCount + "]";
    }
}
