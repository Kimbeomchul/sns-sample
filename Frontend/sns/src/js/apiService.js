import axios from "axios"

let instance = axios.create({
    baseURL: 'http://localhost:8081/api/v1/',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    }
});

const toRequest = (url, method, params, showAlert = false) => {
    const axiosOptions = {
        url,
        method,
        [method.toUpperCase() === 'GET' ? 'params' : 'body'] : params,
        headers: {
            Authorization: `Bearer ${localStorage.getItem('access_token')}`
        }
    }
    
    return instance.request(axiosOptions)
                   .then(response => successHandler(response, showAlert))
                   .catch(response => failHandler(response, showAlert))
}

const successHandler = (response, showAlert) => {
    if(response === 'OK') {
        return Promise.resolve(response)
    }
}

const failHandler = (response, showAlert) => {
    return Promise.reject(response)
}

export const toGet = (url, params) => toRequest(url, 'GET', params, showAlert)
export const toPost = (url, params) => toRequest(url, 'POST', params, showAlert)