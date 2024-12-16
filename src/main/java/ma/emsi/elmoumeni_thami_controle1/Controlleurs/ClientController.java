package ma.emsi.elmoumeni_thami_controle1.Controlleurs;


import ma.emsi.elmoumeni_thami_controle1.Entities.Client;
import ma.emsi.elmoumeni_thami_controle1.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Retourne la liste des clients
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.clients();
    }

    //Retourne un clinet par son ID
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    // Ajoute un client
    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    // Supprime un client
    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }


    // Mettre a kour un client existant
    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @GetMapping("/clientssearch")
    public Client getClientByName(@RequestParam String name) {
        return clientService.getClientByNom(name);
    }

}
