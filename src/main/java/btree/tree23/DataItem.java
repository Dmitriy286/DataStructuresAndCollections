package btree.tree23;

public class DataItem {

    public long data;

    public DataItem(long data) {
        this.data = data;
    }

    public void displayItem() {
        System.out.print("/" + data);
    }
}
