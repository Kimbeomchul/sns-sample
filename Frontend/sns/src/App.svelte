<script>
    import Router from 'svelte-spa-router'
    import Modal from './Common/Modal.svelte'
    import Board from './routes/Board.svelte'
    import BoardWrite from './routes/BoardWrite.svelte'
    import Chat from './routes/Chat.svelte'
    import Contact from './routes/Contact.svelte'
    import Init from './routes/Init.svelte'
    import Join from './routes/Join.svelte'
    import Login from './routes/Login.svelte'
    import Test from './routes/Test.svelte'
    import User from './routes/User.svelte'
</script>

<Router routes = {{
    '/': Test,
    '/init': Init,
    '/login': Login,
    '/join': Join,
    '/contact': Contact,
    '/board': Board,
    '/write': BoardWrite,
    '/user': User,
    '/chat': Chat,
}} />

