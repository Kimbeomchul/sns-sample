<script>
    import Carousel from "../Common/Carousel.svelte"
    import Footer from "../Common/Footer.svelte"
    import Header from "../Common/Header.svelte"
    import Selectbox from "../Common/Selectbox.svelte"
    
    const filterOptions = ['전체', '카페', '음식점', '편의점', '가볼만한 곳', '청년창업']
    let selectedFilter = filterOptions[0]
</script>

<div class="main-root-container">
    <Header header='과처니' search=true></Header>
    <Carousel>
        <div class="main-recommand-container">
            <div class="title">
                올 겨울엔 딸기 카페 어때요?
            </div>
            <div class="content">
                천 명의 과처니가 사랑한 카페
            </div>
            <div class="hashtag-container">
                <div class="hashtag">#딸기</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이곰돌이곰돌이</div>
                <div class="hashtag">#딸기</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이</div>
            </div>
        </div>
        <div class="main-recommand-container">
            <div class="title">
                올 겨울엔 딸기 카페 어때요?
            </div>
            <div class="content">
                천 명의 과처니가 사랑한 카페
            </div>
            <div class="hashtag-container">
                <div class="hashtag">#딸기</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이곰돌이곰돌이</div>
            </div>

        </div>
        <div class="main-recommand-container">
            <div class="title">
                올 겨울엔 딸기 카페 어때요?
            </div>
            <div class="content">
                천 명의 과처니가 사랑한 카페
            </div>
            <div class="hashtag-container">
                <div class="hashtag">#딸기</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이곰돌이곰돌이</div>
                <div class="hashtag">#딸기</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이</div>
                <div class="hashtag">#케이크</div>
                <div class="hashtag">#곰돌이</div>
            </div>
        </div>
    </Carousel>
    <div class="main-content-container">
        <div class="board-filter-container">
            {#each filterOptions as option}
                <button class="filter-item" class:selected={selectedFilter === option} on:click={() => selectedFilter = option}>{option}</button>
            {/each}
        </div>
        <div class="board-order-container">
            <Selectbox options={['거리순', '추천순']}></Selectbox>
            <div class="near-container">
                <img src="./images/track.svg" alt="">
                <span class="near">내 주변</span>
            </div>
        </div>
        
        <div class="board-list-container">
            <div class="board-container">
                <img class="board-image" src="/images/board/board.png" alt="">
                <div class="board-info-container">
                    <div class="title-container">
                        <span class="title">
                            오로라 커피오로라 커피오로라 커피오로라 커피
                        </span>
                        <span class="category">
                            카페/디저트
                        </span>
                    </div>
                    <span class="operating-hours">
                        매주 일요일 휴무
                    </span>
                    <div class="etc-menu-list-container">
                        <div class="etc-menu-container">
                            <img src="/images/board/distance.svg" alt="">
                            <span class="amount">790m</span>
                        </div>
                        <div class="etc-menu-container">
                            <img src="/images/board/heart.svg" alt="">
                            <span class="amount">1,000</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="board-container">
                <img class="board-image" src="/images/board/board.png" alt="">
                <div class="board-info-container">
                    <div class="title-container">
                        <span class="title">
                            오로라 커피
                        </span>
                        <span class="category">
                            카페/디저트
                        </span>
                    </div>
                    <span class="operating-hours">
                        매주 일요일 휴무
                    </span>
                    <div class="etc-menu-list-container">
                        <div class="etc-menu-container">
                            <img src="/images/board/distance.svg" alt="">
                            <span class="amount">790m</span>
                        </div>
                        <div class="etc-menu-container">
                            <img src="/images/board/heart.svg" alt="">
                            <span class="amount">1,000</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <Footer></Footer>
</div>

<style lang="scss">
    .main-root-container {
        margin-bottom: 97px;

        .main-recommand-container {
            padding: 37px 13px 4px 20px;
            background: linear-gradient(0deg, rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)), url('/images/main-sample.png');
            color: #FFFFFF;

            .title {
                font-family: 'Inter';
                font-weight: 700;
                font-size: 18px;
                line-height: 22px;
            }
            
            .content {
                margin-top: 4px;
                font-family: 'Inter';
                font-weight: 500;
                font-size: 13px;
                line-height: 16px;

            }

            .hashtag-container {
                padding-bottom: 62px;
                margin-top: 10px;
                display: flex;
                flex-wrap: wrap;
                gap: 5px;

                .hashtag {
                    padding: 0 5px;
                    min-width: 50px;
                    height: 21px;
                    border: 1px solid #FFFFFF;
                    border-radius: 11.5px;
                    font-weight: 500;
                    font-size: 11px;
                    line-height: 21px;
                    text-align: center;
                    letter-spacing: -0.05em;

                }
            }
        }

        .main-content-container {
            margin: 14px 6% 0;
            
            .board-filter-container {
                display: flex;
                gap: 4px;
                height: 22px;
                overflow-x: auto;

                .filter-item {
                    flex-shrink: 0;
                    
                    min-width: 42px;
                    padding: 0px 5px;
                    height: 21px;
                    line-height: 21px;
                    
                    border: 1px solid #A8D9CD;
                    border-radius: 10px;

                    font-weight: 500;
                    font-size: 11px;
                    text-align: center;
                    letter-spacing: -0.05em;
                    color: #848B8D;

                    &.selected {
                        background: #377375;
                        color: #FFFFFF;
                    }
                }

                &::-webkit-scrollbar {
                    display: none;
                }
            }

            .board-order-container {
                margin-top: 12px;
                margin-left: 2px;
                display: flex;
                justify-content: space-between;

                .near-container {
                    display: flex;
                    align-items: center;

                    .near {
                        margin-left: 3px;
                        margin-bottom: 1px;
                        font-weight: 500;
                        font-size: 11px;
                        letter-spacing: -0.05em;
                        color: #616668;
                    }
                }
            }

            .board-list-container {
                margin-top: 12px;
                display: flex;
                flex-direction: column;
                gap: 30px;
                align-items: center;
                
                .board-container {
                    width: 100%;
                    max-width: 300px;
                    // height: 238px;
                    border: 1.7px solid #FFFFFF;
                    border-radius: 10px;
                    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
                    overflow: hidden;
                    
                    .board-image {
                        height: 153px;
                        width: 100%;
                    }
    
                    .board-info-container {
                        margin: 17px 14px 12px 20px;

                        .title-container {
                            display: flex;
                            align-items: center;
                            
                            .title {
                                font-family: 'Inter';
                                font-weight: 700;
                                font-size: 20px;
                                line-height: 24px;
                                max-width: 70%;
                                display: block;
                                overflow: hidden;
                                text-overflow: ellipsis;
                                white-space: nowrap;
                            }
    
                            .category {
                                margin-left: 7px;
                                font-size: 10px;
                                line-height: 14px;
                                color: #6C6C6C;
                            }
                        }

                        .operating-hours {
                            font-weight: 500;
                            font-size: 12.5px;
                            color: #AFAFAF;
                        }
    
                        .etc-menu-list-container {
                            display: flex;
                            justify-content: flex-end;
                            gap: 10px;

                            .etc-menu-container {
                                display: flex;
                                align-items: center;
                                gap: 4px;

                                .amount {
                                    font-weight: 700;
                                    font-size: 14px;
                                    line-height: 20px;
                                    letter-spacing: -0.05em;
    
                                    color: #AFAFAF;
                                }
                            }

                        }
                    }
                    }

            }
        }
    }

</style>