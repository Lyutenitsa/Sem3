import axios from "axios"
import authHeader from "../AuthServices/auth-header"

const URL_API = "http://localhost:8080/api/item"
const getAllItems = () => {
    return axios.get(URL_API + "/getAllItems", {
        header: authHeader()
    });
}
const addItem = (id, subject, body, completed) => {

    console.log("Sending new item");
    return axios
    .post(URL_API + "/createItem",{
            subject,
            body,
            completed
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
    addItem
};