package fr.afpa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Autre {
	public static void main(String t[]) {

		try {
			// Création du driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver O.K.");

			// construction de l'url pour acceder à la base de données postgresql
			// format URL jdbc:postgresql://host:PORT/nomBDD;
			String url = "jdbc:postgresql://localhost:5432/tdb_bdd";
			String user = "postgres";
			String passwd = "root";
			// création de l'objet connection
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");

			// Création d'un objet Statement pour executer les requetes.
			Statement state = conn.createStatement();
//			String maRequete = "CREATE TABLE appartement (  "
//					+ "ref character varying(50)  NOT NULL, "
//					+ "superficie double precision NOT NULL, "
//					+ "prix_vente double precision, "
//					+ "secteur character varying(50), "
//					+ "coderep character varying(50) NOT NULL, "
//					+ "codeclt character varying(50) , "
//					+ "civilite character varying,  "
//					+ "CONSTRAINT appartement_pkey PRIMARY KEY (coderep))";
//			/* les requetes de M.A.J*/
//			int resultat = state.executeUpdate(maRequete);
//			System.out.println("Nbr de lignes : "+resultat);
//			//Une deuxieme requete : 
//			String maRequete2 = "INSERT INTO appartement(ref, superficie, prix_vente, secteur, coderep, codeclt) VALUES ('a1', 10,100001,2,'r5',1)";
//			resultat = state.executeUpdate(maRequete2);
//			System.out.println("Nbr de lignes : "+resultat);
//			/* les requetes de SELECT*/
			String maRequeteSelect1 = "select * from serv";
			
			ResultSet set = state.executeQuery(maRequeteSelect1);
			
			while(set.next()) {
				
				for(int i =1 ;i<=3;i++) {
					Object o = set.getObject(i);
					System.out.print(o+" !! ");
				}
				System.out.println();
			}
			
			
			conn.close();
		} catch (SQLException e) {
			
			System.out.println("Erreur : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver n'est pas compatible : " + e.getMessage());
		}

//		 
//			try {
//				
//				// construction de l'url pour acceder à la base de données postgresql
//				// format URL jdbc:postgresql://host:PORT/nomBDD;
//				String url = "jdbc:postgresql://localhost:5432/tdb_bdd";
//				// definir le login/mdp de la bdd
//				String user = "postgres";
//				String passwd = "root";
//				// création de l'objet connection
//				conn = v
//				System.out.println("Connexion effective !");
//				// Création d'un objet Statement
//				Statement state = conn.createStatement();

	}
}
