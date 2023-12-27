// getting refs of dialog window and form elements
const dialog = document.getElementById('dialog');
const limitIdInput = document.getElementById('id');
const limitTypeInput = document.getElementById('limitType');
const amountInput = document.getElementById('limitAmount');
// const dateInput = document.getElementById('date');
const categoryInput = document.getElementById('category');


// by pressing button dialog window will be shown and filled with data from row
document.querySelectorAll('.editBtn').forEach((btn) => {
    btn.addEventListener('click', () => {
        const limitId = btn.getAttribute('data-id');
        const limitType = btn.getAttribute('data-operationType'); // Предположим, что есть атрибут data-operationType у кнопки
        const amount = btn.getAttribute('data-amount');
        // const date = btn.getAttribute('data-date');
        const category = btn.getAttribute('data-category');

        // filling forms with data from row
        limitIdInput.value = limitId;
        limitTypeInput.value = limitType;
        amountInput.value = amount;
        // dateInput.value = date;
        categoryInput.value = category;
        dialog.classList.remove('hidden');
        centerDialog();
    });
});

// by pressing the cancel button dialog window will be closed
document.getElementById('cancelDialogBtn').addEventListener('click', (event) => {
    dialog.classList.add('hidden');
});

function centerDialog() {
    const scrollTop = window.scrollY || document.documentElement.scrollTop;
    const dialogHeight = dialog.clientHeight;
    const windowHeight = window.innerHeight;

    const topPosition = scrollTop + (windowHeight - dialogHeight) / 2;

    dialog.style.top = `${topPosition}px`;
}