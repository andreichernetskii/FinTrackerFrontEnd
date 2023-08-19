// getting refs of dialog window and form elements
const dialog = document.getElementById('dialog');
const operationIdInput = document.getElementById('id');
const operationTypeInput = document.getElementById('operationType');
const amountInput = document.getElementById('amount');
const dateInput = document.getElementById('date');
const categoryInput = document.getElementById('category');


// by pressing button dialog window will be shown and filled with data from row
document.querySelectorAll('.editBtn').forEach((btn) => {
    btn.addEventListener('click', () => {
        const operationId = btn.getAttribute('data-id');
        const operationType = btn.getAttribute('data-operationType'); // Предположим, что есть атрибут data-operationType у кнопки
        const amount = btn.getAttribute('data-amount');
        const date = btn.getAttribute('data-date');
        const category = btn.getAttribute('data-category');

        // filling forms with data from row
        operationIdInput.value = operationId;
        operationTypeInput.value = operationType;
        amountInput.value = amount;
        dateInput.value = date;
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