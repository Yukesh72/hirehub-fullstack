const role=localStorage.getItem("role");

if(role!=='ADMIN')                          //to change status
{
    alert("Sorry you are not an admin");
    window.location.href="jobs.html";
}

fetch("http://localhost:8080/api/applyportal/all")
.then(res => res.json())
.then(data =>
{
    const divs=document.getElementById("ndiv");
    divs.innerText="";

    data.forEach(app => 
    {
        const div=document.createElement("div");

        div.innerHTML = `
        <p><b>Apply ID:</b> ${app.applyid}</p>
        <p><b>User ID:</b> ${app.userid}</p>
        <p><b>Job ID:</b> ${app.jobid}</p>

        <select onchange="updateStatus(${app.applyid}, this.value)">
          <option ${app.status==="APPLIED"?"selected":""}>APPLIED</option>
          <option ${app.status==="REVIEWED"?"selected":""}>REVIEWED</option>
          <option ${app.status==="SELECTED"?"selected":""}>SELECTED</option>
          <option ${app.status==="REJECTED"?"selected":""}>REJECTED</option>
        </select>

        <hr>
        `;
    divs.appendChild(div);
    });
    });

//----------------------------------------------------------------

function updateStatus(applyid, status) 
{
  console.log("Updating status 👉", applyid, status);       //to save status changes in DB

  fetch(`http://localhost:8080/api/applyportal/applystatus/${applyid}?status=${status}`, {
    method: "PUT"
  })
  .then(res => {
    console.log("Response status 👉", res.status);
    return res.json();
  })
  .then(data => {
    console.log("Updated data 👉", data);
    alert("Status Updated successfully!");
  })
  .catch(err => console.error(err));
}

function back()
{
    window.location.href="adminloginpage.html";
}

