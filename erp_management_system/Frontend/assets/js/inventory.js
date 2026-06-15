// alert("inventory.js loaded");
const INVENTORY_API =
    "http://localhost:8081/api/inventory";
let editInventoryId = null;
const loggedInUser =
JSON.parse(localStorage.getItem("loggedInUser"));
function saveInventory() {
    const productName =
document.getElementById("productName").value.trim();

if(productName === ""){
    alert("Product Name is required");
    return;
}

const quantity =
document.getElementById("quantity").value;

if(quantity === "" || quantity <= 0){
    alert("Quantity must be greater than 0");
    return;
}

const warehouseLocation =
document.getElementById("warehouseLocation").value.trim();

if(warehouseLocation === ""){
    alert("Warehouse Location is required");
    return;
}
    const inventory = {
        productName:
            document.getElementById(
                "productName"
            ).value,
        quantity:
            document.getElementById(
                "quantity"
            ).value,
        warehouseLocation:
            document.getElementById(
                "warehouseLocation"
            ).value
    };
    let method = "POST";
    let url = INVENTORY_API;
    if(editInventoryId !== null){
        method = "PUT";
        url =
        `${INVENTORY_API}/${editInventoryId}`;
    }
    fetch(url,{
        method:method,
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(inventory)
    })
    .then(()=>{
        loadInventory();
        clearInventoryForm();
        editInventoryId = null;
        document.getElementById(
            "inventoryBtn"
        ).innerText =
        "Save Inventory";
    });
}
function loadInventory(){
    fetch(INVENTORY_API)
    .then(res => res.json())
    .then(data => {
        let table =
        document.getElementById(
            "inventoryTable"
        );
        table.innerHTML = "";
        data.forEach(inventory => {
            table.innerHTML += `
            <tr>
                <td>
                    ${inventory.inventoryId}
                </td>
                <td>
                    ${inventory.productName}
                </td>
                <td>
                    ${inventory.quantity}
                </td>
                <td>
                    ${inventory.warehouseLocation}
                </td>
                <td>
                    ${
loggedInUser &&
(
    loggedInUser.role.toUpperCase() === "ADMIN" ||
    loggedInUser.role.toUpperCase() === "MANAGER"
)
?
`
<button onclick="editInventory(${inventory.inventoryId})">
Edit
</button>
<button onclick="deleteInventory(${inventory.inventoryId})">
Delete
</button>`:`<span>View Only</span>`
}
                </td>
            </tr>
            `;
        });
    });
}
if(
loggedInUser &&
loggedInUser.role.toUpperCase() !== "ADMIN" &&
loggedInUser.role.toUpperCase() !== "MANAGER"
){
document.getElementById(
"inventoryForm"
).style.display="none";
}
function editInventory(id){
    fetch(INVENTORY_API)
    .then(res => res.json())
    .then(data => {
        const inventory =
            data.find(
                i => i.inventoryId === id
            );
        document.getElementById(
            "productName"
        ).value =
        inventory.productName;
        document.getElementById(
            "quantity"
        ).value =
        inventory.quantity;
        document.getElementById(
            "warehouseLocation"
        ).value =
        inventory.warehouseLocation;
        editInventoryId = id;
        document.getElementById(
            "inventoryBtn"
        ).innerText =
        "Update Inventory";
    });
}
function deleteInventory(id){
    if(confirm(
        "Delete Inventory Record?"
    )){
        fetch(
        `${INVENTORY_API}/${id}`,
        {
            method:"DELETE"
        })
        .then(() => {
            loadInventory();
        });
    }
}
function clearInventoryForm(){
    document.getElementById(
        "productName"
    ).value = "";
    document.getElementById(
        "quantity"
    ).value = "";
    document.getElementById(
        "warehouseLocation"
    ).value = "";
}
loadInventory();
console.log("inventory.js loaded");
