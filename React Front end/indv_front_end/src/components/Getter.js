import React, { Component } from 'react';
import axios from 'axios'

class Getter extends Component {
    constructor(props){
        super(props)

        this.state= {
            hello:[],
            errMessage:[]
            
        }
    }
    componentDidMount(){
        axios.get('http://localhost:8080/testing/HelloWorld1')
        .then(response=>{({hello: response.data})
            console.log(response)
        })
        .catch(error=> {
            this.setState({errMessage: "There was an error with the request"})
            console.log(error)
        })


    }
     render() { 
         const {hello, errMessage} = this.state
         return (
         <div> 
             {
             hello ? 
             <div>{hello}</div> :
             null
             }
             {
                 errMessage?
                 <div>{errMessage}</div>:
                 null
             }
         </div>
        );
     }
 }
  
 export default Getter;