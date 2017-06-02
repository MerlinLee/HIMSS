package cn.edu.jlu.limf.repository;

import cn.edu.jlu.limf.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by merlin on 17-5-2.
 */
@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
    public UsersEntity findByUserAccountId(String userAccountId);
}