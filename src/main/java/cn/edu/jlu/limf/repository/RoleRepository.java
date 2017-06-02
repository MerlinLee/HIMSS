package cn.edu.jlu.limf.repository;

import cn.edu.jlu.limf.model.TRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by merlin on 17-5-2.
 */
@Repository
public interface RoleRepository extends JpaRepository<TRoleEntity, Integer> {
    @Query("SELECT 'ROLECODE' FROM TUserRoleEntity t WHERE t.userAccountId =?1")
    TRoleEntity findByRoleCode(String userAccountCode);
}
