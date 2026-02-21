const userId=localStorage.getItem("userId");

function loadviewpage(status)
{
   let url = `http://localhost:8080/api/applyportal/getuser/${userId}`;

    if (status) {
        url += `?status=${status}`;
    }

    fetch(url)
    .then(res=>res.json())
    .then(data=>{
        const cont=document.getElementById("myapp");
        cont.innerHTML="";

        if(!Array.isArray(data)||data.length===0)
        {
            cont.innerHTML="<p>No jobs found!</p>";
            return;
        }

        data.forEach(app => {
            cont.innerHTML +=`
            <div class="one">
            <p><b>Job ID :</b> ${app.jobid}</p>
            <button onclick="viewjob(${app.jobid})">View Job</button>
            <button onclick="withdraw(${app.applyid})">WithDrawn</button>

            <hr>
            </div>
            `;
        });
    })
    .catch(err=>console.error(err));
}

function viewjob(jobid)                                                   //view job by id
{
    window.location.href='jobs.html?jobid=${jobid}';
}



function withdraw(applyid)                                               //WITHDRAW A JOB
{
    fetch(`http://localhost:8080/api/applyportal/withdraw/${applyid}`,
        {
            method:"PUT",

        })
        .then(()=>
        {
            alert("Application Withdrawn!");
            loadviewpage();
        })
}









