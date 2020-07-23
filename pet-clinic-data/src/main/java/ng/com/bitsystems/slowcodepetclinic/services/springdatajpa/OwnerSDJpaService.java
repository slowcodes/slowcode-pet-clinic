package ng.com.bitsystems.slowcodepetclinic.services.springdatajpa;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;
import ng.com.bitsystems.slowcodepetclinic.repositories.OwnerRepository;
import ng.com.bitsystems.slowcodepetclinic.repositories.PetRepository;
import ng.com.bitsystems.slowcodepetclinic.repositories.VisitRepository;
import ng.com.bitsystems.slowcodepetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class OwnerSDJpaService implements OwnerService {
    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private VisitRepository visitRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository,
                             PetRepository petRepository, VisitRepository visitRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.visitRepository = visitRepository;
    }

    @Override
    public Owner findByLastName(String name) {
        return ownerRepository.findByLastName(name);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findByID(Long id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        if(ownerOptional.isPresent()){
            return ownerOptional.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Owner add(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
