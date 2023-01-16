<script>
	export let text = '성공했습니다.'
    import { createEventDispatcher, onDestroy } from 'svelte';

	const dispatch = createEventDispatcher();
	const close = () => dispatch('close');
</script>

<div class="modal-container-wrapper">
    <div class="modal-container">
        <div class="modal-content">
            <div>😎</div>
            <div>{text}</div>
        </div>
        <button class="modal-footer" on:click={() => close()}>
            확인
        </button>
    </div>
    
    
</div>

<style lang="scss">
    .modal-container-wrapper {
        position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background: rgba(0,0,0,0.3);

        .modal-container {
            border-radius: 20px 20px 0px 0px;
            height: 400px;
            position: absolute;
            bottom: 0px;
            width: 100%;
            background-color: #FFFFFF;
    
            .modal-content {
                height: 360px;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                font-weight: 700;
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
    }
</style>