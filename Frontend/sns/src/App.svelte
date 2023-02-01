<script>
    import Router from 'svelte-spa-router'
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
</script>

<Router routes = {{
    '/': Test,
    '/init': Init,
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

