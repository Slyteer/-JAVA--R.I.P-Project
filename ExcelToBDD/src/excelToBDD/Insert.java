package excelToBDD;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Insert {
    public Insert(){}
    public static Connection startBdd()
    {
        Bdd bdd = new Bdd("root", "", "RIP");
        Connection conn = null;
        bdd.startConnect();
        conn = bdd.getConn();
        return conn;
    }

    public boolean remuneration(String collab, String trajet, String price) throws SQLException {
        Connection conn = startBdd();
        PreparedStatement prepare = conn.prepareStatement("INSERT INTO remuneration (idCollab, idTrajet, Price) VALUES (" +
                "" + collab + "," +
                "'" + trajet + "'," +
                "'" + price + "');");
        int statut = prepare.executeUpdate();
        if (statut == 1) {
            System.out.println("Vous avez bien inséré la rémunération  dans la base de donnée");
            return true;
        } else {
            System.out.println("Il y a eu un problème lors de l'insertion de la rémunération dans la base de données");
            return false;
        }
    }


    public static void trajet(ArrayList<String> array) throws SQLException {
        Connection conn = startBdd();
        PreparedStatement prepare = conn.prepareStatement("INSERT INTO trajet (idClient, idChauffeur, heureDebut, heureFin, dateResevation, distanceTrajet, prixtrajet, debut, fin, duration) VALUES (" +
                "" + array.get(1) + "," +
                "'" + array.get(2) + "'," +
                "'" + array.get(3) + "'," +
                "'" + array.get(4) + "'," +
                "'" + array.get(5) + "'," +
                "'" + array.get(6) + "'," +
                "'" + array.get(7) + "'," +
                "'" + array.get(8) + "'," +
                "'" + array.get(9) + "'," +
                "'" + array.get(10) + "'," +
                "'" + array.get(11) + "');");
        int statut = prepare.executeUpdate();
        if (statut == 1) {
            System.out.println("Vous avez bien inséré le trajet  dans la base de donnée");

        } else {
            System.out.println("Il y a eu un problème lors de l'insertion de la rémunération dans la base de données");

        }
    }

}