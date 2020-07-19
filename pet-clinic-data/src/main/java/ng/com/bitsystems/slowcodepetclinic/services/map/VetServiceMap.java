package ng.com.bitsystems.slowcodepetclinic.services.map;

import ng.com.bitsystems.slowcodepetclinic.model.Speciality;
import ng.com.bitsystems.slowcodepetclinic.model.Vet;
import ng.com.bitsystems.slowcodepetclinic.services.SpecialityService;
import ng.com.bitsystems.slowcodepetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private SpecialityService specialityService;

    public VetServiceMap(SpecialityMapService specialityMapService) {
        this.specialityService = specialityMapService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet add(Vet object) {
        if(object.getSpecialties().size() > 0){
            object.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality addedSpecialty = specialityService.add(speciality);
                    speciality.setId(addedSpecialty.getId());
                }
            });
        }
        return super.add(object);
    }
}
