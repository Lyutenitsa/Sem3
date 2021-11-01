import React, { Component } from 'react';
import getRequest from '../services/getRequest.js'

class Getter extends Component {
    constructor(props){
        super(props)

        this.state= {
            data:[],
            errMessage:[]
            
        }
    }
    componentDidMount(){
        getRequest.getHelloWorld('http://localhost:8080/testing/getItem/6').then(result=> this.setState({data: result}))
        // this.setState({data: response.success})
        // console.log("this should be an item object 123", response.onFulfilled)
    }
     render() { 
         const {data, errMessage} = this.state
        //  data.map()
         return (
         <div id="this is where the item should be"> 
             {
                 <div >{JSON.stringify(data)}</div>
            //  responce ? 
            //  <div >{responce}</div> :
            //  null
            //  }
            //  {
            //      errMessage?
            //      <div>{errMessage}</div>:
            //      null
             }
         </div>
        );
     }
 }
  
 export default Getter;