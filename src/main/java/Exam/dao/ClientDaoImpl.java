package Exam.dao;

import Exam.config.JDBCConfig;
import Exam.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao{

    private Connection connection;

    public ClientDaoImpl() {
        this.connection = JDBCConfig.getConnection();
    }

    @Override
    public void createTable() {

        String query = """
                create table clients(
                id serial primary key,
                full_name varchar (50) ,
                phone_number varchar (25) unique )""";

        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void saveClients(Client client) {

        String insQuery = """
                insert into clients(full_name, phone_number)
                values(?,?);""";
        try {
           PreparedStatement preparedStatement =  connection.prepareStatement(insQuery);
           preparedStatement.setString(1,client.getFullName());
           preparedStatement.setString(2,client.getPhoneNumber());
           preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateClient(Long ClientId, Client newClient) {
        String query = """
                update clients 
                set full_name = ?,
                phone_number = ?
                 where id = ?""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,newClient.getFullName());
            preparedStatement.setString(2,newClient.getPhoneNumber());
            preparedStatement.setLong(3, ClientId);
            int g = preparedStatement.executeUpdate();
            if(g>0){
                System.out.println("Updated....");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteClient(Long clientId) {
        String query = """
                delete from clients 
                where id = ?""";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, clientId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Client findByClientId(Long clientId) {
        String query = """
                select * from clients where id = ?""";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,clientId);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
                Client client = new Client();
            while (resultSet.next()) {
                client.setId(resultSet.getLong("id"));
                client.setFullName(resultSet.getString(2));
                client.setPhoneNumber(resultSet.getString(3));
            }
            resultSet.close();
            return client;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> allClients = new ArrayList<>();
        String query = """
                select * from clients;""";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

           while (resultSet.next()){
               Client client = new Client();
               client.setId(resultSet.getLong("id"));
               client.setFullName(resultSet.getString(2));
               client.setPhoneNumber(resultSet.getString(3));
               allClients.add(client);
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allClients;
    }
}
