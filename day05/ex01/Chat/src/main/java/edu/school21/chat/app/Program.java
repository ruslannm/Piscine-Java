package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.DataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        System.out.println("TEST-------");
        try{
            DataSource dataSource = new DataSource();
            MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
            Scanner scanner = new Scanner(System.in);
            Optional<Message> message;
            while (true){
                System.out.println("Enter a message ID");
                if (scanner.hasNextLong()) {
                    message = messagesRepository.findById(scanner.nextLong());
                    try {
                        System.out.println(message.toString());
                    } catch (Exception e) {
                        System.err.println("null optional returned");
                    }
                }
                else if (scanner.next().equals("exit")) {
                    break;
                } else {
                    System.out.println("ID must be number");
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}
