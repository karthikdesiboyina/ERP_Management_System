const API_URL = "http://localhost:8081/api/users";


let editUserId = null;
function saveUser() {
    const username =
document.getElementById("username").value.trim();

if(username === ""){
    alert("Username is required");
    return;
}
const email =
document.getElementById("email").value.trim();

if(email === ""){
    alert("Email is required");
    return;
}

if(!email.includes("@")){
    console.log("Email =", email);
    alert("Enter a valid email");
    return;
}
    const user = {
        username: document.getElementById("username").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        role: document.getElementById("role").value
    };
    if (user.email === "") {
        alert("Email Required");
        return;
    }
    if (user.password.length < 6) {
    alert("Password must be at least 6 characters");
    return;
}
if (
    user.role.toUpperCase() !== "ADMIN" &&
    user.role.toUpperCase() !== "USER" &&
    user.role.toUpperCase() !== "MANAGER"
) {
    alert("Role must be ADMIN, USER or MANAGER");
    return;
}
    let method = "POST";
    let url = "http://localhost:8081/api/users";
    if (editUserId !== null) {
        method = "PUT";
        url = `http://localhost:8081/api/users/${editUserId}`;
    }
    fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
        .then(() => {
            loadUsers();
            document.getElementById("username").value = "";
            document.getElementById("email").value = "";
            document.getElementById("password").value = "";
            document.getElementById("role").value = "";
            editUserId = null;
            document.getElementById("saveBtn").innerText = "Save User";
        });
}
function loadUsers() {
    fetch("http://localhost:8081/api/users")
        .then(response => response.json())
        .then(data => {
            let table = document.getElementById("userTable");
            table.innerHTML = "";
            data.forEach(user => {
                table.innerHTML += `
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>
                       <td>
   ${
    loggedInUser &&
    loggedInUser.role &&
    loggedInUser.role.toUpperCase() === "ADMIN"
        ?
        `
        <button class="edit-btn"
            onclick="editUser(${user.userId})">
            Edit
        </button>
        <button class="delete-btn"
            onclick="deleteUser(${user.userId})">
            Delete
        </button> `:`<span>View Only</span>`
    }
</td>
                    </tr>
                `;
            });
        });
}
function deleteUser(id) {
    if (confirm("Delete this user?")) {
        fetch(`http://localhost:8081/api/users/${id}`, {
            method: "DELETE"
        })
            .then(() => {
                alert("User Deleted");
                loadUsers();
            });
    }
}
function editUser(id) {
    fetch("http://localhost:8081/api/users")
        .then(res => res.json())
        .then(users => {
            const user = users.find(u => u.userId === id);
            document.getElementById("username").value = user.username;
            document.getElementById("email").value = user.email;
            document.getElementById("password").value = user.password;
            document.getElementById("role").value = user.role;
            editUserId = id;
            document.getElementById("saveBtn").innerText = "Update User";
        });
}
if (document.getElementById("userTable")) {
    loadUsers();
}

function searchUsers() {

    let input = document
        .getElementById("searchUser")
        .value
        .toLowerCase();

    let rows = document.querySelectorAll("#userTable tr");

    rows.forEach(row => {

        let text = row.innerText.toLowerCase();

        if (text.includes(input)) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }

    });

}
window.onload = function() {

    if (
        loggedInUser &&
        loggedInUser.role.toUpperCase() !== "ADMIN"
    ) {
        document.querySelector(".form-container").style.display = "none";
    }

}
 