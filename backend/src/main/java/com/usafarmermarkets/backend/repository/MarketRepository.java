package com.usafarmermarkets.backend.repository;

import com.usafarmermarkets.backend.entities.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


// CRUD operations: create, read, update, delete
@Repository
public interface MarketRepository extends JpaRepository<Market, Integer> {
    List<Market> findByCity(String city);

}
