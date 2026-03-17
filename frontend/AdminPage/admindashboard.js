fetch("http://localhost:8080/api/userlogin/admin/count",
  {
    headers:
      {
          "Authorization": "Bearer " + localStorage.getItem("token")
      }
  })
  .then(res => res.text())
  .then(data => document.getElementById("users").innerText = data);



fetch("http://localhost:8080/api/jobdetails/admin/count",
  {
    headers:
      {
          "Authorization": "Bearer " + localStorage.getItem("token")
      }
  })
  .then(res => res.text())
  .then(data => document.getElementById("jobs").innerText = data);



fetch("http://localhost:8080/api/applyportal/admin/count",
  {
    headers:
      {
          "Authorization": "Bearer " + localStorage.getItem("token")
      }
  })
  .then(res => res.text())
  .then(data => document.getElementById("apps").innerText = data);



fetch("http://localhost:8080/api/applyportal/admin/applystatusget/REVIEWED",
  {
    headers:
      {
          "Authorization": "Bearer " + localStorage.getItem("token")
      }
  })
  .then(res => res.text())
  .then(data => document.getElementById("reviewed").innerText = data);



fetch("http://localhost:8080/api/applyportal/admin/applystatusget/SELECTED",
  {
    headers:
      {
          "Authorization": "Bearer " + localStorage.getItem("token")
      }
  })
  .then(res => res.text())
  .then(data => document.getElementById("selected").innerText = data);

  

fetch("http://localhost:8080/api/applyportal/admin/applystatusget/REJECTED",
  {
    headers:
      {
          "Authorization": "Bearer " + localStorage.getItem("token")
      }
  })
  .then(res => res.text())
  .then(data => document.getElementById("rejected").innerText = data);



  function loginout()
  {
        localStorage.removeItem("token");
        localStorage.removeItem("userId");
        localStorage.removeItem("role");
        
        window.location.href="login.html";
  }



  function back()
{
    window.location.href="adminloginpage.html";
}
