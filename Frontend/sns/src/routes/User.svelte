<script>
    import Footer from "../Common/Footer.svelte";
    import Header from "../Common/Header.svelte";
    

</script>

<div class="user-root-container">
    <Header header='과처니'></Header>
    <div class="user-info-container">
        <div class="post">
            <span>3333+</span>
            <span>게시글</span>
        </div>
        <div class="user-profile-container">
            <!-- <div class="profile-image">
                <img src="./images/네이버로그인.svg" alt="">
            </div> -->
            <img class="profile-image" src="./images/profile-sample.svg" alt="">
            <div class="user-name">
                <span>김맴맴양</span>
                <div class="temp">
                    <span>1단지</span>
                </div>
            </div>
        </div>
        <div class="neighbor">
            <span>3</span>
            <span>이웃</span>
        </div>
    </div>
    <div class="profile-update-wrapper">
        <button class="profile-update">프로필 수정</button>
    </div>
    <div class="menu-container">
        <button class="menu-wrapper">
            <div class="menu">
                <img class="icon" src="./images/contact.svg">
                <span class="menu-name">1:1 문의</span>
                <img class="arrrow-right" src="./images/arrow-right.svg">
            </div>
        </button>
        <button class="menu-wrapper">
            <div class="menu">
                <img class="icon" src="./images/setting.svg">
                <span class="menu-name">개발자</span>
                <img class="arrrow-right" src="./images/arrow-right.svg">
            </div>
        </button>
        <button class="menu-wrapper">
            <div class="menu">
                <img class="icon" src="./images/setting.svg">
                <span class="menu-name">설정</span>
                <img class="arrrow-right" src="./images/arrow-right.svg">
            </div>
        </button>
    </div>
    <Footer activedMenuIndex=3/>
</div>

<style lang="scss">
    .user-root-container {
        margin-bottom: 87px;

        .user-info-container {
            margin-top: 43px;
            display: flex;
            align-items: center;
            justify-content: space-evenly;
            font-weight: 700;
            font-size: 16px;
            letter-spacing: -0.05em;
            color: #3C3C3C;

            .post {
                display: flex;
                flex-direction: column;
                text-align: center;
                min-width: 45px;
            }

            .user-profile-container {
                display: flex;
                flex-direction: column;
                text-align: center;
                align-items: center;

                .profile-image {
                    height: 80px;
                    width: 80px;
                    border: 1.4px solid #A8D9CD;
                    border-radius: 45px;
                    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
                    box-sizing: border-box;
                    object-fit: cover;
                }

                .user-name {
                    display: flex;
                    position: relative;
                    font-size: 16px;
                    margin-top: 12px;

                    .temp {
                        border: 1px solid #A8D9CD;
                        border-radius: 10px;
                        width: 50px;
                        position: absolute;
                        left: 70px;
                        bottom: 0px;
                        font-size: 10px;
                        color: #A8D9CD;
                    }
                }

            }

            .neighbor {
                display: flex;
                flex-direction: column;
                text-align: center;
                min-width: 45px;

            }
        }

        .profile-update-wrapper {
            margin-left: 30%;
            margin-right: 30%;

            .profile-update {
                min-width: 70px;
                width: 100%;
                height: 32px;
                background: #377375;
                border: 1px solid #A8D9CD;
                border-radius: 17px;
                text-align: center;
                margin-top: 15px;
                font-weight: 700;
                font-size: 12px;
                line-height: 17px;
                letter-spacing: -0.05em;

                color: #FFFFFF;
    
            }
        }

        .menu-container {
            margin-top: 24px;
            margin-left: 7.5%;
            margin-right: 7.5%;

            .menu-wrapper {
                width: 100%;
                height: 50px;
                display: flex;
                align-items: center;
                border-bottom: 1px solid #F4F4F6;
                
                .menu {
                    display: flex;
                    position:relative;
                    width: 100%;

                    .icon {
                    }

                    .menu-name {
                        margin-left: 32px;
                        font-weight: 500;
                        font-size: 14px;
                        line-height: 20px;
                        letter-spacing: -0.05em;
                    }
    
                    .arrrow-right {
                        position: absolute;
                        right: 0;
                        top: 5px;
                    }
                }
            }
        }
    }

</style>