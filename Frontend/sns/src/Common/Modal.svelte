<script context="module">
    let Test
    let scrollY
    let prevBodyPosition
    let prevBodyOverflow
    let prevBodyWidth
    export const open = component => {
        Test = component
        disableScroll()
    }

    const disableScroll = () => {
        scrollY = window.scrollY
        prevBodyPosition = document.body.style.position
        prevBodyOverflow = document.body.style.overflow
        prevBodyWidth = document.body.style.width
        document.body.style.position = 'fixed'
        document.body.style.top = `-${scrollY}px`
        document.body.style.overflow = 'hidden'
        document.body.style.width = '100%'
    }
</script>

<script>
	// export let text = '실패했습니다.'
    import { createEventDispatcher, onDestroy, onMount } from 'svelte'
	
    let background;

    const enableScroll = () => {
        document.body.style.position = prevBodyPosition || ''
        document.body.style.top = ''
        document.body.style.overflow = prevBodyOverflow || ''
        document.body.style.width = prevBodyWidth || ''
        window.scrollTo(0, scrollY)
    };

	const dispatch = createEventDispatcher()
	const close = () => dispatch('close')
    let isMount = false

    $: {
        if (isMount) {
            open()
        }
    }
    onMount(() => isMount = true)
    onDestroy(() => isMount = false)
</script>

{#if Test}
    
    <div class="modal-root-container">
        <button class="modal-background" bind:this={background} on:click={() => close()}/>
        <div class="modal-body-container">
            asdf
            <!-- <Test /> -->
            <svelte:component this={Test}/>
        </div>
    </div>
{/if}

<style lang="scss">
    .modal-root-container {
        
        .modal-background {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.3);
            
        }

        .modal-body-container {
            position: fixed;
            bottom: 0px;
            border-radius: 20px 20px 0px 0px;
            height: 400px;
            width: 100%;
            background-color: #FFFFFF;

        }
    }
</style>