<script>
    import Footer from "../Common/Footer.svelte"
    import Header from "../Common/Header.svelte"
    import { clickOutside } from '../js/clickOutside'

    const categorys = {
        daily: '일상',
        notice: '공지사항',
        promo: '홍보'
    }
    let expanded = false
    let selectedCategory = null

    const handleClickFilter = () => expanded = !expanded
    const handleClickOutside = (event) => expanded = false
    const handleClickCategory = (category) => {
        if(selectedCategory !== categorys[category]) expanded = false
        selectedCategory = categorys[category]
    }
</script>

<div class="boarder-write-root-container">
    <Header header='글쓰기'></Header>
    <div class="border-write-area">
        <div class="category-selected-area" use:clickOutside on:click_outside={handleClickOutside} aria-hidden="true">
            <div class="selected-area" on:click={handleClickFilter} aria-hidden='true'>{!selectedCategory ? '카테고리 선택 ▼' : `${selectedCategory} ▼`}</div>
            {#if expanded}
                <div class="selected-option">
                    <div class="option" on:click={() => {handleClickCategory('daily')}} aria-hidden='true'>일상</div>
                    <div class="option" on:click={() => {handleClickCategory('notice')}} aria-hidden='true'>공지사항</div>
                    <div class="option" on:click={() => {handleClickCategory('promo')}} aria-hidden='true'>홍보</div>
                </div>
            {/if}
        </div>
        <div class="title-area">
            <div class="label">제목</div>
            <input placeholder="제목을 입력해주세요."/>
        </div>
        <div class="content-area">
            <div class="label">내용</div>
            <textarea />
        </div>
        <div class="write-button">작성하기</div>
    </div>
    <Footer />
</div>

<style lang="scss">
    .boarder-write-root-container {
        .border-write-area {
            padding: 40px;

            .category-selected-area {
                display: flex;
                flex-direction: column;
                position: relative;

                .selected-area {
                    font-family: 'Inter';
                    font-weight: 400;
                    font-size: 12px;
                    line-height: 15px;
                    height: 20px;
                    line-height: 20px;
                }

                .selected-option {
                    position: absolute;
                    top: 22px;
                    z-index: 1;
                    background: #fff;
                    padding: 4px;
                    display: flex;
                    flex-direction: column;
                    gap: 4px;
                    min-width: 80px;
                    color: rgba(0, 0, 0, 0.87);
                    transition: box-shadow 300ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;
                    border-radius: 4px;
                    box-shadow: rgb(0 0 0 / 20%) 0px 2px 1px -1px, rgb(0 0 0 / 14%) 0px 1px 1px 0px, rgb(0 0 0 / 12%) 0px 1px 3px 0px;

                    .option {
                        font-weight: 400;
                        font-size: 12px;
                    }
                }
            }

            .title-area {
                padding: 28px 0 15px 0;

                input {
                    border: none;
                    border-bottom: solid 1px #EDEDED;
                    width: 100%;
                    padding-bottom: 5px;
                    font-size: 13px;
                    letter-spacing: -0.05em;
                    font-weight: 500;

                    &::placeholder {
                        color: #D6D6D6
                    }
                }
            }

            .content-area {
                padding-bottom: 40px;

                textarea {
                    background: #DEEFE3;
                    border-radius: 10px;
                    width: calc(100% - 20px);
                    min-height: 170px;
                    resize: none;
                    border: none;
                    padding: 10px;
                    font-size: 13px;
                    letter-spacing: -0.05em;
                    font-weight: 500;
                }
            }

            .label {
                font-weight: 500;
                font-size: 13px;
                letter-spacing: -0.05em;
                color: #3B3B3B;
                padding-bottom: 10px;
            }

            .write-button {
                background: #377375;
                border-radius: 27px;
                width: 100%;
                height: 53px;
                font-weight: 700;
                font-size: 15px;
                line-height: 53px;
                text-align: center;
                letter-spacing: -0.05em;
                color: #FFFFFF;
                margin-bottom: 40px;
            }
        }
    }
</style>