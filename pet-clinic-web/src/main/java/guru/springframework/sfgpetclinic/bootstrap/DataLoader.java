package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality saveRadiology = specialityService.save(radiology);
        Speciality saveSurgery = specialityService.save(surgery);
        Speciality saveDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Indranil");
        owner1.setLastName("Sarkar");
        owner1.setAddress("123 India");
        owner1.setCity("Bangalore");
        owner1.setPhone("789324234");

        Pet indranilPet = new Pet();
        indranilPet.setPetType(savedDogPetType);
        indranilPet.setOwner(owner1);
        indranilPet.setBirthDate(LocalDate.now());
        indranilPet.setName("Rosco");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kakoli");
        owner2.setLastName("Sarkar");
        owner2.setAddress("123 India");
        owner2.setCity("Bangalore");
        owner2.setPhone("8904129612");

        Pet kakoliPet = new Pet();
        kakoliPet.setPetType(savedCatPetType);
        kakoliPet.setOwner(owner2);
        kakoliPet.setBirthDate(LocalDate.now());
        kakoliPet.setName("Porter");

        ownerService.save(owner2);
        System.out.println("Loaded Owners........");

        Vet vet1 = new Vet();
        vet1.setFirstName("Indra");
        vet1.setLastName("Sarkar");
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("CK");
        vet2.setLastName("Sarkar");
        vet2.getSpecialities().add(saveSurgery);

        vetService.save(vet2);
        System.out.println("Loaded Vets........");
    }
}
