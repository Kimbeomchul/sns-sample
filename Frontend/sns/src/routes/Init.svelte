<script>
    import { push, querystring } from "svelte-spa-router";
    import { ROUTE } from '../Common/constant'

    const onKakaoLogin = () => {
        Kakao.Auth.authorize({
            redirectUri: 'http://localhost:8081/api/v1/users/auth/kakao/callback',
            // prompts: 'login',
        })
    }

    const onNaverLogin = () => {
        const naverLoginButton = document.getElementById('naver_id_login_anchor')
        naverLoginButton.click()
    }

</script>

<div class="init-root-container">
    <div class="logo-container">
        <img src="./images/logo.svg" alt="">
        <div class="logo">과처니</div>
    </div>
    <div class="social-login-container">
        <button on:click={onKakaoLogin}>
            <img class="login_button" src="./images/login/kakao.svg" alt="">
        </button>
        <button on:click={onNaverLogin}>
            <img class="login_button" src="./images/login/naver.svg" alt="">
        </button>
        <button on:click={() => push(ROUTE.LOGIN)}>
            <img class="login_button" src="./images/login/email.svg" alt="">
        </button>
        <button class="contact-wrapper" on:click={() => push(ROUTE.CONTACT)}>
            <span class="contact">로그인이 안돼요</span>
        </button>
    </div>
</div>

<style lang="scss">
    .init-root-container {
        margin-left: 10%;
        margin-right: 10%;
        
        .logo-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            margin-top: 100px;

            .logo {
                margin-top: 20px;
                font-family: 잘난체;
                font-size: 50px;
                color: palevioletred;
            }
        }
        
        .social-login-container {
            margin: auto;
            max-width: 318px;
            margin-top: 100px;
            
            .contact-wrapper {
                width: 100%;
                margin-top: 13px;
                margin-right: 10px;
                text-align: end;

                .contact {
                    font-weight: 700;
                    font-size: 13px;
                    line-height: 19px;
                    letter-spacing: -0.05em;
                    color: #A8A8A8;
                }
            }
        }

        @media (max-width: 400px) {
                .login_button {
                    width: 100%;
                }
            }
    }
</style>