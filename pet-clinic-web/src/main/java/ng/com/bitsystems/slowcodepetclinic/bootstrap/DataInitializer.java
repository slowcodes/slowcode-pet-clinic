package ng.com.bitsystems.slowcodepetclinic.bootstrap;

import ng.com.bitsystems.slowcodepetclinic.model.*;
import ng.com.bitsystems.slowcodepetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final SpecialityService specialityService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;



    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                           SpecialityService specialityService, VisitService visitService){
        this.ownerService = ownerService;
        this.specialityService = specialityService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
    }


    @Override
    @Transactional
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

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.add(surgery);


        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.add(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Isilomo");
        owner1.setLastName("Uchendu");
        owner1.setAddress("#3 Monaque Avenue, Ind. Layout, Enugu");
        owner1.setCity("Enugu");
        owner1.setTel("08030719203");

        Pet isilomoPet = Pet.builder()
                .name("gloria")
                .petType(dogPetType)
                .birthDate(LocalDate.now())
                .owner(owner1)
                .build();

        owner1.getPets().add(isilomoPet);
        ownerService.add(owner1);

        Owner owner2 = new Owner();
        owner2.setLastName("Eke");
        owner2.setFirstName("Olamide");
        owner2.setAddress("#3 St. James Close, Ndiora Layout, Awka");
        owner2.setCity("Onitsha");
        owner2.setTel("08030719203");

        Pet ekePet = Pet.builder()
                .name("uncleJude")
                .petType(cowPetType)
                .birthDate(LocalDate.now())
                .owner(owner2)
                .build();
        owner2.getPets().add(ekePet);
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
        vet1.getSpecialties().add(surgery);
        vetService.add(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("Nancy");
        vet2.setFirstName("Odoh");
        vet2.getSpecialties().add(dentistry);
        vetService.add(vet2);

        System.out.println("Completed vets initialization");
    }
}
