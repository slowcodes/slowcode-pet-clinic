package ng.com.bitsystems.slowcodepetclinic.services.springdatajpa;

import ng.com.bitsystems.slowcodepetclinic.model.Speciality;
import ng.com.bitsystems.slowcodepetclinic.repositories.SpecialtiesRepository;
import ng.com.bitsystems.slowcodepetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class VetSpecialtySDJpaService implements SpecialityService {
    private SpecialtiesRepository specialtiesRepository;

    public VetSpecialtySDJpaService(SpecialtiesRepository specialtiesRepository) {
        this.specialtiesRepository = specialtiesRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtiesRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findByID(Long aLong) {
        Optional<Speciality> speciality =specialtiesRepository.findById(aLong);
        if(speciality.isPresent()){
            return speciality.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Speciality add(Speciality object) {
        return specialtiesRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtiesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtiesRepository.deleteById(aLong);
    }
}
