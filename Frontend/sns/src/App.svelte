<script>
    import Router, { querystring, replace} from 'svelte-spa-router'
    import { wrap } from 'svelte-spa-router/wrap'
    import Modal from './Common/Modal.svelte'
    import Board from './routes/Board/Board.svelte'
    import BoardWrite from './routes/Board/BoardWrite.svelte'
    import BoardDetail from './routes/Board/BoardDetail.svelte'
    import Chat from './routes/Chat.svelte'
    import Contact from './routes/Contact.svelte'
    import Init from './routes/Init.svelte'
    import Join from './routes/Join.svelte'
    import Login from './routes/Login.svelte'
    import Main from './routes/Main.svelte'
    import Review from './routes/Review.svelte'
    import Test from './routes/Test.svelte'
    import User from './routes/User.svelte'
    import * as utilService from './js/utilService';
    import { ROUTE } from './Common/constant';

</script>

<Router routes = {{
    '/': Test,
    '/init': wrap({
        component: Init,
        conditions: [
            ({querystring}) => {
                if(!querystring) return true

                const jwtToken = utilService.getQuerystringItem(querystring, 'token')
                
                if(jwtToken) {
                    localStorage.setItem('access_token', jwtToken)
                    replace(ROUTE.MAIN)
                }

                return true
            }
        ]
    }),
    '/login': Login,
    '/join': Join,
    '/contact': Contact,
    '/main': Main,
    '/review': Review,
    '/board': Board,
    '/board/write': BoardWrite,
    '/board/detail': BoardDetail,
    '/user': User,
    '/chat': Chat,
}} />

