import React from "react";
import AuthService from "../services/AuthServices/auth.service";
import { Switch, Route, Link } from "react-router-dom";
import UserForm from "./profile/user-edit-form";


const Profile = () => {
  const currentUser = AuthService.getCurrentUser();

  return (
    <div className="container">
      <header className="jumbotron">
        <h3>
          <strong>{currentUser.username}</strong>'s Profile
        </h3>
      </header>
      {/* <p>
        <strong>Token:</strong> {currentUser.token.substring(0, 20)} ...{" "}
        {currentUser.token.substr(currentUser.token.length - 20)}
      </p> */}
      <p>
        <strong>Id:</strong> {currentUser.id}
      </p>
      <p>
        <strong>Email:</strong> {currentUser.email}
      </p>
      {/* <strong>Authorities:</strong> */}
      {/* <ul>
        {currentUser.roles &&
          currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
        </ul> */}

      <Link to="/editUser">
        <button type="button">
        Edit user details
        </button>
      </Link>

    </div>

  );
};

export default Profile;