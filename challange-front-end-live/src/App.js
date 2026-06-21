import logo from './logo.svg';
import './App.css';
import Greeting from './components/Greeting';
import ChallengeList from './components/ChallengeList';
import { useEffect, useState } from "react"; 
import axios from 'axios';
import AddChallenge from './components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';
import API_BASE_URL from './api';


function App() {
  const [challenges , setChallenges]= useState([]); 

  useEffect(() => {
    fetchChallenges();
  },[])
  const fetchChallenges= async() => {
    try{
      const response = await axios.get(
        `${API_BASE_URL}/challenges`
      );
      console.log(response.data);
      setChallenges(response.data);
    }
    catch(error){
      console.error("ERROR FETCHING CHALLENGES: ",error);
    }
  };   
  const handleChallengeAdded=()=>{
    fetchChallenges();
  };
  return (
    <div className="container mt-5">
      <h1 className='text-center mb-4'>Monthly Challenges</h1> 
      <AddChallenge onChallengeAdded ={handleChallengeAdded}/>
      <ChallengeList challenges = {challenges}/>
    </div>
  );
}
 
export default App;
