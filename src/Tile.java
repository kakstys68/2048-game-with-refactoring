public class Tile {
    private int value;
    private boolean used;

    public Tile(int value) {
        this.value = value;
        this.used = true;
    }
    public Tile(boolean used){
        this.value = 0;
        this.used = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
