package Exam.service;

import Exam.model.Client;

import java.util.List;

public interface ClientService {
    String createTable();
    String saveClients(Client client);
     String updateClient(Long ClientId, Client newClient);
    String deleteClient(Long client);
    Client findByClientId(Long clientId);

    List<Client> getAllClient();
}
