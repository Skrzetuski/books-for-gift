import React, {useEffect, useState} from 'react';
import {useTable, useFilters} from 'react-table';


function TitleColumnFilter({  column: { filterValue, preFilteredRows, setFilter },}) {
  
  const count = preFilteredRows.length;

  return (
    <>
      <div className="input-group mb-3">
        <input className="form-control"
          value={filterValue || ''}
          placeholder={`Wyszukaj wśród ${count} pozycji`}
          onChange={e => {
            setFilter(e.target.value || undefined)}}
        />
      </div>
    </>
  )  
}

function AuthorColumnFilter({  column: { filterValue, setFilter },}) {

  return (
    <>
      <div className="input-group mb-3">
        <input className="form-control"
          value={filterValue || ''}
          placeholder={`Znajdź po autorze`}
          onChange={e => {
            setFilter(e.target.value || undefined)}}
        />
      </div>
    </>
  )
}


function Table({ columns, data }) {
  const defaultColumn = React.useMemo(
    () => ({
      Filter: TitleColumnFilter,
    }),
    []
  )
  const {
    getTableProps,
    getTableBodyProps,
    headerGroups,
    rows,
    prepareRow,
  } = useTable({
    columns,
    data,
    defaultColumn,
  }, 
    useFilters
  )
  return (
    
    <div>
    <table className="table" {...getTableProps()}>
      <thead>
        {headerGroups.map(headerGroup => (
          <tr {...headerGroup.getHeaderGroupProps()}>
            {headerGroup.headers.map(column => (
              <th scope="col" {...column.getHeaderProps()}>{column.render('Header')}
                        <div key={column.id}>
            {column.canFilter ? column.render('Filter') : null}
            </div>  
              </th>
            ))}
          </tr>
        ))}
      </thead>
      <tbody {...getTableBodyProps()}>
        {rows.map(
          (row, i) => {
            prepareRow(row);
            return (
              <tr {...row.getRowProps()}>
                {row.cells.map(cell => {
                  console.log(cell.render('Cell'));
                  return <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
                })}
              </tr>
            )}
        )}
      </tbody>
    </table>
    </div>
  )
}

function List(prop){

  const [data, setData] = useState([]);

  async function fetchData(){

    const res = await fetch("http://localhost:8080/api/books",
    {
      headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json'
       }}
    );

    res
      .json()
      .then(res => setData(res));

  }

  useEffect(()=>{

    fetchData();
  }, [])


  const columns = React.useMemo(
    () => [
      {
        Header: 'Tytuł',
        accessor: 'title',
        Filter: TitleColumnFilter,
      },
      {
        Header: 'Autor',
        accessor: 'author',
        Filter: AuthorColumnFilter,
      },
    ],
    []
  )

  
  if(prop.state === true){
    return (
        
      <div>
        <Table columns={columns} data={data} />
      </div>
    );
  }else {
      return("");
  }
}

export default List;
