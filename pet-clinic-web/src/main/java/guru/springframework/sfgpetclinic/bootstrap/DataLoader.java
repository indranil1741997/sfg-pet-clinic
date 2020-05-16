package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        Vet vet = new Vet();
        vet.setFirstName("Indra");
        vet.setLastName("Sar");

        vetService.save(vet);
        System.out.println("Loaded Vets........");
    }
}
