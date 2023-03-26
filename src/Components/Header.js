// import React from 'react';
// import { NavLink } from 'react-router-dom';
// import Login from './buttons/Login';
// import Signup from './buttons/Signup';
// import CartBtn from './buttons/CartBtn';
// import Search from './Search';

// const Header = () => {
//     // const Search = () => {
//     //   const [query, setQuery] = useState("");
//     //   const [results, setResults] = useState([]);

//     //   const handleSearch = async (e) => {
//     //     e.preventDefault();
//     //     if(query.trim() === "") return;
//     //     const response = await fetch(`http://127.0.0.1:8002/books/${query}`);
//     //     const data= await response.json();
//     //     setResults(data.results);
//     //   }
//     return (
//         <div>
//             <nav className="navbar navbar-expand-lg navbar-light bg-light">
//                 <div className="container-fluid">

//                     <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
//                         <span className="navbar-toggler-icon"></span>
//                     </button>
//                     <div className="collapse navbar-collapse" id="navbarSupportedContent">
//                         <ul className="navbar-nav me-auto mb-2 mb-lg-0">
//                             <li className="nav-item">
//                                 <NavLink className="nav-link active" aria-current="page" to="/home">Home</NavLink>
//                             </li>
//                             <li className="nav-item">
//                                 <NavLink className="nav-link active" to="/books">Books</NavLink>
//                             </li>
//                             {/* <li className="nav-item">
//                                 <NavLink className="nav-link active" to="/contact">Contact</NavLink>
//                             </li> */}

//                         </ul>
//                         {/* <form className="d-flex">
//   <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
//   <button className="btn btn-outline-success" type="submit">Search</button>
// </form> */}
//                         <Search />

//                         <NavLink className="navbar-brand mx-auto fw-bold" to="/">ONLINE LIBRARY HUB </NavLink>
//                         <Login />
//                         <Signup />
//                         <CartBtn />

//                     </div>

//                 </div>
//             </nav>
//         </div>

//     )
// }
// export default Header;




import React from 'react';
import { NavLink } from 'react-router-dom';
import { Link } from 'react-router-dom';
import Login from './buttons/Login';
import Signup from './buttons/Signup';

const Header = () => {
    return (
        <div>
            <nav className="navbar navbar-expand-lg bg-body-tertiary">
                <div className="container-fluid">
                    <a className="navbar-brand mx-auto" >
                        ONLINE LIBRARY HUB
                    </a>
                    <button
                        className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarNavAltMarkup"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                    >

                    <span className="navbar-toggler-icon"></span>
                    </button>

                    <Link type="button" class="btn btn-primary" to= {'/Login'}>Login</Link>
                    <Link type="button" class="btn btn-primary" to= {'/Signup'}>Signup</Link>
                    <Link type="button" class="btn btn-primary" to= {'/Cart'}>CartBtn</Link>

                </div>
            </nav>

        </div>

    );
}
export default Header;