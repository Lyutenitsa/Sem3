// export default function SignInService(post) {

//   axios
//     .post(
//       "http://localhost:8080/auth/signUp",
//       {
//         email: email,
//         username: username,
//         password: password,
//       },
//       { withCredentials: false }
//     )
//     .then(response => {
//       if (response.data.status === "OK") {
//         this.props.handleSuccessfulAuth(response.data);
//       }
//       window.location.href = '/login';
//       console.log(response.status);
//     })

//     .catch(error => {
//       console.log("registration error", error);
//     });

// }