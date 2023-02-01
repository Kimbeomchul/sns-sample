<script>
</script>

<div class="init-root-container">
    <div class="logo-container">
        <img src="./images/logo.svg" alt="">
        <div class="logo">과처니</div>
    </div>
    <div class="social-login-container">
        <img class="login_button" src="./images/login/kakao.svg" alt="">
        <img class="login_button" src="./images/login/naver.svg" alt="">
        <img class="login_button" src="./images/login/email.svg" alt="">
        <div class="contact-wrapper">
            <div class="contact">로그인이 안돼요</div>
        </div>
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
            
            .login_button {
                margin-top: 10px;
            }

            .contact-wrapper {
    
                .contact {
                    margin-top: 13px;
                    margin-right: 10px;
                    font-weight: 500;
                    font-size: 13px;
                    line-height: 19px;
                    letter-spacing: -0.05em;
                    color: #A8A8A8;
                    text-align: end;
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