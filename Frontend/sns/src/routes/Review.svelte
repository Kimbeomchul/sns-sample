<script>
    import Header from "../Common/Header.svelte"
    import Popup from "../Common/Popup.svelte";

    let isPopupOpen = false
</script>

<div class="review-root-container">
    <Header header={'장소'}/>
    <div class="review-wrapper">
        <div class="review-area">
            <div class="user-info">
                <img class="profile" on:click={() => isPopupOpen = true} src='https://pbs.twimg.com/media/FdFxDv2aEAMqRfK?format=jpg&name=large' alt='' aria-hidden="true"/>
                <div class="review-info">
                    <div class="review-info-top">
                        <div class="name">과천예솔맘</div>
                        <div class="date">∙ 43분 전</div>
                    </div>
                    <div class="review">예솔이가 싫어하잖아!!!!</div>
                    <div class="like-count">좋아요 {1}</div>
                </div>
            </div>
            <img class="review-more" src='/images/more-gray.png' alt='' />
        </div>
        <div class="review-area">
            <div class="user-info">
                <img class="profile" src='https://pbs.twimg.com/media/FdFxDv2aEAMqRfK?format=jpg&name=large' alt=''/>
                <div class="review-info">
                    <div class="review-info-top">
                        <div class="name">과천예솔맘</div>
                        <div class="date">∙ 43분 전</div>
                    </div>
                    <div class="review">예솔이가 싫어하잖아!!!!</div>
                    <div class="like-count">좋아요 {1}</div>
                </div>
            </div>
            <img class="review-more" src='/images/more-gray.png' alt='' />
        </div>
        <div class="review-area">
            <div class="user-info">
                <img class="profile" src='https://pbs.twimg.com/media/FdFxDv2aEAMqRfK?format=jpg&name=large' alt=''/>
                <div class="review-info">
                    <div class="review-info-top">
                        <div class="name">과천예솔맘</div>
                        <div class="date">∙ 43분 전</div>
                    </div>
                    <div class="review">예솔이가 싫어하잖아!!!!</div>
                    <div class="like-count">좋아요 {1}</div>
                </div>
            </div>
            <img class="review-more" src='/images/more-gray.png' alt='' />
        </div>
    </div>
    <Popup bind:isPopupOpen />
</div>

<style lang="scss">
    .review-root-container {
        .review-wrapper {
            padding: 23px 25px;
            display: flex;
            flex-direction: column;
            gap: 20px;

            .review-area {
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

                    .review-info {
                        .review-info-top {
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

                        .review {
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
</style>