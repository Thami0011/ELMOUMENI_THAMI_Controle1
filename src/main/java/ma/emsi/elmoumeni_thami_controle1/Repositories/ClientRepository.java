package ma.emsi.elmoumeni_thami_controle1.Repositories;

import ma.emsi.elmoumeni_thami_controle1.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByNom(String nom);
}
