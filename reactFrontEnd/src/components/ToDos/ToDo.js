import React from 'react';

const ToDo = ({todo, handleToggle}) =>{
    const handleClick = (e) => {
        e.preventDefault()
        handleToggle(e.currentTarget.id)
    }
    if (todo.task === null){
        return (
            <div 
            id={todo.id} key={todo.id + todo.subject} name="todo" value={todo.id} 
            onClick={handleClick} className={todo.completed ? "todo strike" : "todo" }>
                {todo.subject}
            </div>   
        );
    }
    else{
        return (
            <div 
            id={todo.id} key={todo.id + todo.subject} name="todo" value={todo.id} 
             onClick={handleClick} className={todo.completed ?'todo-row complete' : 'todo-row'}
            >
            {todo.subject}
            </div>   
        );
    }
    
    
};

export default ToDo;