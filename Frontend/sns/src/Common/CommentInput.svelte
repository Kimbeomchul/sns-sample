<script>
    export let inputColor 
</script>

<div class="comment-input-container">
    <div class="comment-input-area">
        <textarea class="comment-input {inputColor}" placeholder="댓글을 입력해주세요."/>
        <img src='/images/send-button.png' alt=''/>
    </div> 
</div>

<style lang="scss">
    .comment-input-container {
        position: fixed;
        bottom: 0px;
        width: calc(100% - 40px);
        padding: 20px;
        display: flex;
        align-items: center;
        justify-content: flex-start;
        background: #FFFFFF;
        box-shadow: 0px -4px 8px rgba(0, 0, 0, 0.04);

        .comment-input-area {
            width: 100%;
            position: relative;

            .comment-input {
                width: calc(100% - 38px);
                background: #EEEEEE;
                border-radius: 13px;
                height: 16px;
                line-height: 16px;
                border: none;
                resize: none;
                padding: 14px 28px 14px 10px;

                font-weight: 500;
                letter-spacing: -0.05em;
                font-size: 13px;

                &::placeholder {
                    color: #D7D7D7;
                }
            }

            img {
                position: absolute;
                right: 10px;
                width: 18px;
                height: 22px;
                top: calc(50% - 13px);
            }
        }
    }
</style>