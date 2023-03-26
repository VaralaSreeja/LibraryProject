
import './App.css';
import Footer from './Components/Footer';
import Books from './Components/Books';
import Home from './Components/Home';
import Header from './Components/Header';
// import {Redirect,Route,Switch} from 'react-router-dom';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import SignupStaff from './Components/buttons/SignupStaff';
import SignupUser from './Components/buttons/SignupUser';
import LoginUser from './Components/buttons/LoginUser';
import LoginStaff from './Components/buttons/LoginStaff';
import HeaderUser from './Components/HeaderUser';
import HeaderStaff from './Components/HeaderStaff';
import AppUser from './Components/AppUser';

function App() {
  return (
    <div >
      <Header/>
      <Router>

      <Route>
      {/* <Switch> */}
        <Route exact path="/" component = {Home}/>
        <Route exact path="/books" component = {Books}/>
        <Route exact path="/signupstaff" component = {SignupStaff}/>
        <Route exact path="/signupuser" component = {SignupUser}/>
        <Route exact path="/loginstaff" component = {LoginStaff}/>
        <Route exact path="/loginuser" component = {LoginUser}/>
        <Route exact path="/headerstaff" component = {HeaderStaff}/>
        <Route exact path="/headeruser" component = {HeaderUser}/>
        <Route exact path="/appuser" component = {AppUser}/>
        
        </Route>
      {/* </Switch> */}
      </Router>
       <Footer/> 
    </div>
  );
}

export default App;
