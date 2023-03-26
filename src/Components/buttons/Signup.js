import React from'react'
import Dropdown  from 'react-bootstrap/Dropdown';
import { NavLink } from 'react-router-dom';

const Signup = () => {
    return(
        <Dropdown>
            <Dropdown.Toggle variant="success" id="dropdown-basic">
                Signup
            </Dropdown.Toggle>

            <Dropdown.Menu>
                
                <Dropdown.Item><NavLink className="nav-link active" to="/signupstaff">SignUp for Staff</NavLink></Dropdown.Item>
                <Dropdown.Item><NavLink className="nav-link active" to="/signupuser">SignUp for Staff</NavLink></Dropdown.Item>

            </Dropdown.Menu>
        </Dropdown>
    )
}

export default Signup;