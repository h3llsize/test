package org.bst.avito.repo;

import org.bst.avito.entity.UserChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvitoChatRepository extends JpaRepository<UserChatEntity, String> {
    @Query("select case when count(u) > 0 then true else false end from UserChatEntity u where u.id = :id")
    Boolean exists(@Param("id") String chatId);
}
