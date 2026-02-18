const role=localStorage.getItem("role");

if(role!=='ADMIN')                          //to change status
{
    alert("Sorry you are not an admin");
    window.location.href="jobs.html";
}

function loadByStatus(status)
{
    let url= status
    ? `http://localhost:8080/api/applyportal/getstatus/status/${status}`
    : `http://localhost:8080/api/applyportal/getstatus`;

    fetch(url)
    .then(res=>res.json())
    .then(data=>
    {
        const con=document.getElementById("applist");
        con.innerHTML="";

        data.forEach(app =>
        {
            con.innerHTML += `
          <p>
            UserID: ${app.userid} |
            JobID: ${app.jobid} |
            Status: ${app.status}
          </p>
        `;     
        });     
    });
}

function back()
{
    window.location.href="adminloginpage.html";
}