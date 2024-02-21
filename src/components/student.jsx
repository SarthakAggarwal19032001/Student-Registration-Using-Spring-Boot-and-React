import axios from 'axios';
import {useEffect, useState } from "react";

function Student()
{
  const [id, setId] = useState('');
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [mobile, setMobile] = useState("");
  const [students, setStudents] = useState([]);

useEffect(() => {
  (async () => await Load())();
  }, []);


  async function  Load()
  {
     const result = await axios.get(
         "http://localhost:8089/api/v1/students/getAll");
         setStudents(result.data);

  }
 
     async function save(event)
    {
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8089/api/v1/students/save",
        {
          id: id,
          name: name,
          address: address,
          mobile: mobile
        });
          alert("Student Registation Successfully");
          setId("");
          setName("");
          setAddress("");
          setMobile("");
          Load();
        }
    catch(err)
        {
          alert("User Registation Failed");
        }
   }

   async function editStudent(student)
   {
    setName(student.name);
    setAddress(student.address);
    setMobile(student.mobile); 
    setId(student.id);
   }

   async function DeleteStudent(id)
   {
        await axios.delete("http://localhost:8089/api/v1/students/delete/" + id); 
        alert("Employee deleted Successfully");
        Load();
   }

   async function update(event)
   {
    event.preventDefault();

   try
       {
        await axios.put("http://localhost:8089/api/v1/students/update",
       {
        id: id,
        name: name,
        address: address,
        mobile: mobile
       });
        alert("Updated");
         setId("");
         setName("");
         setAddress("");
         setMobile("");
         Load();
       }
   catch(err)
       {
         alert("Student Updation Failed");
       }
  }



  return (
    <div>
       
       <div class="container mt-4" >
       <h1 class="align-content-center">Student Details</h1>
          <form>
              <div class="form-group">
              <label>Student Id</label>
               <input  type="text" class="form-control" id="id" value={id}
               onChange={(event) =>
                {
                  setId(event.target.value);      
                }} 
               />
              </div>

              <div class="form-group">
                <label>Student Name</label>
                <input  type="text" class="form-control" id="name"
                value={name}
                onChange={(event) =>
                  {
                    setName(event.target.value);      
                  }}
                />
              </div>

              <div class="form-group">
                <label>Student Address</label>
                <input  type="text" class="form-control" id="address" 
                 value={address}
                  onChange={(event) =>
                    {
                      setAddress(event.target.value);      
                    }}
                />
              </div>

              <div class="form-group">
                <label>Mobile</label>
                <input type="text" class="form-control" id="mobile" 
                  value={mobile}
                onChange={(event) =>
                  {
                    setMobile(event.target.value);      
                  }}
                />
              </div>


              <div>
              <button   class="btn btn-primary m-2"  onClick={save}>Register</button>

              <button   class="btn btn-warning m-2"  onClick={update}>Update</button>
              </div>   

            </form>

<table class="table table-dark mt-4" align="center" >
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">Mobile</th>
      
      <th scope="col">Option</th>
    </tr>
  </thead>
       {students.map(function fn(student)
       {
            return(
            <tbody>
                <tr>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.address}</td>
                <td>{student.mobile}</td>        
                <td>
                    <button type="button" class="btn btn-warning m-1"  onClick={() => editStudent(student)} >Edit</button>  
                    <button type="button" class="btn btn-danger m-1" onClick={() => DeleteStudent(student.id)}>Delete</button>
                </td>
                </tr>
            </tbody>
            );
            })}
            </table>
            </div>
       </div>
            );
        }

  export default Student;