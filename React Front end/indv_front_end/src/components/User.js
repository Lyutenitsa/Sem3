import React, { useState, useEffect } from "react";
import authService from "../services/AuthServices/auth.service";

// import UserService from "../services/user.service";

const User = () => {
  const [content, setContent] = useState("");
  const currentUser = authService.getCurrentUser();

  useEffect(() => {
    console.log(currentUser.token);
    console.log(currentUser.id);
    
    // UserService.getUserBoard().then(
    //   (response) => {
    //     setContent(response.data);
    //   },
    //   (error) => {
    //     const _content =
    //       (error.response &&
    //         error.response.data &&
    //         error.response.data.message) ||
    //       error.message ||
    //       error.toString();

    //     setContent("THIS IS CONTENT!! BOYYYYYSSSS");
    //   }
    // );
  }, []);
  setContent("THIS IS CONTENT!! BOYYYYYSSSS");
  return (
    
    <div className="container">
      <header className="jumbotron">
        <h3>{content}</h3>
      </header>
    </div>
  );
};

export default User;