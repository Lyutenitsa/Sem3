import React, { useEffect, useState } from "react";
import data from "../../TestDataTod.json"

import ListHeader from "./ListHeader";
import ToDoList from "../ToDos/ToDoList";
import ToDoForm from "../ToDos/ToDoForm";
import "../../css/listcss.css"
import ItemService from "../../services/ItemsService/item.service";


const Lists = () => {
  var [toDoList, setToDoList] = useState(data);

  function getItems() {
    ItemService.getAllItems().then((response) => {
      if (response.data !== null) {
        console.log("why infinite");
        toDoList = setToDoList(response.data);
      } else {
        console.log("response,data === null");
        const data = response.data;
        // [ toDoList, setToDoList ] = setToDoList(data);
      }
    });
  }
  function addNewItem(item) {
    ItemService.addItem(item);
    getItems();
  }

  const handleToggle = (id) => {
    let mapped = toDoList.map(task => {
      return task.id === Number(id) ? { ...task, completed: !task.completed } : { ...task };
    });
    setToDoList(mapped);
  }

  const handleFilter = () => {
    let filtered = toDoList.filter(task => {
      return !task.completed;
    });
    setToDoList(filtered);
  }

  const addTask = (userInput) => {
    // let copy = [...toDoList];
    // copy = [...copy, { id: toDoList.length + 1, subject: userInput, completed: false }];
    // setToDoList(copy);

    // let newItem = { "id": 69, "subject": userInput, "body": "body from front end", "completed": false };
    // console.log(newItem.id);

    let id = 69;
    let subject = userInput;
    let body = "body from front end SUCC";
    let completed = false;

    addNewItem(id, subject, body, completed);
  }

  useEffect(() => {
    getItems();
  }, []);

  return (
    <div className="App">
      <ListHeader />
      <ToDoList toDoList={toDoList} handleToggle={handleToggle} handleFilter={handleFilter} />
      <ToDoForm addTask={addTask} />
    </div>
  );
}

export default Lists;