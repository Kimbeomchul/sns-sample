<script>
	import { pop } from 'svelte-spa-router'
    export let header, search = false, more = false
</script>

<div class="header-container">
    <div class="header-back" on:click={() => pop()} aria-hidden="true" ><img src='./images/back.png' alt='' /></div>
    <div class="header">{header}</div>
    {#if search} 
    <div class="header-search"><img src='./images/search.png' alt='' /></div>
    {:else if more}
    <div class="header-more"><img src='/images/more.png' alt='' /></div>
    {:else}
    <div class="header-search none"></div>
    {/if}
</div>

<style lang="scss">
    .header-container {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        width: calc(100vw - 60px);
        height: 53px;
        padding: 0 30px;
        background: linear-gradient(180deg, rgba(196, 196, 196, 0) 0%, rgba(196, 196, 196, 0.063) 100%);

        .header {
            font-family: 'Noto Sans KR';
            font-weight: 700;
            font-size: 16px;
        }

        .header-back {
            width: 12px;
            height: 25px;
        }

        .header-search {
            width: 23px;
            height: 25px;

            &.none {
                visibility: hidden;
            }
        }

        .header-more {
            width: 7px;
            height: 25px;
        }

        img {
            width: 100%;
            height: 100%;
        }
    }
</style>