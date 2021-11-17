import axios from "axios";
import authHeader from "./auth-header";
import authService from "./auth.service";

const API_URL = "http://localhost:8080/api/user";

const currentUser = authService.getCurrentUser();

const getPublicContent = () => {
  return axios.get(API_URL + "/getAll");
};

const getUserBoard = () => {

  if(currentUser){
  return axios.get(API_URL + "/" + authService.getCurrentUser().id, { headers: authHeader() });
  }
  return "No registered User dude";
};

// const getModeratorBoard = () => {
//   return axios.get(API_URL + "mod", { headers: authHeader() });
// };

const getAdminBoard = () => {
  return axios.get(API_URL + "admin", { headers: authHeader() });
};

export default {
  getPublicContent,
  getUserBoard,
//   getModeratorBoard,
  getAdminBoard,
};