const userId = localStorage.getItem("userId");

if(!userId)                                      //applied jobs page
{
  alert("please login first")
  window.location.href="login.html";
}

fetch(`http://localhost:8080/api/applyportal/userid/${userId}`) //SHOW APPLIED JOB INFO
  .then(res => res.json())
  .then(applications => 
    {

      console.log("userid ->" ,userId);
    const container = document.getElementById("Applied");
    container.innerHTML = "";

    console.log("step 2");

    if(applications.length===0)
    {
      container.innerHTML="<p>No jobs are Applied yet</p>";
      return;
    }

    console.log("step 3");

    fetch(`http://localhost:8080/api/jobdetails/showjobdetails`)
        .then(res => res.json())
        .then(job => {

          console.log("step 4");

          applications.forEach(app => 
          {
              const jobs=job.find(j=>j.id===app.jobid);
              if(!jobs)return;

               let color = "gray";
               if (app.status === "SELECTED") color = "green";
               else if (app.status === "REJECTED") color = "red";
               else if (app.status === "REVIEWED") color = "orange";

               console.log("step 5");
            
          const div = document.createElement("div");
          div.innerHTML = `
            <h3><b>Job Title :</b> ${jobs.title}</h3>
            <p><b>Company:</b> ${jobs.company}</p>
            <p><b>Status:</b> 
              <span style="color:${color}; font-weight:bold">
                ${app.status}
              </span>
            </p>
            <p><b>Job Description :</b> ${jobs.jobdescription}</p>
            <hr>
          `;
          container.appendChild(div);

          console.log("step 6");
          });
        });
    })
    .catch(err=>console.log(err));


  function goback()
  {
    window.location.href="mainuserpage.html";
  }

  function logout()
  {
    localStorage.clear();
    window.location.href="login.html";
  }


