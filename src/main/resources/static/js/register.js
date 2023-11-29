window.addEventListener('DOMContentLoaded', event => {
//on ready
});

async function registerUser(){

    let user = {};
    
    user.name=document.getElementById('inputFirstName').value;
    user.lastname=document.getElementById('inputLastName').value;
    user.phonenumber=document.getElementById('inputPhoneNumber').value;
    user.email=document.getElementById('inputEmail').value;
    user.password=document.getElementById('inputPassword').value;

    let passwordConfirm=document.getElementById('inputPasswordConfirm').value;

    if (passwordConfirm != user.password){
      alert('La confirmación de contraseña no coincide');
      return;
    }
    

    const response = await fetch ('api/userRegister', {
    method: 'POST',
    headers: {
      'Accept':'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
    });
    
    }
