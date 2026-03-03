const userId=localStorage.getItem("userId");
const role=localStorage.getItem("role");
const token=localStorage.getItem("token");
function searchjobs()
{
    window.location.href="jobs.html";
}
function applied()
{
    window.location.href="application.html";
}
function viewbystatus()
{
    window.location.href="viewbystatus.html";
}
console.log(userId);
console.log(role);
console.log(token);