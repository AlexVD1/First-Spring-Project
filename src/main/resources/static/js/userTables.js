window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
    loadUsers();
    const userTable = document.getElementById('userTable');
    if (userTable) {
        new simpleDatatables.DataTable(userTable);
    }
});

async function loadUsers(){
        const response = await fetch('api/listUsers', {
          method: 'GET', // *GET, POST, PUT, DELETE, etc.
          headers: {
            'Accept':'application/json',
            'Content-Type': 'application/json'
          },
         });
        const users = await response.json();
        console.log(users);

        let listUsersHtml='';
        for (let u of users)
        {
            let btnDelete='<a href ="#" onclick="deleteUser('+u.id+')" class="btn btn-danger btn btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

            let user ='<tr><td>'+u.id+'</td><td>'+u.name+'</td><td>'+u.lastname+'</td><td>'+u.email+'</td><td>'+u.phonenumber+'</td><td>'+u.password+'</td>'+'<td>'+btnDelete+'</td></tr>';
            listUsersHtml+=user;
        }
        document.querySelector('#userTable tbody').outerHTML = listUsersHtml;

    }

async function deleteUser(id)
{
if (confirm('SURE?'))
{
const response = await fetch('api/userDelete/'+id, {
           method: 'DELETE', // *GET, POST, PUT, DELETE, etc.
           headers: {
             'Accept':'application/json',
             'Content-Type': 'application/json'
           },
          });
   alert('User deleted');
}

location.reload()

}