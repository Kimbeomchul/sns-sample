<script>
    import Router from 'svelte-spa-router'
    import Modal from './Common/Modal.svelte'
    import Board from './routes/Board.svelte'
    import Contact from './routes/Contact.svelte'
    import Join from './routes/Join.svelte'
    import Login from './routes/Login.svelte'
    import Test from './routes/Test.svelte'
</script>

<Router routes = {{
    '/': Test,
    '/login': Login,
    '/join': Join,
    '/contact': Contact,
    '/board': Board,
}} />

