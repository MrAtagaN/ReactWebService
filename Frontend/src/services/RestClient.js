/**
 *
 */
export default class RestClient {

    static SERVER_URL = 'http://localhost:80/';


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

        fetch(this.SERVER_URL + url, {
            body: formData,
            method: 'post',
            url: this.SERVER_URL,
            credentials: 'include'
        })
            .then(response => {return response.json()})
            .then(res => {console.log(res)} )
            .catch(err => {});
    };



}
