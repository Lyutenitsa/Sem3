import React, { useState, useEffect } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "../../App.css";

import AuthService from "../../services/AuthServices/auth.service";

import Login from "../Auth/Login";
import Register from "../Auth/Signup";
import Home from "../Home";
import Profile from "../Profile";
import User from "../User";
import BoardAdmin from "../BoardAdmin";
import ToDoPage from "../ToDoPage";
import UserForm from "../profile/user-edit-form";

const Navbar = () => {
    const [showModeratorBoard, setShowModeratorBoard] = useState(false);
    const [showAdminBoard, setShowAdminBoard] = useState(false);
    const [currentUser, setCurrentUser] = useState(undefined);

    useEffect(() => {
        const user = AuthService.getCurrentUser();

        if (user) {
            setCurrentUser(user);
            setShowModeratorBoard(user.roles.includes("ROLE_MODERATOR"));
            setShowAdminBoard(user.roles.includes("ROLE_ADMIN"));
        }
    }, []);

    const logOut = () => {
        AuthService.logout();
    };

    return (
        <div>
            <nav className="navbar navbar-expand navbar-dark bg-dark">
                <Link to={"/"} className="navbar-brand">
                    Productive
                </Link>
                <div className="navbar-nav me-auto">
                    <li className="nav-item">
                        <Link to={"/home"} className="nav-link">
                            Home
                        </Link>
                    </li>

                    {currentUser && (
                        <li className="nav-item">
                            <Link to={"/todos"} className="nav-link">
                                To Do Items
                            </Link>
                        </li>
                    )}



                </div>
                {currentUser ? (
                    <div className="navbar-nav ms-auto">
                        {/* <li className="nav-item">
                            <Link to={"/list"} className="nav-link">
                                List of ToDo s
                            </Link>
                        </li> */}
                        
                        <li className="nav-item">
                            <Link to={"/profile"} className="nav-link">
                                {currentUser.username}
                            </Link>
                        </li>
                        <li className="nav-item">
                            <a href="/login" className="nav-link" onClick={logOut}>
                                LogOut
                            </a>
                        </li>
                    </div>

                ) : (
                    <div className="navbar-nav ms-auto">
                        <li className="nav-item">
                            <Link to={"/login"} className="nav-link">
                                Login
                            </Link>
                        </li>

                        <li className="nav-item">
                            <Link to={"/register"} className="nav-link">
                                Sign Up
                            </Link>
                        </li>
                    </div>
                )}
            </nav>

            <div className="container mt-3">
                <Switch>
                    <Route exact path={["/", "/home"]} component={Home} />
                    <Route exact path="/login" component={Login} />
                    <Route exact path="/register" component={Register} />
                    <Route exact path="/profile" component={Profile} />
                    <Route path="/user" component={User} />
                    <Route path="/todos" component={ToDoPage} />
                    <Route path="/admin" component={BoardAdmin} />
                    <Route path="/editUser" component={UserForm} />
                </Switch>
            </div>
        </div>
    );
};

export default Navbar;