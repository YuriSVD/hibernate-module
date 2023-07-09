package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import models.TypeOfCar;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Enumerated(EnumType.STRING)
    private TypeOfCar type;
    private int power;
    private int prise;
    private int year;

    public Car(String model, TypeOfCar type, int power, int prise, int year) {
        this.model = model;
        this.type = type;
        this.power = power;
        this.prise = prise;
        this.year = year;
    }
}
