<div class="modal-body">
    <img src="https://cdn3.emoji.gg/emojis/7882-peepo-ban.png" width="128px" height="128px" alt="peepo_ban">
    <div class="content">test입니둥!</div>
</div>
<button class="modal-footer" on:click={() => close()}>
    확인
</button>

<style lang="scss">
    .modal-body {
        height: 360px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        font-weight: 700;

        .content {
            margin-top: 20px;
        }
    }
    
    .modal-footer {
        height: 43px;
        background-color: #377375;
        display: flex;
        justify-content: center;
        align-items: center;
        font-weight: 700;
        font-size: 14px;
        color: #FFFFFF;
        width: 100%;
    }
</style>