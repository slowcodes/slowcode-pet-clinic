package ng.com.bitsystems.slowcodepetclinic.repositories;

import ng.com.bitsystems.slowcodepetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
