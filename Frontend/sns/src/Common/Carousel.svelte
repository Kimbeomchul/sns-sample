<script>
    import { onMount } from "svelte";
    import Siema from 'siema';

    export let autoPlay = 3000

    let siema
    let controller
    
    let totalPageCount
    let currentPageIndex = 1

    onMount(() => {
        const siemaOptions = {
            selector: siema,
            loop: true,
            onChange: () => currentPageIndex = controller.currentSlide + 1,
        }

        controller = new Siema(siemaOptions);

        totalPageCount = controller.innerElements.length

        autoHeight()
                
        autoPlay && setInterval(right, autoPlay);
    })
    
    const autoHeight = () => {
        const maxHeight = Math.max(...controller.innerElements.map(v => window.getComputedStyle(v).getPropertyValue('height').replace('px', '')))
        controller.innerElements.forEach(v => v.style.height = `${maxHeight}px`)
    }

    export const left = () => {
        controller.prev()
    }

    export const right = () => {
        controller.next()
    }
    
</script>

<div class="carousel-root-container">
    <div bind:this={siema}>
        <slot></slot>
    </div>
    <div class="paging-wrapper">
        <div class="paging">{currentPageIndex} / {totalPageCount}</div>
    </div>
</div>

<style lang="scss">
    .carousel-root-container {

        .paging-wrapper {
            margin-top: -32px;
            width: 100%;
            position: absolute;
            display: flex;
            justify-content: flex-end;
            
            .paging {
                margin-right: 13px;
                width: 26px;
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
</style>