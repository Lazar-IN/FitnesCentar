package ftn.uns.FitnesCentar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Clan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false,unique = true, name = "user")
    private String koristinckoIme;

    @Column(nullable = false, name = "lozinka")
    private String lozinka;

    @Column(nullable = false, name = "ime")
    private String ime;

    @Column(nullable = false, name = "prezime")
    private String prezime;

    @Column(nullable = false, name = "telefon")
    private String kontaktTelefon;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(name="datum_Rodjenja")
    private LocalDate datumRodjenja;

    @Column(name = "uloga")
    private ULOGA uloga;

    @Column(name = "aktivan")
    private Boolean aktivan;

    public Clan() { } //TREBA

    public Clan(String koristinckoIme, String lozinka, String ime, String prezime,
                String kontaktTelefon, String email, LocalDate datumRodjenja, Boolean aktivan) {
        this.koristinckoIme = koristinckoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = ULOGA.CLAN;
        this.aktivan = aktivan;
    }

    public void stampaj()
    {
        System.out.println("------"+this.uloga+"------");
        System.out.println("Korisnicko ime: "+this.koristinckoIme);
        System.out.println("Ime: "+this.ime);
        System.out.println("Prezime: "+this.prezime);
        System.out.println("Tel: "+this.kontaktTelefon);
        System.out.println("Email: "+this.email);
        System.out.println("Datum rodjenja: "+this.datumRodjenja);
        //System.out.println("Uloga: "+this.uloga);
        System.out.print("Status: ");
        if(this.aktivan==true)
        {
            System.out.print("Aktivan");
        } else
        {
            System.out.print("Neaktivan");

        }
        System.out.println(" ");
        System.out.println(" ");
    }

    @Override
    public String toString() {
        return "Clan{" +
                "koristinckoIme='" + koristinckoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", kontaktTelefon='" + kontaktTelefon + '\'' +
                "\r\n"+
                ", email='" + email + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", uloga=" + uloga +
                ", aktivan=" + aktivan +
                '}'+"\r\n"+"\r\n";
    }
}
