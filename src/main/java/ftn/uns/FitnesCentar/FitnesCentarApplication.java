package ftn.uns.FitnesCentar;

import ftn.uns.FitnesCentar.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;


@SpringBootApplication
public class FitnesCentarApplication implements CommandLineRunner {

	@Override
	public void run(String...arg){
		Admin admin = new Admin("sef","pass","Vlasnik","Teretane",
				"060000","sef@gmail.com",
				LocalDate.of(1967,3,12),true);
		admin.stampaj();
		System.out.println(admin);
		Clan clan = new Clan("zola","pass","Lazar",
				"Fratric","0601234",
				"mojemail@gmail.com", LocalDate.of(1970, 2, 23),true);
		clan.stampaj();
		System.out.println(clan);

		System.out.println("Kraj programa.");
	}

	public static void main(String[] args) {
		SpringApplication.run(FitnesCentarApplication.class, args);
	}

}
