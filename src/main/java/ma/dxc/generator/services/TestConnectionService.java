package ma.dxc.generator.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import ma.dxc.generator.model.TestConnection;

@Service
public class TestConnectionService {
	public String  teste(TestConnection t) {
		String r;
		String url = "jdbc:mysql://"+t.getLienserveur()+"/"+t.getNombd();
		String username = t.getNomutilisateur();
		String password = t.getMotdepasseutilisateur();

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		   r=("Database connected!");
		   //r=("CC");
		   
		   System.out.println(r);
		} catch (SQLException e) {
		   r="Cannot connect the database!";
		   // r="NN";
		    System.out.println(r);
		}
		
		return r;
	}

}
