package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("Indranil");
        owner.setLastName("Sarkar");

        ownerService.save(owner);
        System.out.println("Loaded Owners........");

        Vet vet = new Vet();
        vet.setId(1);
        vet.setFirstName("Indra");
        vet.setLastName("Sar");

        vetService.save(vet);
        System.out.println("Loaded Vets........");
    }
}
