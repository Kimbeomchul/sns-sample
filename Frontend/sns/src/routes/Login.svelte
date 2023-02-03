<script>
    import { push } from "svelte-spa-router";
    import { ROUTE } from "../Common/constant";
    import Header from "../Common/Header.svelte"
</script>

<div class="login-root-container">
    <Header header='로그인'/>
    <div class="login-content-container">
        <div class="logo">과처니</div>
        <div class="login-form">
            <div class="input-row">
                <div class="input-name">아이디</div>
                <div class="input-wrapper">
                    <input class="input" type="text" placeholder="아이디를 입력해주세요">
                </div>
            </div>
            <div class="input-row">
                <div class="input-name">비밀번호</div>
                <div class="input-wrapper">
                    <input class="input" type="text" placeholder="비밀번호를 입력해주세요">
                </div>
            </div>
        </div>
        <div class="join-warp">
            <button on:click={() => push(ROUTE.JOIN)}>
                <span class="button join">회원가입 하기</span>
            </button>
        </div>
        <div class="button login-button">
            <span>로그인</span>
        </div>
    </div>
</div>

<style lang="scss">
    .login-root-container {
        
        .login-content-container {
            margin-left: 10%;
            margin-right: 10%;
            
            .logo {
                margin-top: 45px;
                text-align: center;
                font-family: '잘난체';
                color: violet;
                font-size: 45px;
            }
            
            .login-form {
                margin-top: 55px;
    
                .input-row {
                    margin-top: 15px;
                    
                    .input-name {
                        line-height: 19px;
                        color: #3B3B3B;
                        font-weight: 500;
                        font-size: 13px;
                        letter-spacing: -0.05em;
                    }
                }

                
                .input-wrapper {
                    margin-top: 8px;

                    .input {
                        line-height: 19px;
                        border: unset;
                        border-bottom: solid 1px;
                        border-color: #EDEDED;
                        width: 100%;
                        letter-spacing: -0.05em;
                        padding-bottom: 5px;
                        font-weight: 500;
                        font-size: 13px;
                        letter-spacing: -0.05em;
                    }
                    
                    .input::placeholder {
                        color: #D6D6D6;
                    }
                }
            }
    
    
            .join-warp {
                margin-top: 15px;
                text-align: end;

                .join {
                    letter-spacing: -0.05em;
                    color: #A8A8A8;
                    font-weight: 500;
                    font-size: 13px;
                    letter-spacing: -0.05em;
                }
            }

            .login-button {
                margin-top: 21px;
                border-radius: 27px;
                background-color: #377375;
                height: 53px;
                display: flex;
                align-items: center;
                justify-content: center;
                color: #FFFFFF;
                font-weight: 700;
            }
        }


    }
</style>