package ng.com.bitsystems.slowcodepetclinic.repositories;

import ng.com.bitsystems.slowcodepetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
