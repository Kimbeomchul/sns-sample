<script>
    import Header from "../../Common/Header.svelte"
    import Footer from "../../Common/CommentInput.svelte"
</script>

<div class="boarder-detail-root-container">
    <Header more={true}></Header>
    <div class="border-detail-area">
        <div class="category-area">
            <div class="category">커뮤니티</div>
            <div class="category">커뮤</div>
        </div>
        <div class="border-detail">
            <div class="title">아니 세상 참 좁다 ㅎ 그래 너, 동은아</div>
            <div class="content">아니 세상 참 좁다 ㅎ 그래 너, 동은아 아니 세상 참 좁다 ㅎ 그래 너, 동은아 아니 세상 참 좁다 ㅎ 그래 너, 동은아 아니 세상 참 좁다 ㅎ 그래 너, 동은아 아니 세상 참 좁다 ㅎ 그래 너, 동은아 아니 세상 참 좁다 ㅎ 그래 너, 동은아</div>
            <div class="detail-info">
                <div class="info-area">
                    <img class="like" src='/images/heart.svg' alt=''/>
                    <div class="text">9999</div>
                </div>
                <div class="info-area">
                    <img class="comment" src='/images/comment.png' alt=''/>
                    <div class="text">12</div>
                </div>
                <div class="info-area">
                    <img class="report" src='/images/report.png' alt=''/>
                    <div class="text">신고하기</div>
                </div>
            </div>
            <div class="comment-list-area">
                <div class="comment-area">
                    <div class="user-info">
                        <img class="profile" src='https://pbs.twimg.com/media/FdFxDv2aEAMqRfK?format=jpg&name=large' alt=''/>
                        <div class="comment-info">
                            <div class="comment-info-top">
                                <div class="name">과천예솔맘</div>
                                <div class="date">∙ 43분 전</div>
                            </div>
                            <div class="comment">예솔이가 싫어하잖아!!!!</div>
                            <div class="like-count">좋아요 {1}</div>
                        </div>
                    </div>
                    <img class="comment-more" src='/images/more-gray.png' alt='' />
                </div>
                <div class="comment-area">
                    <div class="user-info">
                        <img class="profile" src='https://pbs.twimg.com/media/FdFxDv2aEAMqRfK?format=jpg&name=large' alt=''/>
                        <div class="comment-info">
                            <div class="comment-info-top">
                                <div class="name">과천예솔맘</div>
                                <div class="date">∙ 43분 전</div>
                            </div>
                            <div class="comment">예솔이가 싫어하잖아!!!!</div>
                            <div class="like-count">좋아요 {1}</div>
                        </div>
                    </div>
                    <img class="comment-more" src='/images/more-gray.png' alt='' />
                </div>
                <div class="comment-area">
                    <div class="user-info">
                        <img class="profile" src='https://pbs.twimg.com/media/FdFxDv2aEAMqRfK?format=jpg&name=large' alt=''/>
                        <div class="comment-info">
                            <div class="comment-info-top">
                                <div class="name">과천예솔맘</div>
                                <div class="date">∙ 43분 전</div>
                            </div>
                            <div class="comment">예솔이가 싫어하잖아!!!!</div>
                            <div class="like-count">좋아요 {1}</div>
                        </div>
                    </div>
                    <img class="comment-more" src='/images/more-gray.png' alt='' />
                </div>
                <div class="comment-area">
                    <div class="user-info">
                        <img class="profile" src='https://pbs.twimg.com/media/FdFxDv2aEAMqRfK?format=jpg&name=large' alt=''/>
                        <div class="comment-info">
                            <div class="comment-info-top">
                                <div class="name">과천예솔맘</div>
                                <div class="date">∙ 43분 전</div>
                            </div>
                            <div class="comment">예솔이가 싫어하잖아!!!!</div>
                            <div class="like-count">좋아요 {1}</div>
                        </div>
                    </div>
                    <img class="comment-more" src='/images/more-gray.png' alt='' />
                </div>
            </div>
        </div>
    </div>
    <Footer />
</div>

<style lang="scss">
    .boarder-detail-root-container {
        .border-detail-area {
            padding: 26px;
            display: flex;
            flex-direction: column;

            .category-area {
                display: flex;
                flex-direction: row;
                align-items: center;
                padding: 10px 0;
                gap: 10px;

                .category {
                    background: #377375;
                    border: 1px solid #DEEFE3;
                    border-radius: 10px;
                    font-weight: 700;
                    font-size: 11px;
                    text-align: center;
                    letter-spacing: -0.05em;
                    color: #FFFFFF;
                    padding: 5px 8px;
                    min-width: 56px;
                }
            }

            .border-detail {
                padding: 10px 0;

                .title {
                    padding-bottom: 10px;
                    font-family: 'Inter';
                    font-weight: 700;
                    font-size: 20px;
                }

                .content {
                    padding-bottom: 15px;
                    font-family: 'Inter';
                    font-weight: 400;
                    font-size: 15px;
                    line-height: 18px;
                }

                .detail-info {
                    padding: 15px 0;
                    display: flex;
                    flex-direction: row;
                    align-items: center;
                    justify-content: space-around;
                    border-bottom: 1px solid #D5D5D5;

                    .info-area {
                        display: flex;
                        flex-direction: row;
                        align-items: center;
                        gap: 6px;

                        .text {
                            font-weight: 700;
                            font-size: 12px;
                            text-align: right;
                            letter-spacing: -0.05em;
                            color: #AFAFAF;
                        }
                    }
                }

                .comment-list-area {
                    display: flex;
                    flex-direction: column;
                    gap: 15px;
                    margin: 16px 0;

                    .comment-area {
                        display: flex;
                        flex-direction: row;
                        justify-content: space-between;
                        align-items: center;

                        .user-info {
                            display: flex;
                            flex-direction: row;
                            align-items: center;
                            gap: 10px;

                            .profile {
                                width: 36px;
                                height: 36px;
                                border-radius: 50%;
                            }

                            .comment-info {
                                .comment-info-top {
                                    display: flex;
                                    flex-direction: row;
                                    align-items: baseline;

                                    .name {
                                        font-family: 'Inter';
                                        font-weight: 400;
                                        font-size: 10px;
                                        color: #616768;
                                    }

                                    .date {
                                        font-weight: 400;
                                        font-size: 10px;
                                        letter-spacing: -0.05em;
                                        color: #939393;
                                        margin-left: 4px;
                                    }
                                }

                                .comment {
                                    font-family: 'Inter';
                                    font-weight: 400;
                                    font-size: 12px;
                                    padding: 3px 0;
                                }

                                .like-count {
                                    font-family: 'Inter';
                                    font-weight: 100;
                                    font-size: 9px;
                                    color: #616768;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
</style>