package ng.com.bitsystems.slowcodepetclinic.services.map;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;
import ng.com.bitsystems.slowcodepetclinic.model.Pet;
import ng.com.bitsystems.slowcodepetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetServiceMap petServiceMap;
    private PetTypeServiceMap petTypeServiceMap;

    public OwnerServiceMap(PetServiceMap petServiceMap, PetTypeServiceMap petTypeServiceMap) {
        this.petServiceMap = petServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner add(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if (pet.getPetType().getId() == null){
                            pet.setPetType(petTypeServiceMap.add(pet.getPetType()));
                        }
                    }
                    else{
                        throw new RuntimeException("Pet type must be set");
                    }

                    if(pet.getId() == null){
                        Pet newPet = petServiceMap.add(pet);
                        pet.setId(newPet.getId());
                    }
                });

            }
            super.add(object);
        }
        else {
            return null;
        }
        return object;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String name) {
        return null;
    }
}
