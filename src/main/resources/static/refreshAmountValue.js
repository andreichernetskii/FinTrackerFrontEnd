function updateEventCount() {
    $.get("operations-annual").done(function(fragment) { // get from controller
        $("#totalAmountValue").replaceWith(fragment); // update snippet of page
    });
}
updateEventCount();
// function updateEventCount() {
//
// }

// fetch("operations-annual")
//     .then(function(response) {
//         if (!response.ok) {
//             throw new Error("Network response was not ok");
//         }
//         return response.text();
//     })
//     .then(function(fragment) {
//         var totalAmountValue = document.getElementById("totalAmountValue");
//         totalAmountValue.innerHTML = fragment;
//     })
//     .catch(function(error) {
//         console.error("There was a problem with the fetch operation:", error);
//     });
