package ng.com.bitsystems.slowcodepetclinic.services.springdatajpa;

import ng.com.bitsystems.slowcodepetclinic.model.Vet;
import ng.com.bitsystems.slowcodepetclinic.repositories.VetRepository;
import ng.com.bitsystems.slowcodepetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class VetSDJpaService implements VetService {

    private VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findByID(Long aLong) {
        Optional<Vet> vet = vetRepository.findById(aLong);
        if(vet.isPresent()){
            return vet.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Vet add(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}