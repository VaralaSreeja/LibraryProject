import React from 'react'
import { useState } from 'react';
import {useNavigate} from 'react-router-dom';


const SignupUser = () => {
    
    const[email,setEmail] = useState('');
    const[password,setPassword] = useState('');
    const nav = useNavigate();

    function handleSubmit(event){
        event.preventDefault();
        fetch('http://localhost:8089/user/signup',{
            method : 'POST',
            headers : {
                'Content-Type' : 'application/json'
            },
            body: JSON.stringify({"email_id": email, "password" : password})
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
                nav.push('/loginuser');
            }

        })
        .catch(error => console.error(error));
        
    };

    const handleEmail = (event)=>{
        setEmail(event.target.value);
    }

    const handlePassword = (event)=>{
        setPassword(event.target.value);
    }

    return(
        <div>
            <br></br>
            <br></br>
            <h3 style={{textAlign : "center"}}>Register Yourself</h3><br/>
            <div className="register" style={{ display: 'flex', justifyContent: 'center', alignItem: 'center' }}>

                <div className="shadow p-3 mb-5 bg-body-tertiary rounded">
                    <div className="vox" style={{ textAlign: "center" }}>
                        <h1>Signup for User </h1>
                        <br></br>
                        <input type="text" class="form-control" name="email_id" value={email} placeholder="email_id" onChange={(event) => setEmail(event.target.value)}></input>
                        <br></br>
                        <input type="text" class="form-control" name="password" value={password} placeholder="password" onChange={(event) => setPassword(event.target.value)}></input>
                        <br></br>
                        <button className="btn btn-primary btn-sm" type="submit" onClick={handleSubmit}>Signup</button>

                    </div>

                </div>

            </div>
        </div>
    );

}

export default SignupUser;