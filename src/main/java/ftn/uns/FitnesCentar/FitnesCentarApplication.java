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
		System.out.println("Testiranje klase admin");
		Admin admin = new Admin("sef","gfdgsdf","Vlasnik","Teretane",
				"060000","sef@gmail.com",
				LocalDate.of(1967,3,12),true);
		admin.stampaj();
		System.out.println(admin);
		System.out.println("Testiranje klase clan");
		Clan clan = new Clan("zola","pass","Lazar",
				"Fratric","0601234",
				"mojemail@gmail.com", LocalDate.of(1970, 2, 23),true);
		clan.stampaj();
		System.out.println(clan);
		System.out.println("Testiranje klase trening");
		Trening trening = new Trening("Combat fit",NIVO.SREDNJI,
				8,4,TIP.KONDICIJA);
		trening.stampaj();
		trening.setOpis("Muscular strength, endurance, mental toughness");
		trening.stampaj();
		System.out.println(trening);
		System.out.println("Testiranje klase trener");
		Trener trener = new Trener("coach","pass","Vojin","Vojinovic",
				"0609011","glavnitrener@gmail.com",
				LocalDate.of(1990,9,12),true);
		trener.stampaj();
		trener.dodajTreningNaListu(trening);
		trener.stampaj();
		trener.stampajListuTreninga();
		System.out.println(trener);
		System.out.println("Testiranje klase termin");
		Termin termin = new Termin(trening,500,LocalDate.of(2021,5,14));
		termin.dodajClana(clan);
		termin.stampaj();
		System.out.println(termin);
		termin.ukloniClana(clan);
		termin.stampaj();
		System.out.println(termin);
		System.out.println("Testiranje klase sala");
		Sala sala = new Sala(20,"A1");
		sala.stampaj();
		sala.dodajTermin(termin);
		sala.stampaj();
		System.out.println(sala);
		System.out.println("Testiranje klase fitnesCentar");
		FitnessCentar fc = new FitnessCentar("Extreme","Citaonicka 14",
				"025456789","extreme@gmail.com");
		fc.stampaj();
		fc.dodajSalu(sala);
		fc.dodajTrenerra(trener);
		fc.stampaj();
		System.out.println(fc);
		System.out.println("Testiranje klase ocena");
		Ocena ocena = new Ocena(5,termin,clan,trener);
		System.out.println(ocena);
		clan.oceni(termin,trener,4);
		clan.oceni(termin,trener,41);
		trener.stampaj();
		System.out.println("Testiranje klase fitnesCentar");
		fc.trenerDodajeTermin(trener,termin,sala);
		fc.pregledTermina();

		System.out.println("Kraj testiranja.");
	}

	public static void main(String[] args) {
		SpringApplication.run(FitnesCentarApplication.class, args);
	}

}
