package ng.com.bitsystems.slowcodepetclinic.bootstrap;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;
import ng.com.bitsystems.slowcodepetclinic.model.Vet;
import ng.com.bitsystems.slowcodepetclinic.services.OwnerService;
import ng.com.bitsystems.slowcodepetclinic.services.VetService;
import ng.com.bitsystems.slowcodepetclinic.services.map.OwnerServiceMap;
import ng.com.bitsystems.slowcodepetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    //private final PetService petService;
    private final VetService vetService;

    public DataInitializer(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap){
        this.ownerService = ownerServiceMap;
        //petService = new PetServiceMap();
        this.vetService = vetServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Isilomo");
        owner1.setLastName("Uchendu");

        ownerService.add(owner1);

        Owner owner2 = new Owner();
        owner2.setLastName("Eke");
        owner2.setFirstName("Olamide");

        ownerService.add(owner2);

        System.out.println("Completed owner initialization...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ike");
        vet1.setLastName("Yinka");

        vetService.add(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("Nancy");
        vet2.setFirstName("Odoh");

        vetService.add(vet2);
        System.out.println("Completed vets initialization");
    }
}
