<script>
    import { each } from "svelte/internal";
    import Footer from "../Common/Footer.svelte";
    import Header from "../Common/Header.svelte";
    import Selectbox from "../Common/Selectbox.svelte";
    
    const filterOptions = ['전체', '카페', '음식점', '편의점', '가볼만한 곳', '청년창업']
    let selectedFilter = filterOptions[0]
</script>

<div class="main-root-container">
    <Header header='과처니' search=true></Header>
    <div class="main-recommand-container">
        <div class="title">
            올 겨울엔 딸기 카페 어때요?
        </div>
        <div class="content">
            천 명의 과처니가 사랑한 카페
        </div>
        <!-- <div class="hashtag-container">
            <div class="hashtag">#딸기</div>
            <div class="hashtag">#케이크</div>
            <div class="hashtag">#곰돌이곰돌이곰돌이</div>
            <div class="hashtag">#딸기</div>
            <div class="hashtag">#케이크</div>
            <div class="hashtag">#곰돌이</div>
            <div class="hashtag">#케이크</div>
            <div class="hashtag">#곰돌이</div>
        </div> -->
        <div class="paging-wrapper">
            <div class="paging">1 / 3</div>
        </div>
    </div>
    <div class="main-board-container">
        <div class="main-board-filter-container">
            {#each filterOptions as option}
                <button class="filter-item" class:selected={selectedFilter === option} on:click={() => selectedFilter = option}>{option}</button>
            {/each}
        </div>
        <div class="main-board-order-container">
            <Selectbox options={['거리순', '추천순']}></Selectbox>
            <div class="near-container">
                <img src="./images/track.svg" alt="">
                <span class="near">내 주변</span>
            </div>
        </div>

    </div>
    <Footer></Footer>
</div>

<style lang="scss">
    .main-root-container {
        .main-recommand-container {
            padding: 37px 13px 10px 20px;
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

            .paging-wrapper {
                display: flex;
                justify-content: flex-end;
                margin-top: 42px;
                min-width: 40px;

                .paging {
                    padding: 2px 12px;
                    border: 1px solid #616668;
                    border-radius: 11.5px;
                    font-weight: 500;
                    font-size: 9px;
                    text-align: center;
                    letter-spacing: -0.05em;
                    color: #E2E2E2;
                    background: rgba(97, 102, 104, 0.7);
                }
            }
        }

        .main-board-container {
            margin: 14px 6% 0px;
            
            .main-board-filter-container {
                display: flex;
                gap: 4px;
                height: 30px;
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

            .main-board-order-container {
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
        }
    }

</style>