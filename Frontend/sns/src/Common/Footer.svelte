<script>
    import { push } from 'svelte-spa-router'

    export let activedMenuIndex = 0
    const menus = [
        {
            id: 'home',
            name: '홈'
        },
        {
            id: 'community',
            name: '커뮤니티'
        },
        {
            id: 'chat',
            name: '채팅'
        },
        {
            id: 'user',
            name: 'my'
        },
    ]
    let activedMenu = menus[activedMenuIndex]

    const isActiveMenu = selectedMenu => selectedMenu.id === activedMenu.id
    const onClicked = menu => { 
        activedMenu = menu
        push(menu.id)
    }
    
</script>

<div class="footer-root-container">
    <div class="footer-menu-container">
        {#key activedMenu}
            {#each menus as menu}
                <button class="menu-item" on:click={() => onClicked(menu)}>
                    {#if isActiveMenu(menu)}
                        <img src= './images/footer/{menu.id}-active.svg' alt={menu.name}>
                        <span class="menu-active">{menu.name}</span>
                        {:else}
                        <img src= './images/footer/{menu.id}.svg' alt={menu.name}>
                        <span>{menu.name}</span>
                    {/if}
                </button>
            {/each}
        {/key}
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

            .menu-item {
                display: flex;
                flex-direction: column;
                gap: 3px;
                align-items: center;
                font-size: 10px;
                color: #A1A1A1;

                .menu-active {
                    color: #377375;
                }
            }

        }
    }
</style>