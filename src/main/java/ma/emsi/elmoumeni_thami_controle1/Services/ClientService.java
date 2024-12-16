package ma.emsi.elmoumeni_thami_controle1.Services;


import ma.emsi.elmoumeni_thami_controle1.Entities.Client;
import ma.emsi.elmoumeni_thami_controle1.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;


    public List<Client> clients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClient(Long id) {
        if (clientRepository.findById(id).isPresent()) {
            return clientRepository.findById(id).get();
        }
        return null;
    }

    public Client updateClient(Long id, Client client) {
        if (clientRepository.findById(id).isPresent()) {
            Client c = clientRepository.findById(id).get();
            c.setNom(client.getNom());
            c.setAdresse(client.getAdresse());
            c.setTel(client.getTel());
            return clientRepository.save(c);
        }
        return null;
    }

    public String deleteClient(Long id) {
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
            return String.format("Client with ID %d was deleted", id);
        }
        return String.format("Client with id %s was not found", id);
    }


    public Client getClientByNom(String nom) {
        try{
            return clientRepository.findClientByNom(nom);
        }
        catch(Exception e){
            return null;
        }
    }
}
