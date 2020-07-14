package model;

import java.time.LocalDate;

public class Pet {

    private petType petType;
    private Owner owner;
    private LocalDate birthDate;

    public model.petType getPetType() {
        return petType;
    }

    public void setPetType(model.petType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
