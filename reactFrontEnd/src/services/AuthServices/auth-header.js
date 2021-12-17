export default function authHeader() {
  const user = JSON.parse(localStorage.getItem('user'));

  if (user && user.accessToken) {
    return {
      Authorization: 'Bearer ' + user.accessToken,
      "Access- Control - Allow - Origin": 'http://localhost:51666'
  };
} else {
  return {};
}
}