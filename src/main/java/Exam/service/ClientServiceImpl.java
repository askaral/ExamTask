package Exam.service;

import Exam.dao.ClientDao;
import Exam.dao.ClientDaoImpl;
import Exam.model.Client;

import java.util.List;

public class ClientServiceImpl implements ClientService{
    ClientDao clientDao = new ClientDaoImpl();

    @Override
    public String createTable() {
        clientDao.createTable();
        return "created... ";
    }

    @Override
    public String saveClients(Client client) {
        clientDao.saveClients(client);
        return "saved....";
    }

    @Override
    public String updateClient(Long ClientId, Client newClient) {
        clientDao.updateClient(ClientId,newClient);
        return "Updated....";
    }

    @Override
    public String deleteClient(Long client) {
        clientDao.deleteClient(client);

        return "Deleted.....";
    }

    @Override
    public Client findByClientId(Long clientId) {
       return clientDao.findByClientId(clientId);

    }

    @Override
    public List<Client> getAllClient() {
        return clientDao.getAllClient();
    }
}
