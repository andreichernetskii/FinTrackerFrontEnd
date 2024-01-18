// getting refs of dialog window and form elements
const dialog = document.getElementById('dialog');
const idInput = document.getElementById('id');
const typeInput = document.getElementById('type');
const amountInput = document.getElementById('amount');
const dateInput = document.getElementById('date');
const categoryInput = document.getElementById('category');


// by pressing button dialog window will be shown and filled with data from row
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

// by pressing the cancel button dialog window will be closed
document.getElementById('cancelDialogBtn').addEventListener('click', (event) => {
    if (dialog) {
        dialog.classList.add('hidden');
        typeInput.innerHTML = "";
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