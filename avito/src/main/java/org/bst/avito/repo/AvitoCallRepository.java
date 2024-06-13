package org.bst.avito.repo;

import org.bst.avito.entity.UserCallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AvitoCallRepository extends JpaRepository<UserCallEntity, Long> {
    @Query("select case when count(u) > 0 then true else false end from UserCallEntity u where u.phoneNumber = :phoneNumber")
    Boolean exists(String phoneNumber);
}
