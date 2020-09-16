package com.glasgow.cakemanager.repository;

import com.glasgow.cakemanager.model.Cake;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CakeRepository extends CrudRepository<Cake,Integer> , JpaSpecificationExecutor<Cake> {

    List<Cake> findCakeByCakeName(String name);
    List<Cake> findCakeByCakeColor(String color);
}
