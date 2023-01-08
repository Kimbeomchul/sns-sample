package com.mozzi.sns.repository;

import com.mozzi.sns.domain.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat,String> {
    @Tailable
    @Query("{sender:?0,receiver:?1}")
    Flux<Chat> mFindBySender(String sender, String receiver); // flux(흐름을 ) response를 유지하면서 데이터를 계속 흘려 보내기

    @Tailable // tailable을 넣어야지 db와 끊기지 않고 데이터를 넣어줌 반응형 앱임
    @Query("{roomNum:?0}")
    Flux<Chat> mFindByRoomNum(Integer roomNum); // flux(흐름을 ) response를 유지하면서 데이터를 계속 흘려 보내기
}
