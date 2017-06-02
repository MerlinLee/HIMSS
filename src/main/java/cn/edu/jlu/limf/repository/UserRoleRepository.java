package cn.edu.jlu.limf.repository;

import cn.edu.jlu.limf.model.TUserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by merlin on 17-5-5.
 */
public interface UserRoleRepository extends JpaRepository<TUserRoleEntity,Integer> {
    public TUserRoleEntity findByUserAccountId(String userAccountID);
}
