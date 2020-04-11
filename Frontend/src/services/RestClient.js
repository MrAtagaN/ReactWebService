import {SERVER_URL, UNKNOWN_ERROR} from "../constants/RestConstants";

/**
 * Rest клиент
 * Нужен для отправки запросов на сервер, обработки ответов
 */
export default class RestClient {

    // static post = async () => {
    //     fetch('http://localhost:80/api/v1/login', {
    //         method: 'post',
    //         url: `http://localhost:80`,
    //         credentials: 'include'
    //     })
    //         .then(result => alert(result))
    //         .catch(err => {
    //         });
    // };

    /**
     * Отправляет multipart/form-data
     */
    static sendForm = async (url, data) => {
        const formData = new FormData();

        for (const name in data) {
            formData.append(name, data[name]);
        }

        return  await fetch(SERVER_URL + url, {
            body: formData,
            method: 'post',
            url: SERVER_URL,
            credentials: 'include'
        })
            .then(response => {return response.json();})
            .catch(err => {return {code: UNKNOWN_ERROR}});
    };



}
