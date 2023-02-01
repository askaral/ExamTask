package Exam;

import Exam.config.JDBCConfig;
import Exam.model.Client;
import Exam.service.ClientService;
import Exam.service.ClientServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        //JDBCConfig.getConnection();
        ClientService clientService = new ClientServiceImpl();
       // System.out.println(clientService.createTable());
        //System.out.println(clientService.saveClients(new Client("Askar Almazbekov", "0555345654")));
        //System.out.println(clientService.saveClients(new Client("Kymbat Ishembekova", "0777098890")));
        //System.out.println(clientService.saveClients(new Client("Nargiza Omurzakova", "0500432234")));
        //System.out.println(clientService.saveClients(new Client("Emil Asanov", "0505789987")));
        //System.out.println(clientService.saveClients(new Client("Kubat Kasymov", "0707567765")));
       // System.out.println(clientService.findByClientId(2L));
       //clientService.getAllClient().forEach(System.out::println);
        //System.out.println(clientService.updateClient(5L, new Client("Alihan Ayakeev", "0707123456")));
        //System.out.println(clientService.deleteClient(3L));


    }
}
