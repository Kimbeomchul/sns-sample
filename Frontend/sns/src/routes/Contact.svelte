<script>
    import Header from "../Common/Header.svelte"
</script>

<div class="contact-root-container">
    <Header header='문의하기'/>
    <div class="contact-content-container">
        <div class="contact-form">
            <div class="input-row">
                <div class="input-name">답변 받으실 이메일</div>
                <div class="input-wrap">
                    <input class="input" type="text" placeholder="이메일 주소를 입력해주세요">
                </div>
            </div>
            <div class="input-row">
                <div class="input-name">문의 유형</div>
                <div class="input-wrap">
                    <input class="input" type="text" value="로그인 불가" disabled>
                </div>
            </div>
            <div class="input-row">
                <div class="input-name">문의 내용</div>
                <div class="textarea-wrap">
                    <textarea class="contact-content" placeholder="아이디와 로그인 불가 사유를 입력해주세요"></textarea>
                </div>
            </div>
        </div>
        <div class="button submit-button">
            <span>제출하기</span>
        </div>
    </div>
</div>

<style lang="scss">
    .contact-root-container {
        
        .contact-content-container {
            margin-left: 10%;
            margin-right: 10%;

            .contact-form {
                margin-top: 62px;
                
                .input-row {
                    margin-top: 15px;
                    
                    .input-name {
                        line-height: 19px;
                        color: #3B3B3B;
                        font-weight: 500;
                        font-size: 13px;
                        letter-spacing: -0.05em;
                    }
                    
                    .input-wrap {
                        margin-top: 8px;
                        .input {
                            font-size: 13px;
                            letter-spacing: -0.05em;
                            line-height: 19px;
                            border: unset;
                            border-bottom: solid 1px;
                            border-color: #EDEDED;
                            width: 100%;
                            letter-spacing: -0.05em;
                            padding-bottom: 5px;
                            font-weight: 500;
                        }

                        .input::placeholder {
                            color: #D6D6D6;
                        }

                        .input:disabled {
                            color: #377375;
                        }
                    }

                    .textarea-wrap {
                        margin-top: 11px;

                        .contact-content {
                            background: #DEEFE3;
                            border-radius: 10px;
                            width: 100%;
                            min-height: 170px;
                            resize: none;
                        }
                    }

                }
            }

            .submit-button {
                margin-top: 30px;
                border-radius: 27px;
                background-color: #377375;
                height: 53px;
                display: flex;
                align-items: center;
                justify-content: center;
                color: #FFFFFF;
            }



        }


    }
</style>