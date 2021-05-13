--testiranje admina
insert into admin (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('admin1','assfsaf','Petar','Perovic','0600001643','petargym@gmail.com','1967-06-20','0','true');
--testiranje clana
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('petarp98','fklvndf','petar','petrovic','0600456934','pp@gmail.com','1998-06-20','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('mare02','fgsdfgfg','marko','markovic','0603490567','marko@gmail.com','2002-06-20','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('mica00','ffkdkm','milica','milic','0609470123','milica@gmail.com','2000-07-15','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('micic97','cjcnsd','mica','micic','0604928954','comi@gmail.com','1997-06-05','1','true');
insert into clan (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('zoki82','cdnddinw','zoran','zoric','0601322754','zox@gmail.com','1982-01-08','1','true');
--testiranje trenera
insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('petarcoach','vajnvjfvn','pera','peric','0624120999','rape@gmail.com','1993-04-04','2','true');
insert into trener (user,lozinka,ime,prezime,telefon,email,datum_Rodjenja,uloga,aktivan)
values ('anacoach','vsansfvn','ana','anic','0621458899','ana@gmail.com','1995-12-04','2','true');
--testiranje treninga
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Osnovni trening-pocetni','0','8','4','2','Upoznajte se sa osnovama');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Osnovni trening-srednji','1','20','4','1','Nabacite masu');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Osnovni trening-napredni','2','20','4','1','Dovedite formu do savrsenstva');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Trening za pocetnike','0','8','4','2','za pocetnike');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Tone it up','0','6','4','0','Smrsajte brzo');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Dirty bulk','2','12','4','1','Nabacite masu');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Clean bulk','2','12','4','1','Nabacite ciste misice');
insert into trening (naziv,nivo_treninga,trajanje_u_nedeljama,dana_u_nedelji,tip_treninga,opis)
values ('Cut','3','8','4','0','Definicija');
--testiranje sale
insert into sala (kapacitet,oznaka) values (50,'s1');
insert into sala (kapacitet,oznaka) values (50,'s2');
insert into sala (kapacitet,oznaka) values (10,'s4');
insert into sala (kapacitet,oznaka) values (5,'s3');
insert into sala (kapacitet,oznaka) values (15,'s5');
insert into sala (kapacitet,oznaka) values (23,'s6');
--testiranje termina
insert into termin(broj_prijavljenih,cena,datum) values (0,1000,'2021-05-14');
insert into termin(broj_prijavljenih,cena,datum) values (0,1200,'2021-05-14');
insert into termin(broj_prijavljenih,cena,datum) values (0,1000,'2021-05-15');
insert into termin(broj_prijavljenih,cena,datum) values (0,1000,'2021-05-15');
insert into termin(broj_prijavljenih,cena,datum) values (0,500,'2021-05-15');
--testiranje fitnes centra
insert into fitness_centar(adresa,broj_telefona_centrale,email,naziv)
values ('Beogradska 1','025456123','aba@gmail.com','aba');
--testiranje FITNESS_CENTAR_SALE
insert into FITNESS_CENTAR_SALE (FITNESS_CENTAR_ID,SALE_ID) values (1,1);






