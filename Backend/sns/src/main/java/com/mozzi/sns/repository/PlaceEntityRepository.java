package com.mozzi.sns.repository;

import com.mozzi.sns.domain.entity.PlaceEntity;
import com.mozzi.sns.domain.entity.PostEntity;
import com.mozzi.sns.domain.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.mozzi.sns.repository
 * fileName : PlaceEntityRepository
 * author : myoungjinkang
 * date : 2023/01/12
 * description :
 * ===========================================================
 * DATE    AUTHOR    NOTE
 * -----------------------------------------------------------
 * 2023/01/12 myoungjinkang 최초 생성
 */

@Repository
public interface PlaceEntityRepository extends JpaRepository<PlaceEntity, Long> {

}
