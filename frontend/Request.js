function getRequests() {

    const username = localStorage.getItem('username');
    document.getElementById("myRequests").innerHTML = "My Request: " + username;
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 & this.status == 200) {
            // console.log(this.response)
            let requests = JSON.parse(this.responseText)
            console.log(requests);

            if (this.responseText == "[]" || this.responseText == "{}") {
                document.getElementById("success").innerHTML = "No Requests to list"

            }

            const tableRow = document.getElementById("tableRow")
            tableRow.innerHTML = "";
            let count = 1;
            requests.forEach(res => {

                const content = `
                    <tr>
                        <th scope="row">${count}</th>
                        <td>${res.form.location}</td>
                        <td>${res.form.eventType}</td>
                        <td>${res.superAppve}</td>
                        <td>${res.deptAppve}</td>
                        <td>${res.benCoAppve}</td>
                        <td>${res.grade}</td>
                        <td>${res.form.cost}</td>
                        <td>${res.amountAppve}</td>
                        <td>${res.benCoAppveFinal}</td>
                    </tr>

                `
                tableRow.innerHTML += content;
                count += 1;
            })
        }
    };

    let url = `http://localhost:7000/employees/requests`
    xhr.open("GET", url, true);
    xhr.send();
    
}

function getApprovedRequests() {

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 & this.status == 200) {
            // console.log(this.response)
            let requests = JSON.parse(this.responseText)
            console.log(requests);

            if (this.responseText == "[]" || this.responseText == "{}") {
                document.getElementById("success").innerHTML = "No Requests to list"
            }

            const tableRow = document.getElementById("tableRow")
            tableRow.innerHTML = "";
            let count = 1;
            requests.forEach(res => {

                const content = `
                    <tr>
                        <th scope="row">${count}</th>
                        <td>${res.form.location}</td>
                        <td>${res.form.eventType}</td>
                        <td>${res.superAppve}</td>
                        <td>${res.deptAppve}</td>
                        <td>${res.benCoAppve}</td>
                        <td>${res.form.cost}</td>
                        <td>${res.amountAppve}</td>
                    </tr>

                `
                tableRow.innerHTML += content;
                count += 1;
            })
        }
    };

    let url = `http://localhost:7000/employees/requests`
    xhr.open("GET", url, true);
    xhr.send();
}