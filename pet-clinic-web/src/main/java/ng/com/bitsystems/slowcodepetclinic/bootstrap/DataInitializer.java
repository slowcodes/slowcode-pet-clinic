package ng.com.bitsystems.slowcodepetclinic.bootstrap;

import ng.com.bitsystems.slowcodepetclinic.model.*;
import ng.com.bitsystems.slowcodepetclinic.services.*;
import ng.com.bitsystems.slowcodepetclinic.services.map.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final SpecialityService specialityService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;

    public DataInitializer(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap,
                           PetTypeServiceMap petTypeServiceMap, SpecialityMapService specialityMapService,
                            VisitServiceMap visitServiceMap){
        this.ownerService = ownerServiceMap;
        this.specialityService = specialityMapService;
        this.vetService = vetServiceMap;
        this.petTypeService = petTypeServiceMap;
        this.visitService = visitServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().size() ==0 ){
            loadData();
        }

    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType dogPetType = petTypeService.add(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Cow");
        PetType cowPetType = petTypeService.add(petType2);

        PetType petType3 = new PetType();
        petType3.setName("Cat");
        PetType catPetType = petTypeService.add(petType3);

        Owner owner1 = new Owner();
        owner1.setFirstName("Isilomo");
        owner1.setLastName("Uchendu");
        owner1.setAddress("#3 Monaque Avenue, Ind. Layout, Enugu");
        owner1.setCity("Enugu");
        owner1.setTel("08030719203");

        Pet isilomoPet = new Pet();
        isilomoPet.setPetType(dogPetType);
        isilomoPet.setName("gloria");
        isilomoPet.setBirthDate(LocalDate.now());
        isilomoPet.setOwner(owner1);
        ownerService.add(owner1);

        Owner owner2 = new Owner();
        owner2.setLastName("Eke");
        owner2.setFirstName("Olamide");
        owner2.setAddress("#3 St. James Close, Ndiora Layout, Awka");
        owner2.setCity("Onitsha");
        owner2.setTel("08030719203");

        Pet ekePet = new Pet();
        ekePet.setName("uncleJude");
        ekePet.setBirthDate(LocalDate.now());
        ekePet.setPetType(cowPetType);
        ekePet.setOwner(owner2);
        ownerService.add(owner2);

        Visit visit = new Visit();
        visit.setPet(ekePet);
        visit.setDescription("Cunning Cow");
        visit.setLocalDate(LocalDate.now());
        visitService.add(visit);

        System.out.println("Completed owner initialization...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Ike");
        vet1.setLastName("Yinka");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.add(surgery);
        vet1.getSpecialties().add(surgery);
        vetService.add(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("Nancy");
        vet2.setFirstName("Odoh");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.add(dentistry);
        vet2.getSpecialties().add(dentistry);
        vetService.add(vet2);
        System.out.println("Completed vets initialization");
    }
}
