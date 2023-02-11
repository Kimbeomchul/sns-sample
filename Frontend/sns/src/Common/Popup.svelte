<script>
    import { clickOutside } from "../js/clickOutside";
    export let isPopupOpen = false

    const close = () => isPopupOpen = false
    const handleClickOutside = () => expanded = false
</script>
   
  {#if isPopupOpen}
    <div class="popup-background" on:click={close} aria-hidden="true"></div>
    <div class="popup-root-container" use:clickOutside on:click_outside={handleClickOutside}>
      <div class="popup-body">
        <div class="popup-close" on:click={close} aria-hidden="true">x</div>
        <div class="popup-content">
            <div class="content-left">
                <div class="town">1단지</div>
                <div class="user">과천 예솔맘 님 <img src="/images/report.png" alt=''/></div>
            </div>
            <div class="content-right">
                <img src="https://pbs.twimg.com/media/FdFxDv2aEAMqRfK?format=jpg&name=large" alt=''/>
            </div>
        </div>
        <div class="popup-button">
            <div class="button">채팅하기</div>
            <div class="button">이웃신청</div>
        </div>
      </div>
    </div>
  {/if}

<style lang="scss">
    .popup-background {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(203, 203, 203, 0.7);
    }
    .popup-root-container {
        position: absolute;
		left: 50%;
		top: 50%;
		width: 203px;
		max-width: 32em;
		max-height: calc(100vh - 4em);
		overflow: auto;
		transform: translate(-50%,-50%);
		padding: 22px;
		border-radius: 0.2em;
		background: white;
        border-radius: 10px;
        
        .popup-body {
            position: relative;

            .popup-close {
                position: absolute;
                top: -17px;
                right: -12px;
                font-size: 14px;
            }

            .popup-content {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                align-items: center;

                .content-left {
                    .town {
                        background: #A8D9CD;
                        border-radius: 20px;
                        font-family: 'Inter';
                        font-weight: 700;
                        font-size: 10px;
                        width: 50px;
                        height: 18px;
                        line-height: 18px;
                        text-align: center;
                        color: #2A484E;
                    }

                    .user {
                        margin-top: 9px;
                        font-family: 'Inter';
                        font-weight: 700;
                        font-size: 17px;
                        color: #000000;
                        display: flex;
                        flex-direction: row;
                        align-items: center;

                        img {
                            margin-left: 3px;
                        }
                    }
                }

                .content-right {
                    img {
                        border: 2px solid #DEEFE3;
                        border-radius: 10px;
                        width: 60px;
                        height: 60px;
                    }
                }
            }

            .popup-button {
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-content: center;
                gap: 14px;
                margin-top: 15px;

                .button {
                    width: 95px;
                    height: 31px;
                    background: #377375;
                    border-radius: 20px;
                    font-family: 'Inter';
                    font-weight: 700;
                    font-size: 12px;
                    line-height: 15px;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    color: #FFFFFF;
                }
            }
        }
        
    }
</style>