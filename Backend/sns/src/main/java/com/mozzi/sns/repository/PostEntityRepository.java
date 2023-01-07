package com.mozzi.sns.repository;

import com.mozzi.sns.domain.entity.PostEntity;
import com.mozzi.sns.domain.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {

    Page<PostEntity> findAllByUser(UserEntity user, Pageable pageable);

}
