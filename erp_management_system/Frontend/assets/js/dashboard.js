// Login check temporarily disabled
fetch("http://localhost:8081/api/users")
.then(res => res.json())
.then(data => {
    document.getElementById("userCount")
    .innerText = data.length;
});
fetch("http://localhost:8081/api/products")
.then(res => res.json())
.then(data => {
    document.getElementById("productCount")
    .innerText = data.length;
});
fetch("http://localhost:8081/api/suppliers")
.then(res => res.json())
.then(data => {
    document.getElementById("supplierCount")
    .innerText = data.length;
});
fetch("http://localhost:8081/api/inventory")
.then(res => res.json())
.then(data => {
    document.getElementById("inventoryCount")
    .innerText = data.length;
});
const today = new Date();

document.getElementById("currentDate").innerText =
today.toLocaleString();
const user =
JSON.parse(localStorage.getItem("loggedInUser"));

if(user){
    document.getElementById("welcomeUser")
    .innerText =
    `Welcome, ${user.username} 👋`;
}