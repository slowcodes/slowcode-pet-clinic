package ng.com.bitsystems.slowcodepetclinic.model;

import java.time.LocalDate;

public class Pet {

    private petType petType;
    private Owner owner;
    private LocalDate birthDate;

    public ng.com.bitsystems.slowcodepetclinic.model.petType getPetType() {
        return petType;
    }

    public void setPetType(ng.com.bitsystems.slowcodepetclinic.model.petType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
