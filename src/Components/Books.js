import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'
import { useState } from 'react';
import { useEffect } from 'react';

const Books = () => {
    

    const [column,setColumn] = useState([])
    const [records,setRecords] = useState([])

    useEffect(() => {
        fetch("http://localhost:9004/book",{
            method:'GET',
            headers: {
                'Content-Type' : 'application/json'
            },
        })
        .then(res => res.json())
        .then(data =>{
            setColumn(Object.keys(data.books[0]))
            setRecords(data.books)
        })
    },[])
    return (
        <div>
            <table className='table'>
                <thead>
                    <tr>
                        {column.map((c,i) =>(
                            <th key = {i}>{c}</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {
                        records.map((record,i) => (
                            <tr key = {i}>
                                <td>{record.Book_id}</td>
                                <td>{record.Book_name}</td>
                                <td>{record.Book_author}</td>
                                <td>{record.Book_category}</td>
                                <td>{record.quantity}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}
export default Books;