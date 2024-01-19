// getting refs of dialog window and form elements
const dialog = document.getElementById('dialog');
const idInput = document.getElementById('id');
const typeInput = document.getElementById('type');
const amountInput = document.getElementById('amount');
const dateInput = document.getElementById('date');
const categoryInput = document.getElementById('category');
const editForm = document.getElementById('edit-form');

// by pressing editBtn dialog window will be shown and filled with data from row
document.querySelectorAll('.editBtn').forEach((btn) => {
    btn.addEventListener('click', () => {

        const id = btn.getAttribute('data-id');
        const type = btn.getAttribute('data-type');
        const types = btn.getAttribute('data-all-types');
        const amount = btn.getAttribute('data-amount');
        const date = btn.getAttribute('data-date');
        const category = btn.getAttribute('data-category');

        const array = types.replace(/([a-zA-Z]+)/g, '"$1"');
        const typesArray = JSON.parse(array);

        // filling forms with data from row
        if (idInput) idInput.value = id;
        if (typeInput) {
            addNewOptions(typesArray);
            typeInput.value = type;
        }
        if (amountInput) amountInput.value = amount;
        if (dateInput) dateInput.value = date;
        if (categoryInput) categoryInput.value = category;

        if (dialog) {
            dialog.classList.remove('hidden');
            centerDialog();
        }
    });
});

// edit transaction entity
document.querySelectorAll('#transaction-editBtn').forEach((btn) => {

    btn.addEventListener('click', () => {

        editForm.setAttribute("action", "/update-transaction");
        editForm.setAttribute("method", "post");
        idInput.setAttribute("name", "id");
        typeInput.setAttribute("name", "financialTransactionType");
        amountInput.setAttribute("name", "amount");
        dateInput.setAttribute("name", "date");
        categoryInput.setAttribute("name", "category");

    });
});

// edit limit entity
document.querySelectorAll('.limit-editBtn').forEach((btn) => {

    btn.addEventListener('click', (event) => {

        editForm.setAttribute("action", "/update-limit");
        editForm.setAttribute("method", "post");
        idInput.setAttribute("name", "id");
        typeInput.setAttribute("name", "limitType");
        amountInput.setAttribute("name", "limitAmount");
        dateInput.setAttribute("name", "creationDate");
        categoryInput.setAttribute("name", "category");

    });
});


// by pressing the cancel button dialog window will be closed
// and reset all changes
document.getElementById('cancelDialogBtn').addEventListener('click', (event) => {

    if (dialog) {
        dialog.classList.add('hidden');
        // typeInput.innerHTML = "";
        // editForm.setAttribute("action", "");
        location.reload();
    }
});

function centerDialog() {

    const scrollTop = window.scrollY || document.documentElement.scrollTop;
    const dialogHeight = dialog.clientHeight;
    const windowHeight = window.innerHeight;

    const topPosition = scrollTop + (windowHeight - dialogHeight) / 2;

    dialog.style.top = `${topPosition}px`;
}

function addNewOptions(array) {

    for (let i = 0; i < array.length; i++) {
        if (array[i] !== "ZERO") {
            let option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            typeInput.add(option);
        }
    }
}