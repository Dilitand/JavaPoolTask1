package ru.litvinov.javapool.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "auto")
public class Auto {
    /*MODEL,MAXSPEED,MILEAGE*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "model")
    String model;
    @Column(name = "maxspeed")
    int maxspeed;
    @Column(name = "mileage")
    int mileage;

    public Auto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", maxspeed=" + maxspeed +
                ", mileage=" + mileage +
                '}';
    }
}
