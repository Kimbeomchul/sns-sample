import {open} from "../Modal.svelte";
import Alert from '../modal/Alert.svelte'



export const showAlert = () => {
    open(Alert)
}