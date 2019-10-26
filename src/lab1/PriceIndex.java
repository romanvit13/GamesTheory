package lab1;

class PriceIndex {

    private int index;
    private int price;

    PriceIndex(int index, int price) {
        this.index = index;
        this.price = price;
    }

    int getIndex() {
        return index;
    }

    int getPrice() {
        return price;
    }

    void setIndex(int index) {
        this.index = index;
    }

    void setPrice(int price) {
        this.price = price;
    }
}
