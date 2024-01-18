const modal = document.querySelector(".modal");
const overlay = document.querySelector(".overlay");
const openModalBtn = document.querySelector(".btn-open");
const closeModalBtn = document.querySelector(".btn-close");

// close modal function
const closeModal = function () {
    modal.classList.add("hidden");
    overlay.classList.add("hidden");
};

// open modal function
const openModal = function () {
    modal.classList.remove("hidden");
    overlay.classList.remove("hidden");
};

// open modal event
openModalBtn.addEventListener("click", openModal);

// close the modal when the close button and overlay is clicked
overlay.addEventListener("click", closeModal);
closeModalBtn.addEventListener("click", closeModal);

// close modal when the Esc key is pressed
document.addEventListener("keydown", function (e) {
    if (e.key === "Escape" && !modal.classList.contains("hidden")) {
        closeModal();
    }
});




