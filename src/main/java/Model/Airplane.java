package Model;

public class Airplane {
    private String id;
    private String model;
    private String serialNumber;
    private int seatCount;

    public Airplane(String id, String model, String serialNumber, int seatCount) {
        this.id = id;
        this.model = model;
        this.serialNumber = serialNumber;
        this.seatCount = seatCount;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getSeatCount() {
        return seatCount;
    }
}
