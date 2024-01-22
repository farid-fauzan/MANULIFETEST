package com.manulife.rest.respository;

import com.manulife.rest.entity.Catatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CatatanRepository extends JpaRepository <Catatan, Long> {

    @Query(value = "SELECT * FROM catatan WHERE id =:id" , nativeQuery = true)
    Catatan findByid(@Param("id") Long id);
}
