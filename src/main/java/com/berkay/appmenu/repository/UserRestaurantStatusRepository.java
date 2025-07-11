package com.berkay.appmenu.repository;

import com.berkay.appmenu.entity.UserRestaurantStatus;
import com.berkay.appmenu.entity.User;
import com.berkay.appmenu.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRestaurantStatusRepository extends JpaRepository<UserRestaurantStatus, Long> {
	

Optional<UserRestaurantStatus> findByUserIdAndRestaurantIdAndStatus(Long userId, Long restaurantId, UserRestaurantStatus.Status status);

Optional<UserRestaurantStatus> findByUserIdAndRestaurantId(Long userId, Long restaurantId);

  
}
