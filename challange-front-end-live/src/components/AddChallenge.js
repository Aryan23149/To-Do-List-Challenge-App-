import { useState } from "react";
import axios from "axios";
import API_BASE_URL from "../api";
function AddChallenge({onChallengeAdded}){
    const [month,setMonth]=useState('');
    const [description,setDescription]=useState('');
    const handleSubmit=async(e)=>{
        e.preventDefault();
        try{
            await axios.post(
                `${API_BASE_URL}/challenges`,
                { month, description }
              );
            setMonth('');
            setDescription('');
            onChallengeAdded();
        }
        catch(error){
            console.error("Error Adding Challenge",{error});
        }
    }
    return(
        <div className="card my-5">
            <div class="card-header">Add New Challenge</div>
            <div className="card"></div>
            <form onSubmit={handleSubmit}> 
                <div className="mb-3">
                    <label htmlFor="month" className="form-label">Month</label>
                    <input type="text"className="form-control" placeholder="for ex : January, February etc." aria-label="for ex : January, February etc." aria-describedby="basic-addon1" id="month" value={month} onChange={(e)=>setMonth(e.target.value)} required></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="description" className="form-label">Description</label>
                    <input type="text" className = "form-control" placeholder="Describe the Challenge" aria-label="Describe the Challenge" aria-describedby="basic-addon1" id="description" value={description} onChange={(e)=>setDescription(e.target.value)} required></input>
                </div>
                <button type="submit" className="btn btn-primary">SUBMIT</button>
            </form>
        </div>

    )
}
export default AddChallenge;