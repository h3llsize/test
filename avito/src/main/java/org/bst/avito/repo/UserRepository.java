package org.bst.avito.repo;

import org.bst.avito.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select case when count(u) > 0 then true else false end from UserEntity u where u.id = :id")
    Boolean exists(@Param("id") Long userId);
}
