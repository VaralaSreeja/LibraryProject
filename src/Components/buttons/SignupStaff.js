import React from 'react'
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';                                                                  

const SignupStaff = () => {
    
    const[email,setEmail] = useState('');
    const[password,setPassword] = useState('');
    const nav = useNavigate();

    function handleSubmit(event){
        event.preventDefault();
        fetch('http://localhost:9096/staff/signup',{
            method : 'POST',
            headers : {
                'Content-Type' : 'application/json'
            },
            body: JSON.stringify({"email": email, "spassword" : password})
        })

        .then(response => response.json())
        .then(data => {

            console.log(data.message);
            setEmail('');
            setPassword('');
            if(data.message === "Succesfully Registered"){
                alert("Staff is successfully registered");
            }
            else if(data.message === "Email already exists"){
                alert("Email already exists");
            }
            else if(data.message === "Invalid Data"){
                alert("Invalid Data");

            }
            else if(data.message === "Something Went Wrong "){
                alert("Something Went Wrong");
            }
            else{
                alert("Staff is registered! login now");
                nav.push('/loginstaff');
            }

        })
        .catch(error => console.error(error));
        
    };

    return(
        <div>
            <br></br>
            <br></br>
            <h3 style={{textAlign : "center"}}>Register Yourself</h3><br/>
            <div className="register" style={{ display: 'flex', justifyContent: 'center', alignItem: 'center' }}>

                <div className="shadow p-3 mb-5 bg-body-tertiary rounded">
                    <div className="vox" style={{ textAlign: "center" }}>
                        <h1>Signup for Staff </h1>
                        <br></br>
                        <input type="text" class="form-control" name="email" value={email} placeholder="email" onChange={(event) => setEmail(event.target.value)}></input>
                        <br></br>
                        <input type="text" class="form-control" name="spassword" value={password} placeholder="spassword" onChange={(event) => setPassword(event.target.value)}></input>
                        <br></br>
                        <button className="btn btn-primary btn-sm" type="submit" onClick={handleSubmit}>Signup</button>

                    </div>

                </div>

            </div>
        </div>
    );

}

export default SignupStaff;