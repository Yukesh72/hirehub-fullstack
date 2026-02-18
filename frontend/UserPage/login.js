function login(event)
{                                                  //login page
    event.preventDefault();
    const email=document.getElementById("email").value;
    const password=document.getElementById("password").value;

    fetch("http://localhost:8080/api/userlogin/login",
        {
            method:"POST",
            headers:
            {
                "Content-Type" : "application/json"
            },
            body:JSON.stringify
            ({
                email:email,
                password:password
            })
        })
        .then(async res=>{
            if(!res.ok)
            {
                const msg = await res.text();
                throw new Error(msg || "Login failed");
            }
            return res.json();
        })
        .then(data=>
        {
            localStorage.setItem("userId",data.id);
            localStorage.setItem("role",data.role);

            alert("Login Successfully !");

            if (data.role === "ADMIN")
            {
                window.location.href ="adminloginpage.html";
            } 
            else 
            {
                window.location.href = "mainuserpage.html";
            }
        })
        .catch(err=>
        {
            alert(err.message ||"Invalid Email and Password Sorry !");
            console.log(err);
        }
        );
}
function newregister()
{
    window.location.href="register.html";
}


