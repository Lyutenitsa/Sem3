import axios from "axios"

class getRequest {
    getHelloWorld(url){
        return axios
        .get(url)
        .then(response=>{
            var toReturn = response.data
            console.log(response.data)
            return(toReturn)

        })
        .catch(error=> {
            console.log(error)
            return(error)
        })
    }
    
}
export default new getRequest();


