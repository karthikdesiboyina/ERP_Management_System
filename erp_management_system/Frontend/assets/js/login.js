function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8081/api/users/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: email,
            password: password
        })
    })
    .then(response => response.json())
    .then(user => {

        localStorage.setItem(
            "loggedInUser",
            JSON.stringify(user)
        );

        window.location.href = "dashboard.html";

    })
    .catch(error => {
        alert("Error: " + error.message);
    });
}