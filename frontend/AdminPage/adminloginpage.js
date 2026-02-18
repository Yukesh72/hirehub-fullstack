const role=localStorage.getItem("role");

if(role!==ADMIN)
{
    alert("you are not an admin bro");
    window.location.href="login.html";
}

function addjob()
{
    window.location.href = "admin.html";
}
function enroll()
{
    window.location.href="adminstatus.html";
}
function dashboard()
{
    window.location.href="admindashboard.html";
}
function viewuser()
{
    window.location.href="viewuser.html";
}
function logout()
{
    window.location.href="login.html";
}
function getstat()
{
    window.location.href="getbystatus.html";
}