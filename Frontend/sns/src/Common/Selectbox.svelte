<script>
    import { clickOutside } from "../js/clickOutside"

    export let options, onChange

    let expanded = false
    let selected = options[0]

    const handleClickOutside = () => expanded = false
    const toggleExpand = () => expanded = !expanded
    const handleClickOption = option => {
        if(selected === option) return
        selected = option
        expanded = false
        onChange && onChange(option)
    }

</script>

<div class="selectbox-root-container"  use:clickOutside on:click_outside={handleClickOutside}>
    <div class="selected-area" on:click={toggleExpand} aria-hidden="true">
        <div class="selected">{selected}</div>
        <img src='/images/bottomArrow.png' alt='아래 화살표'/>
    </div>
    {#if expanded}
        <div class="filter-list-area">
            {#each options as option}
                <div class="filter-list" on:click={() => {handleClickOption(option)}} aria-hidden='true'>{option}</div>
            {/each}
        </div>
    {/if}
</div>

<style lang="scss">
    .selectbox-root-container {
        position: relative;
        display: flex;
        flex-direction: row;
        align-items: center;
        min-height: 18px;

        .selected-area {
            display: flex;
            flex-direction: row;
            align-items: center;
        }

        img {
            width: 11px;
            height: 10px;
            margin-left: 2px;
        }

        .selected {
            font-weight: 700;
            font-size: 12px;
            color: #737373;
        }

        .filter-list-area {
            position: absolute;
            top: 22px;
            z-index: 1;
            background: #fff;
            padding: 4px;
            display: flex;
            flex-direction: column;
            gap: 4px;
            min-width: 80px;
            color: rgba(0, 0, 0, 0.87);
            transition: box-shadow 300ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;
            border-radius: 4px;
            box-shadow: rgb(0 0 0 / 20%) 0px 2px 1px -1px, rgb(0 0 0 / 14%) 0px 1px 1px 0px, rgb(0 0 0 / 12%) 0px 1px 3px 0px;

            .filter-list {
                font-size: 12px;
                color: #737373;
            }
        }
    }
</style>