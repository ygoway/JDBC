package Model;

import java.util.Date;
import java.util.List;

public class Pilot {
    private String id;
    private String name;
    private int age;
    private Date birthDate;
    private List<Airplane> airplanes;

    public Pilot(String id, String name, int age, Date birthDate, List<Airplane> airplanes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.airplanes = airplanes;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }
}
