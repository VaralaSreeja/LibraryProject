import React from 'react'
import { useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'


const LoginStaff = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const handleSubmit = async (event) => {
        event.preventDefault();

        const response = await axios.post('http://localhost:9096/staff/login',
            {

                "email": email,
                "spassword": password
            }
        );
        localStorage.setItem('token', response.data.token);
        if (response === 403) {
            console.log("Incorrect email or password")
            alert("Incorrect email or password")
        }
        else {
            console.log("successfully logged in")
            alert("logged in successfully")
        }
        window.location.href = '/';

    };

    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    };
    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    return (
        <div>
            <br></br>
            <br></br>
            <div className="register" style={{ display: 'flex', justifyContent: 'center', alignItem: 'center' }}>
                <div className="shadow p-3 mb-5 bg-body-tertiary rounded">
                    <div className="vox" style={{ textAlign: "center" }}>
                        <h1>Login for Staff </h1>
                        <br></br>
                        <input type="text" class="form-control" name="email" value={email} placeholder="email" onChange={(event) => setEmail(event.target.value)}></input>
                        <br></br>
                        <input type="text" class="form-control" name="spassword" value={password} placeholder="spassword" onChange={(event) => setPassword(event.target.value)}></input>
                        <br></br>
                        <button className="btn btn-primary btn-sm" type="submit" onClick={handleSubmit}>Login</button>

                    </div>

                </div>

            </div>
        </div>
    )

}
export default LoginStaff;