var firstFormAdded = false;

function addForm() {
    let location = document.getElementById("location").value;
    let description = document.getElementById("description").value;
    let cost = document.getElementById("cost").value;
    let gradingType = document.getElementById("gradingType").value;
    let eventType = document.getElementById("eventType").value;
    let attachment = document.getElementById("attachment").value;
    let startTime = document.getElementById("startTime").valueAsNumber;
    let endTime = document.getElementById("endTime").valueAsNumber;

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (JSON.parse(this.responseText)) {
                let content = document.getElementById("success").value
                console.log(content)
                if (firstFormAdded) {
                    document.getElementById("success").innerHTML = "Another Request was successfully Added"
                } else {
                    document.getElementById("success").innerHTML = "A Request was successfuly Added"
                }
            } else {
                document.getElementById("success").innerHTML = "Form was NOT Added to DB"
            }

            firstFormAdded = true;
        }
    }

    let url = "http://localhost:7000/employees/requests/form"
    xhttp.open("POST", url, true)

    xhttp.setRequestHeader('Content-Type', "application/json");
    
    let timeOff = (endTime - startTime);
    // these variables need to be the same as the Java Model
    let form = {
        location: location,
        description: description,
        cost: cost,
        eventType: eventType,
        supplementInfo: attachment,
        gradingType: gradingType,
        timeOff: timeOff,
        startDate: startTime
    }

    // The optional argument in the send() method allows us to provide a body for our request
    xhttp.send(JSON.stringify(form));


}