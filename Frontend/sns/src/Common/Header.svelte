<script>
	export let header, search = false
</script>

<div class="header-container">
    <div class="header-back"><img src='./images/back.png' alt='' /></div>
    <div class="header">{header}</div>
    {#if search} 
    <div class="header-search"><img src='./images/search.png' alt='' /></div>
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

        img {
            width: 100%;
            height: 100%;
        }
    }
</style>