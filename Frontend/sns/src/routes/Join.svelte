<script>
    import axios from "axios";
    import Header from "../Common/Header.svelte"

    let id = 'joohwan', password = '1234', nickName = '주환'

    const join = () => {
        axios.post('http://localhost:8081/api/v1/users/join', {
            userName: id,
            password,
            nickName
        }).then((res) => {
            if(res.resultCode === 'OK') {
                axios.post('http://localhost:8081/api/v1/users/login', {
                    userName: id,
                    password,
                    nickName
                }).then(res => {
                    console.log(res);
                })
            }
        })
    }
</script>

<div class="join-root-container">
    <Header header='회원가입'/>
    <div class="join-content-container">
        <div class="main-content">
            <div>
                <span class="logo">과처니</span><span>를 이용하기 위한</span>
            </div>
            <div>
                <span>추가 정보를 입력해주세요.</span>
            </div>
        </div>
        <div class="sub-content">
            <div>
                <span>아래의 정보는 과처니 서비스 이용목적 외에</span>
            </div>
            <div>
                <span>사용되지 않음을 알려드립니다.</span>
            </div>
        </div>
        <div class="join-form">
            <div class="input-row">
                <div class="input-name">아이디</div>
                <div class="input-container inner-button">
                    <input class="input" type="text" placeholder="아이디를 입력해주세요"bind:value={id}>
                    <div class="duplicate-check button">중복확인</div>
                </div>
            </div>
            <div class="input-row">
                <div class="input-name">비밀번호</div>
                <div class="input-container">
                    <input class="input" type="password" placeholder="비밀번호를 입력해주세요" bind:value={password}>
                </div>
            </div>
            <div class="input-row">
                <div class="input-name">닉네임</div>
                <div class="input-container">
                    <input class="input" type="text" placeholder="비밀번호를 입력해주세요" bind:value={nickName}>
                </div>
            </div>
        </div>
        <button class="join-button" on:click={join}>
            <span>회원가입</span>
        </button>
    </div>
</div>

<style lang="scss">
    .join-root-container {
        
        .join-content-container {
            margin-left: 10%;
            margin-right: 10%;

            .main-content {
                margin-top: 60px;
                color: #3C3C3C;
                line-height: 36px;
                letter-spacing: -0.05em;
                font-weight: 700;
                font-size: 25px;


                .logo {
                    font-family: '잘난체';
                    color: violet;
                }
            }

            .sub-content {
                margin-top: 8px;
                font-size: 15px;
                line-height: 22px;
                letter-spacing: -0.05em;

                color: #9B9B9B;
            }

            .join-form {
                margin-top: 25px;
    
                .input-row {
                    margin-top: 15px;
                }
                
                .input-name {
                    line-height: 19px;
                    color: #3B3B3B;
                    font-size: 13px;
                    letter-spacing: -0.05em;
                    font-weight: 500;
                }
                
                .input-container {
                    margin-top: 8px;
                    .input {
                        line-height: 19px;
                        border: unset;
                        border-bottom: solid 1px;
                        border-color: #EDEDED;
                        width: 100%;
                        letter-spacing: -0.05em;
                        padding-bottom: 5px;
                        font-size: 13px;
                        letter-spacing: -0.05em;
                        font-weight: 500;
                    }
                    
                    .input::placeholder {
                        color: #D6D6D6;
                    }

                    .duplicate-check {
                        position: absolute;
                        width: 75.19px;
                        height: 23px;
                        right: 0px;
                        bottom: 8px;

                        display: flex;
                        align-items: center;
                        justify-content: center;
                        
                        border: 1px solid #A8D9CD;
                        border-radius: 11.5px;
                        letter-spacing: -0.05em;
                        line-height: 16px;
                        font-size: 11px;
                        color: #A8D9CD;
                        font-weight: 500;
                    }
                }

                .inner-button {
                    position: relative;
                }
                
            }

            .join-button {
                width: 100%;
                margin-top: 90px;
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
