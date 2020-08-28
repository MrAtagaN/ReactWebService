import {SERVER_URL, UNKNOWN_ERROR} from "../constants/RestConstants";

/**
 * Rest клиент
 * Нужен для отправки запросов на сервер, обработки ответов
 */
export default class RestClient {

    /**
     * Отправляет get запрос
     */
    static get = async (url, params) => {
        for (const name in params) {
            url += (url.indexOf('?') === -1 ? '?' : '&');
            url += name + '=' + params[name];
        }
        return await fetch(SERVER_URL + url, {
            method: 'get',
            url: SERVER_URL,
            credentials: 'include'
        })
            .then(response => {return response.json();})
            .catch(err => {return {code: UNKNOWN_ERROR};});
    };


    /**
     * Отправляет post запрос
     */
    static post = async (url, body) => {
        return await fetch(SERVER_URL + url, {
            body: body,
            method: 'post',
            url: SERVER_URL,
            credentials: 'include'
        })
            .then(response => {return response.json();})
            .catch(err => {return {code: UNKNOWN_ERROR};});
    };


    static sendForm = async (url, data) => {
        return await fetch(SERVER_URL + url, {
            body: JSON.stringify(data),
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            url: SERVER_URL,
            credentials: 'include'
        })
            .then(response => {return response.json();})
            .catch(err => {return {code: UNKNOWN_ERROR};});
    };



}
