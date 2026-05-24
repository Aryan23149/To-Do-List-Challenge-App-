// function Greeting({Name}){
//     return <h2>Hello ! {Name}! </h2>
// }
// export default Greeting;

import { useState } from "react";


function Greeting({name,message}){
    const [messageState , setMessage]= useState(message)
    return (
    <div>
    <h2>Hello ! {name}! </h2>
    <p>{messageState}</p>
    <button onClick={()=> setMessage('GoodBye')}> Change Message </button>
    </div>
    )
}
export default Greeting;