fetch("http://localhost:8080/api/userlogin/count")
  .then(res => res.text())
  .then(data => document.getElementById("users").innerText = data);

fetch("http://localhost:8080/api/jobdetails/count")
  .then(res => res.text())
  .then(data => document.getElementById("jobs").innerText = data);

fetch("http://localhost:8080/api/applyportal/count")
  .then(res => res.text())
  .then(data => document.getElementById("apps").innerText = data);

fetch("http://localhost:8080/api/applyportal/applystatusget/REVIEWED")
  .then(res => res.text())
  .then(data => document.getElementById("reviewed").innerText = data);

fetch("http://localhost:8080/api/applyportal/applystatusget/SELECTED")
  .then(res => res.text())
  .then(data => document.getElementById("selected").innerText = data);

fetch("http://localhost:8080/api/applyportal/applystatusget/REJECTED")
  .then(res => res.text())
  .then(data => document.getElementById("rejected").innerText = data);

  function loginout()
  {
        window.location.href="login.html";
  }

  function back()
{
    window.location.href="adminloginpage.html";
}
