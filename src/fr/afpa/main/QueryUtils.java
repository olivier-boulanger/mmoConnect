package fr.afpa.main;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryUtils {

	

	public static void executeSelectQuery(Statement state, String maRequete) throws SQLException {
		try {

			ResultSet result = state.executeQuery(maRequete);

			// On récupère les MetaData ResultSetMetaData resultMeta =
			ResultSetMetaData resultMeta = result.getMetaData();
			System.out.println(
					"******************");
			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			}
			System.out.println(
					"******************");

			while (result.next()) {
				for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
					String valChamp = null;
					if(result.getObject(i)!=null) {
						valChamp=result.getObject(i).toString();
					}
					System.out.print("\t" + valChamp + "\t |");

				System.out.println(
						"******************");
			}
			}
		} catch (Exception e) {
			System.out.println("requete invalide :" + e.getMessage());
		}

	}
	public static void executeUpdateQuery(Statement state, String maRequete) {
		try {
			int nb = state.executeUpdate(maRequete);
			System.out.println("nombre de lignes modifiées : " + nb);
		} catch (Exception e) {
			System.out.println("requete invalide :" + e.getMessage());
		}
	}
}
