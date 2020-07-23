package ng.com.bitsystems.slowcodepetclinic.services.springdatajpa;

import ng.com.bitsystems.slowcodepetclinic.model.Pet;
import ng.com.bitsystems.slowcodepetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class PetSDJpaService implements PetService {
    private PetService petService;

    public PetSDJpaService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petService.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findByID(Long aLong) {
        return petService.findByID(aLong);
    }

    @Override
    public Pet add(Pet object) {
        return petService.add(object);
    }

    @Override
    public void delete(Pet object) {
        petService.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petService.deleteById(aLong);
    }
}
