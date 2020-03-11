package fr.afpa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Création du driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver O.K.");
            // construction de l'url pour acceder à la base de données postgresql
            // format URL jdbc:postgresql://host:PORT/nomBDD;
            String url = "jdbc:mysql://localhost:3306/exojamal?useUnicode=true"
                    + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
                    + "serverTimezone=UTC";
            // definir le login/mdp de la bdd
            String user = "root";
            String passwd = "root";
            // création de l'objet connection
            conn = DriverManager.getConnection(url, user, passwd);
            //conn = DriverManager.getConnection(url);
            System.out.println("Connexion effective !");
            // Création d'un objet Statement
            Statement state = conn.createStatement();

            String maRequete;
            Scanner sc = new Scanner(System.in);
            System.out.println("Bienvenue");
            do {
                System.out.print("$> ");
                maRequete = sc.nextLine();
                if (maRequete.equals("/q")) {
                    break;
                }
                if (maRequete.toUpperCase().trim().startsWith("SELECT")) {
                    QueryUtils.executeSelectQuery(state, maRequete);
                } else {
                    QueryUtils.executeUpdateQuery(state, maRequete);
                }

            } while (true);
            state.close();

            System.out.println("Au revoir :-) ");

            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
