<script>
    const menus = [
        {
            name: '홈',
            image: './images/footer/home.svg',
            class: 'footer-menu-item'
        },
        {
            name: '커뮤니티',
            image: './images/footer/community.svg',
            class: 'footer-menu-item'
        },
        {
            name: '채팅',
            image: './images/footer/chat.svg',
            class: 'footer-menu-item'
        },
        {
            name: 'My',
            image: './images/footer/user.svg',
            class: 'footer-menu-item'
        },
    ]
    
    const onclicked = e => {
        console.log(e);
    }
    
</script>

<div class="footer-root-container">
    <div class="footer-menu-container">
        {#each menus as menu}
            <button class={menu.class} on:click={() => onclicked(menu)}>
                <img src={menu.image} alt={menu.name}>
                <span>{menu.name}</span>
            </button>
        {/each}
        <!-- <div class="footer-menu-item">
            <img src="./images/footer/home.svg" alt="">
            <span>홈</span>
        </div>
        <div class="footer-menu-item">
            <img src="./images/footer/community.svg" alt="">
            <span>커뮤니티</span>
        </div>
        <div class="footer-menu-item">
            <img src="./images/footer/chat.svg" alt="">
            <span>채팅</span>
        </div>
        <div class="footer-menu-item">
            <img src="./images/footer/user.svg" alt="">
            <span>내정보</span>
        </div> -->
    </div>
</div>

<style lang="scss">
    .footer-root-container {
        height: 87px;
        border-radius: 20px 20px 0px 0px;
        background: #FFFFFF;
        box-shadow: 0px -4px 8px rgba(0, 0, 0, 0.04);
        position: fixed;
        bottom: 0px;
        width: 100%;

        .footer-menu-container {
            display: flex;
            justify-content: space-evenly;
            align-items: center;
            height: 100%;

            .footer-menu-item {
                display: flex;
                flex-direction: column;
                gap: 3px;
                align-items: center;
                font-size: 10px;
                color: #A1A1A1;
            }

        }
    }
</style>