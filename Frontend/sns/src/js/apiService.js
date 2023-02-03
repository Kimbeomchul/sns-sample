import axios from "axios"

let instance = axios.create({
    baseURL: 'http://localhost:8081/api/v1/',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    }
});

const toRequest = (url, method, params) => {
    const axiosOptions = {
        url,
        method,
        [method.toUpperCase() === 'GET' ? 'params' : 'body'] : params,
        headers: {
            Authorization: `bearer ${localStorage.getItem('access_token')}`
        }
    }
    
    return instance.request(axiosOptions)
                //    .then(successHandler)
}

const successHandler = response => {
    console.log(response)
}

const failHandler = response => {
    console.log(response)
}

export const toGet = (url, params) => toRequest(url, 'GET', params)
export const toPost = (url, params) => toRequest(url, 'POST', params)