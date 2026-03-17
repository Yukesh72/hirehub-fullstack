const role=localStorage.getItem("role");
const token=localStorage.getItem("token");

// add job function for admin only
console.log("step 1");
console.log(token);
console.log(role);
function addJob() 
{

  const token=localStorage.getItem("token");
  fetch("http://localhost:8080/api/jobdetails/admin/addjobdetails",
  {
    method: "POST",
    headers: 
    {
       "Content-Type":"application/json",
       "Authorization": "Bearer " + localStorage.getItem("token")
    },

    
    body: JSON.stringify(
    {
      
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
  .catch(err => alert("back side failed"));
  console.log("step 2");
}

function back()
{
    window.location.href="adminloginpage.html";
}


