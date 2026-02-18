
// add job function for admin only
function addJob() {
  fetch("http://localhost:8080/api/jobdetails/addjobdetails", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      title: document.getElementById("title").value,
      company: document.getElementById("company").value,
      jobdescription: document.getElementById("desc").value
    })
  })
  .then(res => {
    if (!res.ok) throw new Error("Failed to add job");
    return res.json();
  })
  .then(() => alert("Job added successfully ✅"))
  .catch(err => alert(err.message));
}

function back()
{
    window.location.href="adminloginpage.html";
}


