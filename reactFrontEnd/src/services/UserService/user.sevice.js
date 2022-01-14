import axios from "axios";
import authHeader from "../AuthServices/auth-header"
import authService from "../AuthServices/auth.service"

const API_URL = "http://localhost:8080/api/user/";


const update = (id, username, email) => {

    return axios
        .put(API_URL + "changeDetails", {
            id,
            username,
            email,
        },
            {
                headers: authHeader()
            })
        .then((response) => {
            console.log("Logging responce from server");
            console.log(response.data);
            localStorage.setItem("user", JSON.stringify(response.data));
            console.log(localStorage.getItem("user"));

            
            window.location.reload(false);


        });
};



export default {
    update,
};