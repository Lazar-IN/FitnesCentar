package ftn.uns.FitnesCentar.service;

import ftn.uns.FitnesCentar.entity.Clan;
import ftn.uns.FitnesCentar.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanService {

    @Autowired
    private ClanRepository clanRepository;

    public Clan findOne(Long id){
        Clan clan = this.clanRepository.getOne(id);

        return clan;
    }

    public List<Clan> findAll() {
        List<Clan> clans = this.clanRepository.findAll();

        return clans;
    }

    public Clan save(Clan clan){
        return this.clanRepository.save(clan);
    }

    public void delete(Long id){
        this.clanRepository.deleteById(id);
    }

    public Clan update(Clan clan) throws Exception{
        Clan clanToUpdate = this.clanRepository.getOne(clan.getId());

        if (clanToUpdate == null){
            throw new Exception("Clan ne postoji!");
        }

        clanToUpdate.setKorisnickoIme(clan.getKorisnickoIme());
        clanToUpdate.setIme(clan.getIme());
        clanToUpdate.setPrezime(clan.getPrezime());
        clanToUpdate.setDatumRodjenja(clan.getDatumRodjenja());
        clanToUpdate.setEmail(clan.getEmail());
        clanToUpdate.setUloga(clan.getUloga());
        clanToUpdate.setAktivan(clan.getAktivan());

        Clan savedCl = this.clanRepository.save(clanToUpdate);

        return savedCl;
    }
}
