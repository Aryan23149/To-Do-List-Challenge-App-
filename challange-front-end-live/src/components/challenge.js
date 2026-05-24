function Challenge({challenge}){
    return (
        <a href="#" className="list-group-item list-group-item-action active" aria-current="true">
            <div className="d-flex w-100 justify-content-between">
            <h5 className="mb-1">{challenge.month}</h5>
            <p className="mb-1">{challenge.description}</p>
            </div>
        </a>
    )
}
export default Challenge; 