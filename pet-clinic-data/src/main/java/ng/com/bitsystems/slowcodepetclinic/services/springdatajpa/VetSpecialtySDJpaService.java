package ng.com.bitsystems.slowcodepetclinic.services.springdatajpa;

import ng.com.bitsystems.slowcodepetclinic.model.Speciality;
import ng.com.bitsystems.slowcodepetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

public class VetSpecialtySDJpaService implements SpecialityService {
    private SpecialityService specialityService;

    public VetSpecialtySDJpaService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityService.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findByID(Long aLong) {
        return specialityService.findByID(aLong);
    }

    @Override
    public Speciality add(Speciality object) {
        return specialityService.add(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityService.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityService.deleteById(aLong);
    }
}
