<script>
    import { push } from 'svelte-spa-router'
    import Modal from '../Common/Modal.svelte'

    let showModal = false
</script>

<div class="test-root-container">
    <div class="header-container">
        <div class="header">테스트 페이지</div>
        
    </div>
    <div class="content-container">
    
        <div class="row">
            <div class="title">페이지 이동</div>
            <div class="item-container">
                <div class="item button">
                    <button class="link" on:click={() => push('/login')}>로그인</button>
                </div>
                <div class="item button">
                    <button class="link" on:click={() => push('/join')}>회원가입</button>
                </div>
                <div class="item button">
                    <button class="link" on:click={() => push('/contact')}>문의하기</button>
                </div>
                <div class="item button">
                    <button class="link" on:click={() => push('/board')}>게시판</button>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="title">컴포넌트</div>
            <div class="item-container">
                <div class="item button">
                    <button class="link" on:click={() => showModal = true}>팝업 호출</button>
                </div>
            </div>

        </div>
    </div>

    {#if showModal}
        <Modal on:close={() => showModal = false}></Modal>
    {/if}
</div>

<style lang="scss">
    .test-root-container {
        
        .header-container {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            width: calc(100vw - 60px);
            height: 53px;
            padding: 0 30px;
    
            .header {
                font-family: 'Noto Sans KR';
                font-weight: 700;
                font-size: 16px;
            }
    
            
        }
        .content-container {
            margin-top: 50px;
            margin-left: 10%;
            margin-right: 10%;

            .row {
                margin-top: 50px;
                
                .title {
                    color: lightseagreen;
                    font-weight: bold;
                    border-bottom: 2px solid;
                }
                
                .item-container {
                    margin-top: 15px;
                    display: flex;
                    flex-wrap: wrap;
                    gap: 10px;
                }

                .item {
                    display: flex;
                    justify-content: center;
                    width: 100px;
                    height: 50px;

                    background-color: cadetblue;
                    border: cornflowerblue solid;
                    border-radius: 20px;

                    .link {
                        color: aliceblue;
                        font-weight: 700;
                    }
                }
            }
        }
    }
</style>