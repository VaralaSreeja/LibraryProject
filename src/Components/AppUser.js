// import {Redirect,Route,Switch} from 'react-router-dom';
import { BrowserRouter as Router,Routes,Route } from 'react-router-dom';
import HeaderUser from './HeaderUser';
import Home from './Home';
import Books from './Books';

function AppUser() {
    return (
      <>
       <HeaderUser/>
       <Router>
       {/* <Switch> */}
       <Routes>

            <Route exact path="/" component={Home}/>
            <Route exact path="/books" component={Books}/>
            {/* <Route exact path="/contact" component={Contact}/> */}
            <Route exact path="/headeruser" component={HeaderUser}/>
            {/* <Redirect exact path = "/"></Redirect> */}
       {/* </Switch> */}
       {/* <Footer/> */}
       </Routes>
       </Router>
      </>
    );
  }
  
  export default AppUser;