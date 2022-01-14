import React, { useState, useRef } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import UserService from "../../services/UserService/user.sevice"
import AuthService from "../../services/AuthServices/auth.service";
import { isEmail } from "validator";




const required = (value) => {
    if (!value) {
        return (
            <div className="alert alert-danger" role="alert">
                This field is required!
            </div>
        );
    }
};

const validEmail = (value) => {
    if (!isEmail(value)) {
        return (
            <div className="alert alert-danger" role="alert">
                This is not a valid email.
            </div>
        );
    }
};

const validUsername = (value) => {
    if (value.length < 3 || value.length > 20) {
        return (
            <div className="alert alert-danger" role="alert">
                The username must be between 3 and 20 characters.
            </div>
        );
    }
};

const UserForm = (props) => {
    const form = useRef();
    const checkBtn = useRef();

    const currentUser = AuthService.getCurrentUser();

    const [userId, setUserId] = useState(currentUser.id);
    const [username, setUsername] = useState(currentUser.username);
    const [email, setEmail] = useState(currentUser.email);
    // const [password, setPassword] = useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");

    console.log(username, email, currentUser.id);
    const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
    };

    const onChangeEmail = (e) => {
        const email = e.target.value;
        setEmail(email);
    };

    // const onChangePassword = (e) => {
    //     const password = e.target.value;
    //     setPassword(password);
    // };

    const handleUserUpdate = (e) => {
        e.preventDefault();

        setMessage("");
        setSuccessful(false);

        form.current.validateAll();



        if (checkBtn.current.context._errors.length === 0) {
            UserService.update(userId, username, email)
                // .then((response) =>{
                //     console.log("Logging responce from server 201");

                //     console.log(response);
                //     // localStorage.setItem("user", JSON.stringify(response.data));
                    
                // });

                props.history.push("/profile");
        }
    };
    return (
        <div className="col-md-12">
            <div className="card card-container">
                <img
                    src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                    alt="profile-img"
                    className="profile-img-card"
                />

                <Form onSubmit={handleUserUpdate} ref={form}>
                    {!successful && (
                        <div>
                            <div className="form-group">
                                <label htmlFor="username">Username</label>
                                <Input
                                    type="text"
                                    className="form-control"
                                    name="username"
                                    value={username}
                                    placeholeder="Username ... "
                                    onChange={onChangeUsername}
                                    validations={[required, validUsername]}
                                />
                            </div>

                            <div className="form-group">
                                <label htmlFor="email">Email</label>
                                <Input
                                    type="text"
                                    className="form-control"
                                    name="email"
                                    value={email}
                                    placeholeder="example@email.com"
                                    onChange={onChangeEmail}
                                    validations={[required, validEmail]}
                                />
                            </div>


                            <div className="form-group">
                                <button className="btn btn-primary btn-block">Save changes</button>
                            </div>
                        </div>
                    )}

                    {message && (
                        <div className="form-group">
                            <div
                                className={successful ? "alert alert-success" : "alert alert-danger"}
                                role="alert"
                            >
                                {message}
                            </div>
                        </div>
                    )}
                    <CheckButton style={{ display: "none" }} ref={checkBtn} />
                </Form>

            </div>
        </div>
    );
};

export default UserForm;