package cn.edu.jlu.limf.repository;

import cn.edu.jlu.limf.model.THealthRecordEntity;
import cn.edu.jlu.limf.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by merlin on 17-5-6.
 */
public interface THealthRecordRepository extends JpaRepository<THealthRecordEntity, Integer> {
    public List<THealthRecordEntity> findByUserAccountId(String AccountID);
}
