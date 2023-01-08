package com.mozzi.sns.controller;

import com.mozzi.sns.domain.Chat;
import com.mozzi.sns.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

// 챗팅 api 컨트롤러
@RequiredArgsConstructor
@RestController
public class ChatController {
    private final ChatRepository chatRepository;

    // 귓속말 할때 필요
    @CrossOrigin // cors 에러처리를 위해 어노테이션을 둠
    @GetMapping(value = "/sender/{sender}/receiver/{receiver}",produces = MediaType.TEXT_EVENT_STREAM_VALUE) // 몽고 디비에 sender와 receiver형태로 데이터 넣음 몽고 db는 java script object 형태로 데이터를 넣는데 { sender : "myoungjin", receiver : "juhuan" } 형태로 데이터 들어감
    public Flux<Chat> getMsg(@PathVariable String sender, @PathVariable String receiver){ // 해당 api는 1:1 버전 이라 사용하지 않음
        return chatRepository.mFindBySender(sender,receiver)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @CrossOrigin
    @GetMapping(value = "/chat/roomNum/{roomNum}",produces = MediaType.TEXT_EVENT_STREAM_VALUE) // 차세대 버전임 group형식으로 되어 있어 그룹 챗팅이 가능함 roomNum으로 방을 생성하고 사람들이 들어가서 챗팅 남음
    public Flux<Chat> findByRoomNum(@PathVariable Integer roomNum){ // Flux를 사용하는 이유는 데이터를 끊기지 않고 화면에 보여주기 위해서 넣은거임 흐름이라고 생각하면됨
        return chatRepository.mFindByRoomNum(roomNum)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @CrossOrigin
    @PostMapping("/chat")
    public Mono<Chat> setMsg(@RequestBody Chat chat){
        chat.setCreatedAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }

}

