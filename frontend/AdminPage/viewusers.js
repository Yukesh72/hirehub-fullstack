const role=localStorage.getItem("role");

if(role!==ADMIN)
{
    alert("you are not an admin bro");
    window.location.href="login.html";
}

function loadApplications(jobId)
{
    fetch(`http://localhost:8080/api/applyportal/jobid/${jobId}`)
    .then(res => res.json())
    .then(data => 
    {
        const container = document.getElementById("appList"); // ✅ IMPORTANT
        container.innerHTML = "";

        data.forEach(app => {
            const div = document.createElement("div");
            div.innerHTML = `
                <p><b>User ID:</b> ${app.userid}</p>
                <p><b>Job ID:</b> ${app.jobid}</p>
                <p><b>Status:</b> ${app.status}</p>
                <hr>
            `;
            container.appendChild(div);
        });
    });
}

function back()
{
    window.location.href="adminloginpage.html";
}
