import axios from "axios"
import authHeader from "../AuthServices/auth-header"
import authService from "../AuthServices/auth.service"


const user = authService.getCurrentUser();
const URL_API = "http://localhost:8080/api/item"
const getAllItems = () => {
    return axios.get(URL_API + "/getAllItems/" + user.id, {
        header: authHeader()
    });
}
const addItem = (subject, body, completed) => {
    console.log("Sending new item");
    return axios
        .post(URL_API + "/createItem", {
            subject,
            body,
            completed,
            user
        }, {
            headers: authHeader()
        })
        .then((response) => {
            if (response.data) {
                console.log(response.data)
            }
            console.log(response)
        });
}
// const updateItem = () => {
//     console.log("updating item");
//     return axios
//         .post(URL_API + "/updateItem", {
//             subject,
//             body,
//             completed,
//             user
//         }, {
//             headers: authHeader()
//         })
//         .then((response) => {
//             if (response.data) {
//                 console.log(response.data)
//             }
//             console.log(response)
//         });
// }

const deleteItems = (ids) => {
    console.log(typeof ids);
    console.log("deleting items");

    // ids = JSON.stringify(ids)
    // console.log(ids);
    if(ids.lenght === 0){
        console.log("Empty ids=======================");
    }


    return axios
        .delete(URL_API + '/deleteItems/' + ids,
            {
                headers: authHeader()
            })
        .then((response) => {
            if (response.data) {
                console.log(response.data)
            }
            console.log(response)
        });
}

export default {
    getAllItems,
    addItem,
    deleteItems
};