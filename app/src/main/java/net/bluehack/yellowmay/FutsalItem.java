package net.bluehack.yellowmay;

/**
 * Created by k_bluehack on 2016. 9. 27..
 */

public class FutsalItem {

    private int img;
    private String name;
    private String distance;
    private String charge;

    public FutsalItem(int img, String name, String distance, String charge) {
        this.img = img;
        this.name = name;
        this.distance = distance;
        this.charge = charge;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
