package com.berkay.appmenu.repository;

import com.berkay.appmenu.entity.Menu;
import com.berkay.appmenu.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
