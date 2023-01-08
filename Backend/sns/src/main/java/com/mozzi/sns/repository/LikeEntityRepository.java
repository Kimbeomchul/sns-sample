package com.mozzi.sns.repository;

import com.mozzi.sns.domain.entity.LikeEntity;
import com.mozzi.sns.domain.entity.PostEntity;
import com.mozzi.sns.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * packageName : com.mozzi.sns.repository
 * fileName : LikeEntityRepository
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */

@Repository
public interface LikeEntityRepository extends JpaRepository<LikeEntity, Long> {

    Optional<LikeEntity> findByUserAndPost(UserEntity user, PostEntity post);

    @Query(value = "SELECT COUNT(le) FROM LikeEntity le WHERE le.post =:post")
    Integer countByPost(PostEntity post);
}
