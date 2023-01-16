<script>
  import Router from 'svelte-spa-router'
  import Board from './routes/Board.svelte'
</script>

<Router routes = {{
	'/': Board,
	'/board': Board
}} />