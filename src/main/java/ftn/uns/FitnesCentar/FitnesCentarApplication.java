package ftn.uns.FitnesCentar;

import ftn.uns.FitnesCentar.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;


@SpringBootApplication
public class FitnesCentarApplication implements CommandLineRunner {

	@Override
	public void run(String ... arg) {
		/*
		Admin admin = new Admin("sef","pass","Vlasnik","Teretane",
				"060000","sef@gmail.com",
				LocalDate.of(1967,3,12),true);
		admin.stampaj();
		Trener trener = new Trener("coach","pass","Trener","Teretane",
				"060011","glavnitrener@gmail.com",
				LocalDate.of(1990,9,12),true);
		trener.stampaj();
		Clan clan = new Clan("zola","pass","Lazar",
				"Fratric","0601234",
				"mojemail@gmail.com", LocalDate.of(1970, 2, 23),true);
		clan.stampaj();
		Trening trening = new Trening("Combat fit",NIVO.SREDNJI,
				8,4,TIP.KONDICIJA);
		trening.stampaj();
		trening.setOpis("Muscular strength, endurance, mental toughness");
		Termin termin = new Termin(trening,500,LocalDate.of(2021,5,14));
		Sala sala = new Sala(20,"A1");
		termin.dodajSalu(sala);
		termin.dodajClana(clan);
		System.out.println(termin);
		FitnessCentar fc = new FitnessCentar("Extreme","Citaonicka 14",
				"025456789","extreme@gmail.com");
		fc.dodajSaluUFC(sala);
		fc.dodajTreneraUFC(trener);
		fc.stampaj();
		System.out.println(fc);

		 */
		System.out.println("Kraj testa");
	}

	public static void main(String[] args) {
		SpringApplication.run(FitnesCentarApplication.class, args);
	}

}
