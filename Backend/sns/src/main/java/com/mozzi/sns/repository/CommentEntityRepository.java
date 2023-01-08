package com.mozzi.sns.repository;

import com.mozzi.sns.domain.entity.CommentEntity;
import com.mozzi.sns.domain.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * packageName : com.mozzi.sns.repository
 * fileName : CommentEntityRepository
 * author : kimbeomchul
 * date : 2023/01/08
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/08 kimbeomchul 최초 생성
 */


@Repository
public interface CommentEntityRepository extends JpaRepository<CommentEntity, Long> {

    Page<CommentEntity> findAllByPost(PostEntity post, Pageable pageable);

}
