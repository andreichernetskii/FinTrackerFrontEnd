fetch("/delete-limit")
    .then(response => {
        if (!response.ok) {
            return response.json().then(data => {
                alert(`Error ${data.errorCode}: ${data.message}`);
            } );
        }
    } );