import React, { useEffect, useState } from "react";
// import data from "../../TestDataTod.json"

import ListHeader from "./ListHeader";
import ToDoList from "../ToDos/ToDoList";
import ToDoForm from "../ToDos/ToDoForm";
import "../../css/listcss.css"
import ItemService from "../../services/ItemsService/item.service";


const Lists = () => {
  var [toDoList, setToDoList] = useState();
  var [empty, setEmpty] = useState(false);

  function getItems() {
    ItemService.getAllItems().then((response) => {
      if (response.data !== null) {
        toDoList = setToDoList(response.data);
      } else {
        console.log("response,data === null");
        const data = response.data;
      }
    });
  }
  // function addNewItem(subject, body, completed) {
  //   ItemService.addItem(subject, body, completed);
  //   getItems();

  //   console.log("this should reset the page")
  // }

  const handleToggle = (id) => {
    let mapped = toDoList.map(task => {
      return task.id === Number(id) ? { ...task, completed: !task.completed } : { ...task };
    });
    setToDoList(mapped);
  }

  const handleFilter = () => {
    // let filtered = toDoList.filter(task => {
    //   return !task.completed;
    // });
    // setToDoList(filtered);
    var ids = new Array();

    let filtered = toDoList.filter(task => {
      if (task.completed) {
        ids.push(task.id);
        return false;
      }
      else {
        return true;
      }
    });

    setToDoList(filtered);
    console.log("List of ids type: ", typeof ids);
    ItemService.deleteItems(ids)
      .then(() => {
        console.log("deleted!!!");
      }, (error) => {
        const resMessage =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();

        console.log(resMessage);
      }
      );

  }

  const addTask = (userInput) => {
    if (userInput !== "") {
      let subject = userInput;
      let body = "body from react";
      let completed = false;
      console.log(subject, body, completed);
      // addNewItem(subject, body, completed);
      ItemService.addItem(subject, body, completed)
        .then(() => {
          getItems();
          console.log("updating items");
        });
      setEmpty(false);
    }
    else {
      setEmpty(true);
    }
  }


  useEffect(() => {
    getItems();
  }, []);

  return (
    <div className="App">
      <ListHeader />
      <ToDoList toDoList={toDoList} handleToggle={handleToggle} handleFilter={handleFilter} />
      <ToDoForm addTask={addTask} />
      {empty ?
        <div style={{ color: "red" }}>Don't leave empty</div>
        :
        <div class="not empty" />
      }

    </div>
  );
}

export default Lists;