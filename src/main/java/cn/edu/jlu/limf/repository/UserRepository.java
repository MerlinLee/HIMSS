package cn.edu.jlu.limf.repository;

import cn.edu.jlu.limf.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by merlin on 17-5-2.
 */
@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
    public UsersEntity findByUserAccountId(String userAccountId);

    @Modifying      // 说明该方法是修改操作
    @Transactional  // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update UsersEntity us set us.userAccountId=:quserAccountId, us.userName=:quserName, us.userAddress=:quserAddress, us.password=:qPassword where us.userId=:qId")
    public void updateUser(@Param("quserAccountId") String userAccountId, @Param("quserName") String userName,
                           @Param("quserAddress") String quserAddress, @Param("qPassword") String password, @Param("qId") Integer userId);
}