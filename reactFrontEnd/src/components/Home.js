import React, { useState, useEffect } from "react";

function Home() {
  const [content, setContent] = useState("");

  useEffect(() => {
    setContent("Welcome to the productivity website. Please log in to access the features of the applicaiton ");

    // UserService.getPublicContent().then(
    //   (response) => {
    //     setContent(response.data);
    //   },
    //   (error) => {
    //     const _content =
    //       (error.response && error.response.data) ||
    //       error.message ||
    //       error.toString();
    //     setContent(_content);
    //   }
    // );
  }, []);

  return (
    <div className="container">
      <header className="jumbotron">
        <h3>Welcome</h3>
        <p>This is a website made by Lyutfi Ismail.</p>


      </header>
    </div>
  );
}

export default Home;