<script>
    import Header from "../../Common/Header.svelte"
    import Footer from "../../Common/Footer.svelte"
    // import { clickOutside } from '../../js/clickOutside'
    import { push } from 'svelte-spa-router'
    import Selectbox from "../../Common/Selectbox.svelte";

    // 임시 데이터
    const content = [
        {
            title: '뭐죠 이건',
            commentCount: 20,
            content: '분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31',
            likeCount: 1000
        },
        {
            title: '알바 구함당',
            commentCount: 1,
            content: '분수대에서',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31',
            likeCount: 100
        },
        {
            title: '뭐죠 이건',
            commentCount: 0,
            content: '분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31',
            likeCount: 10
        },
        {
            title: '뭐죠 이건',
            commentCount: 60,
            content: '분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31',
            likeCount: 1
        },
        {
            title: '뭐죠 이건',
            commentCount: 60,
            content: '분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31',
            likeCount: 1
        },
        {
            title: '뭐죠 이건',
            commentCount: 60,
            content: '분수대에서 뭔갈 하고있습니다 곧 할 예정이니 오세용',
            profileImg: 'https://pbs.twimg.com/media/FIbhNioakAAc_V0?format=jpg&name=medium',
            userName: '김맹맹',
            date: '2022.01.31',
            likeCount: 1
        },
    ]

    const filters = {
        new: '최신순',
        like: '좋아요순'
    }

    let selectedFilter = filters['new']
    let isLiked = false
    // let expanded = false
    let selectedCategory = 'daily'

    // const handleClickFilter = () => expanded = !expanded
    // const handleClickFilterOption = (filter) => {
    //     if(selectedFilter !== filters[filter]) expanded = false
    //     selectedFilter = filters[filter]
    // }
    // const handleClickOutside = (event) => expanded = false
    const handleClickCategory = (category) => selectedCategory = category

    const onChange = (option) => console.log(option)
</script>

<div class="board-root-container">
    <Header header='게시판' search={true}/>
    <div class="board-popular-post">
        <div class="popular">인기글</div>
        <div class="popular-post-area">
            {#each content as popular}
                <div class="popular-post">
                    <div class="popular-post-top">
                        <div class="popular-title-area">
                            <div class="title">{popular.title}</div>
                            <div class="comment-area">
                                <div class="comment-img"><img src='/images/comment.png' alt=''/></div>
                                <div class="comment-count">{popular.commentCount.toLocaleString()}</div>
                            </div>
                        </div>
                        <div class="popular-content">{popular.content}</div>
                    </div>
                    <div class="popular-user-area">
                        <div class="profile-img"><img src={popular.profileImg} alt='' /></div>
                        <div class="user-info">
                            <div class="user-info-text black">{popular.userName} 님</div>
                            <div class="user-info-text">{popular.date}</div>
                        </div>
                    </div>
                </div>
            {/each}
        </div>
    </div>
    <div class="board-filter-area">
        <div class="filter-area">
            <Selectbox options={['최신순', '좋아요순']} onChange={onChange}></Selectbox>
            <!-- <div class="filter-selected-area" use:clickOutside on:click_outside={handleClickOutside} aria-hidden="true">
                <div class="selected-area" on:click={handleClickFilter} aria-hidden="true">
                    <div class="selected">{selectedFilter}</div>
                    <img src='/images/bottomArrow.png' alt=''/>
                </div>
                {#if expanded}
                    <div class="filter-list-area">
                        <div class="filter-list" on:click={() => {handleClickFilterOption('new')}} aria-hidden='true'>최신순</div>
                        <div class="filter-list" on:click={() => {handleClickFilterOption('like')}} aria-hidden='true'>좋아요순</div>
                    </div>
                {/if}
            </div> -->
            <div class="category-area">
                <div class="category-item {selectedCategory === 'daily' && 'selected'}" on:click={() => {handleClickCategory('daily')}} aria-hidden='true'>일상</div>
                <div class="category-item {selectedCategory === 'notice' && 'selected'}" on:click={() => {handleClickCategory('notice')}} aria-hidden='true'>공지사항</div>
                <div class="category-item {selectedCategory === 'promo' && 'selected'}" on:click={() => {handleClickCategory('promo')}} aria-hidden='true'>홍보</div>
            </div>
        </div>
    </div>
    <div class="board-filter-content">
        {#each content as filter}
            <div class="filter-content-area">
                <div class="content-title">{filter.title}</div>
                <div class="content">{filter.content}</div>
                <div class="content-info-area">
                    <div class="content-info left">
                        <div class="text writer">{filter.userName}</div>
                        <div class="text date">3시간전</div>
                    </div>
                    <div class="content-info right">
                        <div class="like-area">
                            <img class="like" src='/images/heart.svg' alt=''/>
                            <div class="count">{filter.likeCount.toLocaleString()}</div>
                        </div>
                        <div class="comment-area">
                            <img class="comment" src='/images/comment.png' alt=''/>
                            <div class="count">{filter.commentCount.toLocaleString()}</div>
                        </div>
                    </div>
                </div>
            </div>
        {/each}
    </div>
    <div class="border-write-button" on:click={() => push('/board/write')} aria-hidden='true'>+</div>
    <Footer />
</div>

<style lang="scss">
    .board-root-container {
        position: relative;
        .board-popular-post {
            padding-left: 24px;

            .popular {
                font-weight: 700;
                font-size: 15px;
                letter-spacing: -0.05em;
                margin: 34px 0 16px 0;
            }

            .popular-post-area {
                display: flex;
                flex-direction: row;
                gap: 15px;
                overflow: auto;
                -ms-overflow-style: none;
                scrollbar-width: none;

                &::-webkit-scrollbar {
                    display: none;
                }

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
                                font-weight: 500;
                                font-size: 12px;
                                color: #A8D9CD;
                                letter-spacing: -0.05em;
                            }
                        }
                    }

                    .popular-content {
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

        .board-filter-area {
            padding: 40px 24px 6px 24px;
            .filter-area {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                align-items: center;

                // .filter-selected-area {
                //     position: relative;
                //     display: flex;
                //     flex-direction: row;
                //     align-items: center;
                //     min-height: 18px;

                //     .selected-area {
                //         display: flex;
                //         flex-direction: row;
                //         align-items: center;
                //     }

                //     img {
                //         width: 11px;
                //         height: 10px;
                //         margin-left: 2px;
                //     }

                //     .selected {
                //         font-weight: 700;
                //         font-size: 12px;
                //         color: #737373;
                //     }

                //     .filter-list-area {
                //         position: absolute;
                //         top: 22px;
                //         z-index: 1;
                //         background: #fff;
                //         padding: 4px;
                //         display: flex;
                //         flex-direction: column;
                //         gap: 4px;
                //         min-width: 80px;
                //         color: rgba(0, 0, 0, 0.87);
                //         transition: box-shadow 300ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;
                //         border-radius: 4px;
                //         box-shadow: rgb(0 0 0 / 20%) 0px 2px 1px -1px, rgb(0 0 0 / 14%) 0px 1px 1px 0px, rgb(0 0 0 / 12%) 0px 1px 3px 0px;

                //         .filter-list {
                //             font-size: 12px;
                //             color: #737373;
                //         }
                //     }
                // }

                .category-area {
                    display: flex;
                    flex-direction: row;
                    align-items: center;
                    gap: 6px;

                    .category-item {
                        background: #FFFFFF;
                        border: 1.5px solid #A8D9CD;
                        border-radius: 20px;
                        padding: 5px 8px;
                        font-weight: 500;
                        font-size: 11px;
                        color: #616668;
                        min-width: 40px;
                        text-align: center;

                        &.selected {
                            background-color: #377375;
                            color: #FFFFFF;
                            font-weight: 700;
                        }
                    }
                }
            }
        }

        .board-filter-content {
            padding: 0 24px 60px 24px;

            .filter-content-area {
                border-top: 1px solid #D5D5D5;
                padding: 15px 0;
            }
            .content-title {
                font-weight: 500;
                font-size: 13px;
                color: #3C3C3C;
            }

            .content {
                font-weight: 400;
                font-size: 12px;
                line-height: 17px;
                letter-spacing: -0.05em;
                color: #999999;
                margin-bottom: 5px;
            }

            .content-info-area {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                align-content: center;

                .content-info {
                    display: flex;
                    flex-direction: row;
                    align-items: center;

                    &.left {
                        .text {
                            font-weight: 400;
                            font-size: 10px;
                            line-height: 14px;
                            letter-spacing: -0.05em;
                            color: #999999;

                            &.writer {
                                margin-right: 10px;
                            }

                            &.date {
                                border-left: 1px solid #D5D5D5;
                                padding-left: 5px;
                            }
                        }
                    }

                    &.right {
                        gap: 12px;
                        .like-area, .comment-area {
                            display: flex;
                            flex-direction: row;
                            align-items: center;
                        }

                        .like {
                            width: 18px;
                            height: 15px;
                        }

                        .comment {
                            width: 15px;
                            height: 15px;
                        }

                        .count {
                            font-weight: 700;
                            font-size: 12px;
                            letter-spacing: -0.05em;
                            color: #AFAFAF;
                            margin-left: 4px;
                        }
                    }
                }
            }
        }

        .border-write-button {
            display: flex;
            align-items: center;
            justify-content: center;
            position: fixed;
            bottom: 114px;
            right: 25px;
            background: #377375;
            border-radius: 27px;
            width: 50px;
            height: 50px;
            font-weight: 700;
            font-size: 20px;
            color: white;
        }
    }
</style>