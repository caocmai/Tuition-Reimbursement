response = null;

function generateForm() {
    let title = localStorage.getItem("title");
    let requestId = localStorage.getItem("requestId");
    console.log(title)
    console.log(requestId);

    getRequest(requestId);
}

function getRequest(id){

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
    if (this.readyState == 4 & this.status == 200) {

        if (this.responseText == "{}" || this.responseText == "[]") {
            document.getElementById("success").innerHTML = "No Request found"
        }
        // console.log(this.response)
        let request = JSON.parse(this.responseText)
        console.log(request);
        populateForm()

        let count = 1;

    }
};

let url = `http://localhost:7000/employees/requests/${id}`
xhr.open("GET", url, true);
xhr.send();

}

function populateForm(){
    var content = document.getElementById("addForm");
    let title = localStorage.getItem("title");

    var from = "";

    if (title == "Supervisor") {
        var supervisor = `
        <div class="form-group row">
            <label for="cost" class="col-sm-2 col-form-label">From</label>
            <div class="col-sm-10">
              <h4>Supervisor</h4>
            </div>
          </div>
          `
          from += supervisor
    } else if (title == "DeptHead") {
        var deptHead = `
        <div class="form-group row">
            <label for="cost" class="col-sm-2 col-form-label">From</label>
            <div class="col-sm-10">
              <h4>Department Head</h4>
            </div>
          </div>

        `
        from += deptHead;
    } else if (title == "BenCo") {
        var coor = `
        <div class="form-group row">
            <label for="cost" class="col-sm-2 col-form-label">From</label>
            <div class="col-sm-10">
              <h4>Benefits Coordinator</h4>
            </div>
          </div>

        `
        from += coor;
    }

    var to = "";

    if (title == "Supervisor") {
        var supervisor2 = `
        <div class="form-group row">
            <label for="toSender" class="col-sm-2 col-form-label">To</label>
            <div class="col-sm-10">
                <select class="custom-select my-1 mr-sm-2" id="toSender">
                    <option selected>Event Type</option>
                    <option value="Employee">Employee</option>
                  </select>
            </div>
        </div>
          `
          to += supervisor2
    } else if (title == "DeptHead") {
        var deptHead2 = `
        <div class="form-group row">
            <label for="toSender" class="col-sm-2 col-form-label">To</label>
            <div class="col-sm-10">
                <select class="custom-select my-1 mr-sm-2" id="toSender">
                    <option selected>Event Type</option>
                    <option value="Employee">Employee</option>
                    <option value="Supervisor">Supervisor</option>
                  </select>
            </div>
        </div>

        `
        to += deptHead2;
    } else if (title == "BenCo") {
        var coor2 = `
        <div class="form-group row">
            <label for="toSender" class="col-sm-2 col-form-label">To</label>
            <div class="col-sm-10">
                <select class="custom-select my-1 mr-sm-2" id="toSender">
                    <option selected>Event Type</option>
                    <option value="Employee">Employee</option>
                    <option value="Supervisor">Supervisor</option>
                    <option value="DeptHead">Department Head</option>
                  </select>
            </div>
        </div>

        `
        to += coor2;
    }

    var submit = `
    <div class="form-group row">
        <label for="reason" class="col-sm-2 col-form-label">Description</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="reason" placeholder="">
        </div>
      </div>


    <div class="col-auto my-1">
        <button id="sendRequest" onclick="saveRequest()" type="button" class="btn btn-primary">Submit</button>
      </div>
      <p id="success"></p>
    `
    content.innerHTML += (from + to + submit);
    
}

function saveRequest() {
    let fromUser = localStorage.getItem("userId");
    let requestId = localStorage.getItem("requestId");
    let selectedUser = document.getElementById("toSender").value
    let reason = document.getElementById("reason").value

    console.log(fromUser)
    console.log(selectedUser)


    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
    if (this.readyState == 4 & this.status == 200) {

        if (this.responseText == "{}" || this.responseText == "[]") {
            document.getElementById("success").innerHTML = "No Request found"
        }
        // console.log(this.response)
        let request = JSON.parse(this.responseText)

        let toId;
        
        if (selectedUser == "Supervisor"){
            toId = request.employee.supervisorId
        } else if (selectedUser == "DeptHead") {
            toId = request.employee.deptId
        }  else if (selectedUser == "Employee") {
            toId = request.employee.id
        }

        sendRequest(fromUser, toId, reason);
    }
};

let url = `http://localhost:7000/employees/requests/${requestId}`
xhr.open("GET", url, true);
xhr.send();

}


function sendRequest(fromId, toId, reason) {
    let requestId = localStorage.getItem("requestId");
    console.log(requestId, fromId, toId, reason)
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 & this.status == 200) {
            document.getElementById("success").innerHTML = "More info added"
        }
    }

    let url = "http://localhost:7000/employees/requests/moreinfo"

    xhr.open("POST", url, true)

    xhr.setRequestHeader('Content-Type', "application/json");

    // these variables need to be the same as the Java Model
    let JsonMoreInfo = {
        requestId: requestId,
        fromId: fromId,
        toId: toId,
        reason: reason
    }

xhr.send(JSON.stringify(JsonMoreInfo));

}