window.addEventListener('DOMContentLoaded', event => {
    //on ready
    });
    
    async function login(){
    
        let data = {};
        
        data.email=document.getElementById('inputEmail').value;
        data.password=document.getElementById('inputPassword').value;        
    
        const response = await fetch ('api/login', {
        method: 'POST',
        headers: {
          'Accept':'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
        });
        
        const r = await response.json();
        console.log(r);

        if(!r){
            alert("WRONG CREDENTIALS");
            return;
        }
        
        window.location.href="users.html";

        }
    