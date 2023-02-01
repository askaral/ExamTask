package Exam.dao;

import Exam.model.Client;

import java.util.List;

public interface ClientDao {

    void createTable();
    void saveClients(Client client);
    void updateClient(Long ClientId, Client newClient);
    void deleteClient(Long clientId);
    Client findByClientId(Long clientId);

    List<Client> getAllClient();
}
