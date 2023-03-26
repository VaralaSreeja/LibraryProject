import React from'react'
import Dropdown  from 'react-bootstrap/Dropdown';
import { NavLink } from 'react-router-dom';

const Login = () => {
    return(
        <Dropdown>
            <Dropdown.Toggle variant="success" className= "btn ms-auto" id="dropdown-basic">
                Login
            </Dropdown.Toggle>

            <Dropdown.Menu>
                
                <Dropdown.Item><NavLink className="nav-link active" to="/loginstaff">Login for Staff</NavLink></Dropdown.Item>
                <Dropdown.Item><NavLink className="nav-link active" to="/loginuser">Login for User</NavLink></Dropdown.Item>

            </Dropdown.Menu>
        </Dropdown>
    )
}

export default Login;