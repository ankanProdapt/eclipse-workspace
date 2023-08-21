package pokemons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Pokemons {
	public static void main(String[] args) {
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		Map<String, String> pokemonType = new HashMap<>();
		Map<String, List<String>> pokemonMoves = new HashMap<>();
		
		try {
			cnx = DriverManager.getConnection("jdbc:mysql://localhost: 3306/pokemons", "ankan2001prodapt", "we1c@me1");
			stmt = cnx.createStatement();
			rs = stmt.executeQuery("SELECT  * from pokemons");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String type = rs.getString("primaryType");
				pokemonType.put(name, type);
				pokemonMoves.put(name, new ArrayList<String>());
			}
			
			
			System.out.println("Pokemon     Primary Type      Moves");
			for(String name: pokemonType.keySet()) {
				
				String command = "select moves.name as move "
						+ "from moves, pokemons, mapper "
						+ "where pokemons.name = '" + name + "' and "
						+ "pokemons.id = mapper.pokemonId and moves.id = mapper.moveId";
				rs = stmt.executeQuery(command);
				
				while(rs.next()) {
					pokemonMoves.get(name).add(rs.getString("move"));
				}
				
				System.out.println(name + "       " + pokemonType.get(name) + 
									"       " + pokemonMoves.get(name));
				
			}
			
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
