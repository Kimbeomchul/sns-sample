package com.mozzi.sns.repository;

import com.mozzi.sns.domain.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionEntityRepository extends JpaRepository<QuestionEntity, Long> {

}
