const userId = localStorage.getItem("userId");

fetch("http://localhost:8080/api/jobdetails/showjobdetails")  //SHOW JOBS
  .then(res => res.json())
  .then(data => {
    const jobDiv = document.getElementById("jobList");
    jobDiv.innerHTML = ""; // clear

    data.forEach(job => {
      const div = document.createElement("div");
      div.innerHTML = `
        <h3>${job.title}</h3>
        <p><b>Company:</b> ${job.company}</p>
        <p>${job.jobdescription}</p>
        <button onclick="applyJob(${job.id})">Apply</button>
        <hr>
      `;
      jobDiv.appendChild(div);
    });
  })
  .catch(err => console.log(err));

//--------------------------------------------------------------------------

function applyJob(jobId) {                                //APPLY JOBS
  console.log("Apply clicked:", jobId); // DEBUG

  fetch("http://localhost:8080/api/applyportal/apply", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      userid: userId,
      jobid: jobId
    })
  })
  .then(res => res.json())
  .then(() => alert("Applied successfully ❤"))
  .catch(err => {
    console.log(err);
    alert("You already applied for this job ❌");
  });
}

