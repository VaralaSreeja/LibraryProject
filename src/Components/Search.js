import React from 'react'
import { useState } from 'react';


const Search = () => {
    const [query, setQuery] = useState("");
    const [results, setResults] = useState([]);

    const handleSearch = async (e) => {
        e.preventDefault();
        if(query.trim() === "") return;
        const response = await fetch(`http://127.0.0.1:8002/books/${query}`);
        const data= await response.json();
        setResults(data.results);
    }



    return (
        <div>
            {/* <form className="d-flex" role="search">
                <input className="form-control" type="search" placeholder="Search" aria-label="Search" />
                <button className="btn btn-outline-success mx-6 ms-1" type="submit">Search</button>
            </form> */}

            <form onSubmit={handleSearch}>
                <input type="text" value={query} onChange={(e) => setQuery(e.target.value)}/>
                <button className="btn btn-outline-dark mx-6 ms-1" type="submit">Search</button>
            </form>

            {results.length > 0 ? (
                <ul>
                    {results.map((books) => (
                        <li key={books.Book_id}>
                            <h3>{books.Book_name}</h3>
                            <p>{books.book_author}</p>
                            <p>{books.book_category}</p>
                            
                            
                            </li>)
                    )}
                </ul>

            ):(
                <p>No results found</p>
            )}

        </div>
    );
}

export default Search;