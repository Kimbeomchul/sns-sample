<script>
    import { onMount } from "svelte";
    import Siema from 'siema';

    export let totalPageCount = 0
    export let autoPlay = 3000
    let siema
    let controller

    let currentPageIndex = 1

    Siema.prototype.setAutoHeight = function (stopTime) {
    
        var that, timeout;
        
        that = this;
        
        function autoHeight() {
            
            var currentItems, min, max, itemHeightList, height, maxHeight, i;
            
            min = that.currentSlide;
            max =  min + that.perPage;
            itemHeightList = [];

            for (i = min; i < max; i++) {
                height = parseInt(that.innerElements[i].scrollHeight, 10);
                console.log(height);
                itemHeightList.push(height);
            }

            maxHeight = Math.max.apply(null, itemHeightList);

            that.sliderFrame.style.maxHeight = maxHeight + 'px';
        }
        
        window.addEventListener('resize', function () {
            that.sliderFrame.style.maxHeight = '';
            clearTimeout(timeout);
            timeout = setTimeout(autoHeight, 500);
        });
        autoHeight();
    };

    onMount(() => {
        const siemaOptions = {
            selector: siema,
            loop: true,
            onChange:() => {
                currentPageIndex = controller.currentSlide + 1
                console.log(controller.sliderFrame, controller.currentSlide); 
                // this.resizeHandler()
            },
            
        }

        controller = new Siema(siemaOptions);

        // controller.setAutoHeight()

        autoPlay && setInterval(right, autoPlay);
    })

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