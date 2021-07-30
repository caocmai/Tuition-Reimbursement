let emp = localStorage.getItem("title");
console.log(emp)
function getPendingRequests() {
// console.log(emp.title);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 & this.status == 200) {
            console.log(this.responseText)
            if (this.responseText == "{}" || this.responseText == "[]") {
                document.getElementById("success").innerHTML = "No pending requests to approve"
            }
            let requests = JSON.parse(this.responseText)
            console.log(requests);


            const tableRow = document.getElementById("tableRow")
            tableRow.innerHTML = "";
            let count = 1;
            requests.forEach(res => {

                var content = `
                    <tr>
                        <th scope="row">${count}</th>
                        <td>${res.urgent}</td>
                        <td>${res.superAppve}</td>
                        <td>${res.deptAppve}</td>
                        <td>${res.benCoAppve}</td>
                        <td>${res.form.location}</td>
                        <td>${res.form.eventType}</td>
                        <td>${res.grade}</td>
                        <td>${res.form.cost}</td>
                        <td>${res.amountAppve}</td>
                    
                        `

                if (emp == "BenCo") {
                    content += `
                    </tr>
                    <label> Approve Higher Amount (optional) </label>
                    <input id="inputAmount${res.id}" type='number'/>
                    <label> Reason </label>
                    <input id="inputReason${res.id}" type='text' value="reason for increase"/>
                    <button onclick="approveRequest(${res.id})" type="button" class="btn btn-primary">Approve</button>
\
                    `

                    if (!res.needMoreInfo && emp != "Approver") {
                        content += `
                        <a href="RequestMoreInfo.html"> 
                        <button onclick="saveRequestId(${res.id})"  type="button" class="btn btn-secondary">MoreInfo</button>
                    </a> 
                        `
                    }
                } else {

                    
                    content += `
                    
                    <td><button onclick="approveRequest(${res.id})" type="button" class="btn btn-primary">Approve</button></td>

                    
    
                    `
                    if (!res.needMoreInfo && emp != "Approver") {
                        content += `
                        <td>
                        <a href="RequestMoreInfo.html"> 
                        <button type="button" onclick="saveRequestId(${res.id})" class="btn btn-secondary">MoreInfo</button>
                        </a>     
                        </td>
                    </tr>
                        `
                    }
                }

                tableRow.innerHTML += content;
                count += 1;
            })
        }

        if (this.readyState == 4 & this.status != 200) {
            document.getElementById("success").innerHTML = "No pending requests to approve"
        }
    };

    let url = `http://localhost:7000/employees/requests/pending`
    xhr.open("GET", url, true);
    xhr.send();
    
}

function approveRequest(id) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 & this.status == 200) {
            document.getElementById("success").innerHTML = "Request approved"
        }
    }

    let url = "http://localhost:7000/employees/requests/pending/approve"

    xhr.open("POST", url, true)
    xhr.setRequestHeader('Content-Type', "application/json");
    if (emp == "BenCo") {
        let amount = document.getElementById("inputAmount"+id).value;
        let reason = document.getElementById("inputReason"+id).value;

        let GetJsonId = {
            id: id,
            amount: amount,
            reason: reason
        }
        xhr.send(JSON.stringify(GetJsonId));
    } else {
        let GetJsonId = {
            id: id,
        }
        xhr.send(JSON.stringify(GetJsonId));
    }

}

function saveRequestId(id) {
    localStorage.setItem("requestId", id);
}