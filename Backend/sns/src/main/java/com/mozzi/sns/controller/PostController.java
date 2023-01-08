package com.mozzi.sns.controller;

import com.mozzi.sns.controller.request.CommentRequest;
import com.mozzi.sns.controller.request.PostCreateRequest;
import com.mozzi.sns.controller.request.PostModifyRequest;
import com.mozzi.sns.controller.response.CommentResponse;
import com.mozzi.sns.controller.response.PostResponse;
import com.mozzi.sns.controller.response.Response;
import com.mozzi.sns.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /**
     * 게시글 전체 리스트 조회
     */
    @GetMapping
    public Response<Page<PostResponse>> postList(Pageable pageable){
        return Response.success(postService.postList(pageable).map(PostResponse::fromPost));
    }

    /**
     * 내가 쓴 게시글 조회
     */

    @GetMapping("/my")
    public Response<Page<PostResponse>> myPost(Pageable pageable, Authentication authentication){
        return Response.success(postService.myPost(authentication.getName(), pageable).map(PostResponse::fromPost));
    }

    /**
     * 게시글 쓰기
     */
    @PostMapping
    public Response<Void> create(@Valid @RequestBody PostCreateRequest request, Authentication authentication){
        postService.create(request.getTitle(), request.getContent(), request.getHashtag(), authentication.getName());
        return Response.success();
    }

    /**
     * 게시글 수정
     */
    @PutMapping("/{id}")
    public Response<Void> modify(@PathVariable Long id, @RequestBody PostModifyRequest request, Authentication authentication){
        postService.modify(request.getTitle(), request.getContent(), request.getHashtag(), authentication.getName(), id);
        return Response.success();
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable Long id, Authentication authentication){
        postService.delete(authentication.getName(), id);
        return Response.success();
    }

    /**
     * 게시글 좋아요 추가 및 삭제
     */
    @PostMapping("/{id}/likes")
    public Response<Void> like(@PathVariable Long id, Authentication authentication){
        postService.like(authentication.getName(), id);
        return Response.success();
    }

    /**
     * 게시글 좋아요 조회
     */
    @GetMapping("/{id}/likes")
    public Response<Integer> likeCount(@PathVariable Long id){
        return Response.success(postService.likeCount(id));
    }

    /**
     * 게시글 댓글 추가
     */
    @PostMapping("/{id}/comments")
    public Response<Void> createComment(@PathVariable Long id, @Valid @RequestBody CommentRequest request, Authentication authentication){
        postService.createComment(id, request.getComment(), authentication.getName());
        return Response.success();
    }

    /**
     * 게시글 댓글 조회
     */
    @GetMapping("/{id}/comments")
    public Response<Page<CommentResponse>> comment(@PathVariable Long id, Pageable pageable){
        return Response.success(postService.getComments(id, pageable).map(CommentResponse::fromComment));
    }

    /**
     * 게시글 댓글 삭제
     */
    @DeleteMapping("/{id}/comments/{commentId}")
    public Response<Void> deleteComment(@PathVariable Long id,@PathVariable Long commentId, Authentication authentication){
        postService.deleteComment(id, commentId, authentication.getName());
        return Response.success();
    }
}
