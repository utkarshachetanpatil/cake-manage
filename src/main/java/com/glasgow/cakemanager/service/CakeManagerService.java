package com.glasgow.cakemanager.service;

import com.glasgow.cakemanager.model.Cake;
import com.glasgow.cakemanager.repository.CakeRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CakeManagerService {

    private final CakeRepository cakeRepository;
    public CakeManagerService(final CakeRepository cakeRepository)
    {
        this.cakeRepository = cakeRepository;
    }

    public List<Cake> findCakeByName(String name) {
        return cakeRepository.findCakeByCakeName(name);
    }

    public List<Cake> findCakeByColor(String color) {
        return cakeRepository.findCakeByCakeColor(color);
    }

    public Cake getCakeById(int id)
    {
        return cakeRepository.findById(id).get();
    }

    public List<Cake> getCakeList()
    {
        List<Cake> cakes = new ArrayList<Cake>();
        cakeRepository.findAll().forEach(cake -> cakes.add(cake));
        return cakes;
    }

    public void saveCake(Cake cake)
    {
        cakeRepository.save(cake);
    }

}
