import React from 'react'
import { useState } from 'react';
import axios from 'axios';
import { useHistory} from 'react-router-dom';
import { Link } from 'react-router-dom';


const LoginUser = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const handleSubmit = async (event) => {
        event.preventDefault();

        const response = await axios.post('http://localhost:8089/user/login',
            {

                "email_id": email,
                "password": password
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
                        <h1>Login for User </h1>
                        <br></br>
                        <input type="text" class="form-control" name="email_id" value={email} placeholder="email_id" onChange={(event) => setEmail(event.target.value)}></input>
                        <br></br>
                        <input type="text" class="form-control" name="password" value={password} placeholder="password" onChange={(event) => setPassword(event.target.value)}></input>
                        <br></br>
                        <button className="btn btn-primary btn-sm" type="submit" onClick={handleSubmit}>Login</button>

                    </div>

                </div>

            </div>
        </div>
    )

}
export default LoginUser;