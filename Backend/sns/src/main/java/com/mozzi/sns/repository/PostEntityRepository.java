package com.mozzi.sns.repository;

import com.mozzi.sns.domain.entity.PostEntity;
import com.mozzi.sns.domain.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.mozzi.sns.repository
 * fileName : PostEntityRepository
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {

    Page<PostEntity> findAllByUser(UserEntity user, Pageable pageable);

}
