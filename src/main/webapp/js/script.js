// Cart functionality
let cart = JSON.parse(localStorage.getItem('cart')) || {};

function add_to_cart(pid, pname, price) {
    if (cart[pid] != undefined) {
        cart[pid].quantity += 1;
    } else {
        cart[pid] = {
            name: pname,
            quantity: 1,
            price: price
        }
    }
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCart();
}

function updateCart() {
    let cartString = localStorage.getItem("cart");
    let cart = JSON.parse(cartString);
    if (cart == null || Object.keys(cart).length == 0) {
        $(".cart-items").html("( 0 )");
        $(".cart-body").html("<h3>Cart is empty</h3>");
        $(".checkout-btn").addClass('disabled');
    } else {
        let total = 0;
        $(".cart-items").html(`( ${Object.keys(cart).length} )`);
        let table = `
        <table class='table'>
            <thead class='thread-light'>
                <tr>
                    <th>Item Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
        `;
        
        for (let pid in cart) {
            let item = cart[pid];
            table += `
                <tr>
                    <td>${item.name}</td>
                    <td>₹${item.price}</td>
                    <td>
                        <button class='btn btn-sm btn-minus' onclick='decreaseQuantity(${pid})'>-</button>
                        ${item.quantity}
                        <button class='btn btn-sm btn-plus' onclick='increaseQuantity(${pid})'>+</button>
                    </td>
                    <td>₹${item.price * item.quantity}</td>
                    <td><button class='btn btn-danger btn-sm' onclick='removeItem(${pid})'>Remove</button></td>
                </tr>
            `;
            total += item.price * item.quantity;
        }
        
        table += `
            <tr>
                <td colspan='3' class='text-right font-weight-bold'>Total Price:</td>
                <td class='font-weight-bold'>₹${total}</td>
                <td></td>
            </tr>
        </table>`;
        
        $(".cart-body").html(table);
        $(".checkout-btn").removeClass('disabled');
    }
}

function decreaseQuantity(pid) {
    let cart = JSON.parse(localStorage.getItem('cart'));
    if (cart[pid].quantity > 1) {
        cart[pid].quantity -= 1;
    } else {
        delete cart[pid];
    }
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCart();
}

function increaseQuantity(pid) {
    let cart = JSON.parse(localStorage.getItem('cart'));
    cart[pid].quantity += 1;
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCart();
}

function removeItem(pid) {
    let cart = JSON.parse(localStorage.getItem('cart'));
    delete cart[pid];
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCart();
}

$(document).ready(function() {
    updateCart();
});