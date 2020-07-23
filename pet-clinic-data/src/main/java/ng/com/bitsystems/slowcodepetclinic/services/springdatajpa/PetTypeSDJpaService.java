package ng.com.bitsystems.slowcodepetclinic.services.springdatajpa;

import ng.com.bitsystems.slowcodepetclinic.model.PetType;
import ng.com.bitsystems.slowcodepetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class PetTypeSDJpaService implements PetTypeService {
    private PetTypeService petTypeService;

    public PetTypeSDJpaService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeService.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findByID(Long aLong) {
        return petTypeService.findByID(aLong);
    }

    @Override
    public PetType add(PetType object) {
        return petTypeService.add(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeService.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeService.deleteById(aLong);
    }
}
