<script>
    import axios from 'axios'
    import { push } from 'svelte-spa-router'
    import Modal from '../Common/Modal.svelte'

    let showModal = false

    const token = new URLSearchParams(location.search).get('code')

    const onKakaoLogin = () => {
        Kakao.Auth.authorize({
            redirectUri: 'http://localhost:8081/api/v1/users/auth/kakao/callback',
            prompts: 'login',
        })
    }
    const onNaverLogin = () => {
        const naverLoginButton = document.getElementById('naver_id_login_anchor')
        naverLoginButton.click()

        // // 접근 토큰 값 출력
        // alert(naver_id_login.oauthParams.access_token);
        // // 네이버 사용자 프로필 조회
        // naver_id_login.get_naver_userprofile("naverSignInCallback()");
        // // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
        // function naverSignInCallback() {
        //     alert(naver_id_login.getProfileData('email'));
        //     alert(naver_id_login.getProfileData('nickname'));
        //     alert(naver_id_login.getProfileData('age'));
        // }

    }

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
                    <button class="text" on:click={() => push('/init')}>시작하기</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/login')}>로그인</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/join')}>회원가입</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/main')}>메인</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/review')}>리뷰</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/contact')}>문의하기</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/board')}>게시판</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/user')}>내정보</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/board/write')}>게시판 글쓰기</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/chat')}>채팅</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={() => push('/board/detail')}>게시판 상세</button>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="title">컴포넌트</div>
            <div class="item-container">
                <div class="item button">
                    <button class="text" on:click={() => showModal = true}>팝업 호출</button>
                </div>
            </div>
            
        </div>
        

        <div class="row">
            <div class="title">로그인</div>
            <div class="item-container">
                <div class="item button">
                    <button class="text" on:click={onKakaoLogin}>카카오로그인</button>
                </div>
                <div class="item button">
                    <button class="text" on:click={onNaverLogin}>네이버로그인</button>
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

                    .text {
                        color: aliceblue;
                        font-weight: 700;
                    }
                }
            }
        }
    }
</style>