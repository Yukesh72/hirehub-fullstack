function register()
{
    fetch("http://localhost:8080/api/userlogin/register",
        {
           method:"POST",
           headers:{"Content-Type":"application/json"},
           body:JSON.stringify({
                name:document.getElementById("name").value,
                email:document.getElementById("email").value,
                password:document.getElementById("password").value
           })
        })
        .then(res=>
        {
            if(!res.ok)throw new Error("User Already exist js");
            return res.json();
            
        })
        .then(()=>
        {
            alert("Register successful ✅")
            window.location.href="login.html";
        })
        .catch(err=>alert(err.message));
}
