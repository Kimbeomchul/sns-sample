<script>
	export let text = '실패했습니다.'
    import { createEventDispatcher, onDestroy } from 'svelte'

    let background;

	const dispatch = createEventDispatcher()
	const close = () => dispatch('close')

    onDestroy(() => console.log('destroy'))
</script>

<div class="modal-root-container">
    <button class="modal-background" bind:this={background} on:click={() => close()}/>
    <div class="modal-body-container">
        <div class="modal-body">
            <!-- <div class="image">😎</div> -->
            <img src="https://cdn3.emoji.gg/emojis/7882-peepo-ban.png" width="128px" height="128px" alt="peepo_ban">
            <div class="content">{text}</div>
        </div>
        <button class="modal-footer" on:click={() => close()}>
            확인
        </button>
    </div>
    
</div>

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
            position: absolute;
            bottom: 0px;
            border-radius: 20px 20px 0px 0px;
            height: 400px;
            width: 100%;
            background-color: #FFFFFF;

        }
        
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
    }
</style>