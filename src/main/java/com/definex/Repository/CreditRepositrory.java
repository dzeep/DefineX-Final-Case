package com.definex.Repository;


import com.definex.Model.Credit;
import com.definex.dto.CreditDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepositrory extends CrudRepository<Credit, Long> {
    @Query("SELECT t FROM Credit t WHERE t.identityNumber = ?1")
    Credit findByIdentityNumber(String identityNumber);

}
