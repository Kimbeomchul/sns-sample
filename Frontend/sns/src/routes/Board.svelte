<script>
    import Header from "../Common/Header.svelte"

    // 임시 데이터
    const popular = [
        {
            title: '뭐죠 이건',
            commentCount: 20,
            content: '분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31'
        },
        {
            title: '알바 구함당',
            commentCount: 1,
            content: '분수대에서',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31'
        },
        {
            title: '뭐죠 이건',
            commentCount: 0,
            content: '분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31'
        },
        {
            title: '뭐죠 이건',
            commentCount: 60,
            content: '분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31'
        },
    ]
</script>

<div class="board-root-container">
    <Header header='게시판' search={true}/>
    <div class="board-popular-post">
        <div class="popular">인기글</div>
        <div class="popular-post-area">
            {#each popular as post}
                <div class="popular-post">
                    <div class="popular-post-top">
                        <div class="popular-title-area">
                            <div class="title">{post.title}</div>
                            <div class="comment-area">
                                <div class="comment-img"><img src='/images/comment.png' alt=''/></div>
                                <div class="comment-count">{post.commentCount}</div>
                            </div>
                        </div>
                        <div class="popular-content">{post.content}</div>
                    </div>
                    <div class="popular-user-area">
                        <div class="profile-img"><img src={post.profileImg} alt='' /></div>
                        <div class="user-info">
                            <div class="user-info-text black">{post.userName} 님</div>
                            <div class="user-info-text">{post.date}</div>
                        </div>
                    </div>
                </div>
            {/each}
        </div>
    </div>
    <div>
        <div></div>
    </div>
</div>

<style lang="scss">
    .board-root-container {
        .board-popular-post {
            padding-left: 24px;

            .popular {
                font-family: 'Noto Sans KR';
                font-weight: 700;
                font-size: 15px;
                letter-spacing: -0.05em;
                margin: 34px 0 16px 0;
            }

            .popular-post-area {
                display: flex;
                flex-direction: row;
                gap: 15px;

                .popular-post {
                    display: flex;
                    flex-direction: column;
                    justify-content: space-between;
                    background: #FFFFFF;
                    border: 0.5px solid #EDEDED;
                    box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.05);
                    border-radius: 24px;
                    padding: 20px;
                    width: 204px;
                    min-width: 204px;

                    .popular-title-area {
                        display: flex;
                        flex-direction: row;
                        align-items: center;
                        justify-content: space-between;

                        .title {
                            font-family: 'Noto Sans KR';
                            font-weight: 700;
                            font-size: 13px;
                            letter-spacing: -0.05em;
                        }

                        .comment-area {
                            display: flex;
                            flex-direction: row;
                            align-items: center;
                            gap: 5px;

                            .comment-img {
                                img {
                                    width: 15px;
                                    height: 15px;
                                }
                            }

                            .comment-count {
                                font-family: 'Noto Sans KR';
                                font-weight: 500;
                                font-size: 12px;
                                color: #A8D9CD;
                                letter-spacing: -0.05em;
                            }
                        }
                    }

                    .popular-content {
                        font-family: 'Noto Sans KR';
                        font-weight: 400;
                        font-size: 12px;
                        line-height: 17px;
                        letter-spacing: -0.05em;
                        color: #939393;
                        margin-top: 4px;
                        overflow: hidden;
                        text-overflow: ellipsis;
                        display: -webkit-box;
                        -webkit-line-clamp: 2;
                        -webkit-box-orient: vertical;
                    }

                    .popular-user-area {
                        display: flex;
                        flex-direction: row;
                        gap: 16px;
                        margin-top: 30px;

                        .profile-img {
                            width: 30px;
                            height: 30px;
                            border-radius: 50%;
                            overflow: hidden;
                            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

                            img {
                                width: 100%;
                                height: 100%;
                            }
                        }

                        .user-info {
                            display: flex;
                            flex-direction: column;

                            .user-info-text {
                                font-family: 'Noto Sans KR';
                                font-weight: 400;
                                font-size: 10px;
                                line-height: 14px;
                                letter-spacing: -0.05em;
                                color: #7A7A7A;

                                &.black {
                                    color: #000000;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
</style>