import React from 'react';
import { NavLink } from 'react-router-dom';
import CartBtn from './buttons/CartBtn';
import LoginStaff from './buttons/LoginStaff';
import SignupStaff from './buttons/SignupStaff';


const HeaderStaff = () => {
    return (
<div>
            <nav className ="navbar navbar-expand-lg navbar-light bg-light">
                <div className ="container-fluid">
                    
                    <button className ="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className ="navbar-toggler-icon"></span>
                    </button>
                    <div className ="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className ="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className ="nav-item">
                                <NavLink className ="nav-link active" aria-current="page" to="/home">Home</NavLink>
                            </li>
                            <li className ="nav-item">
                                <NavLink className ="nav-link active" to="/books">Books</NavLink>
                            </li>  
                            <li className ="nav-item">
                                <NavLink className ="nav-link active" to="/staff">Staff</NavLink>
                            </li>
                            {/* <li className ="nav-item">
                                <NavLink className ="nav-link active" to="/contact">Contact</NavLink>
                            </li> */}
                        </ul>
                        <form className ="d-flex">
                            <input className ="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                                <button className ="btn btn-outline-success" type="submit">Search</button>
                        </form>
                        <NavLink className ="navbar-brand mx-auto fw-bold" to="#">ONLINE LIBRARY HUB</NavLink>
                    <LoginStaff/>
                    <SignupStaff/>
                    <CartBtn/>
                    </div>
                    
                </div>
            </nav>
        </div>
    )}
export default HeaderStaff;