var emp = null;

function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

                emp = (JSON.parse(this.responseText))
                localStorage.setItem("title", emp.title);
                localStorage.setItem("userId", emp.id);
                localStorage.setItem("username", emp.username);

            if (emp) {
                document.getElementById("form").innerHTML = "";

                document.getElementById("message").innerHTML = "Welcome " + emp.firstName  + "<br> Role: " + emp.title;

                var content = `
                <a href="addForm.html"> 
                    <button id="startRequest" type="button" class="btn btn-primary">Start Request</button>
                </a> 

                <a href="request.html"> 
                    <button id="myRequestBtn" type="button" class="btn btn-primary">View My Request</button>
                </a> 

                <a href="needGradeRequest.html"> 
                    <button type="button" class="btn btn-primary">Provide Grades</button>
                </a> 

                `

                if (emp.title != "Associate") {
                    content += `
                    <a href="ApproveRequest.html"> 
                        <button type="button" class="btn btn-primary">View Requests To Approve</button>
                    </a> 
                    `
                }


                var buttons = document.getElementById("button");
                buttons.innerHTML += content;
            }

        } else {
            document.getElementById("success").innerHTML = "No User of such credentials"
        }
    }

    let url = "http://localhost:7000/employees/login"
    xhttp.open("POST", url, true)

    xhttp.setRequestHeader('Content-Type', "application/json");

    // these variables need to be the same as the Java Model
    let login = {
        username: username,
        password: password
    
    }
    // The optional argument in the send() method allows us to provide a body for our request
    xhttp.send(JSON.stringify(login));
}

